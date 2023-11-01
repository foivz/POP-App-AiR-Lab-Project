package hr.foi.air.popapp.navigation.components.registration

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hr.foi.air.popapp.core.login.network.ResponseListener
import hr.foi.air.popapp.core.login.network.models.ErrorResponseBody
import hr.foi.air.popapp.core.login.network.models.SuccessfulResponseBody
import hr.foi.air.popapp.ui.components.PasswordTextField
import hr.foi.air.popapp.ui.components.StyledButton
import hr.foi.air.popapp.ui.components.StyledTextField
import hr.foi.air.popapp.ws.models.RegistrationBody
import hr.foi.air.popapp.ws.request_handlers.RegistrationRequestHandler

@Composable
fun RegistrationPage(
    onSuccessfulRegistration: (newUsername: String) -> Unit
) {
    var firstName by remember {
        mutableStateOf("")
    }
    var lastName by remember {
        mutableStateOf("")
    }
    var username by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var confirmPassword by remember {
        mutableStateOf("")
    }
    var isAwaitingResponse by remember {
        mutableStateOf(false)
    }
    var errorMessage by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        Text(
            text = "Create an Account",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        if (errorMessage != "") {
            Text(
                text = errorMessage,
                color = Color.Red
            )
        }

        StyledTextField(label = "First name", value = firstName, onValueChange = { firstName = it })

        StyledTextField(label = "Last name", value = lastName, onValueChange = { lastName = it })

        StyledTextField(label = "Username", value = username, onValueChange = { username = it })

        StyledTextField(label = "Email", value = email, onValueChange = { email = it })

        PasswordTextField(label = "Password", value = password, onValueChange = { password = it })

        PasswordTextField(
            label = "Confirm password",
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
        )

        Spacer(modifier = Modifier.height(50.dp))

        StyledButton(
            label = "Register",
            enabled = !isAwaitingResponse,
            onClick = {
                val requestBody = RegistrationBody(
                    firstName,
                    lastName,
                    username,
                    email,
                    password,
                    "buyer"
                )

                val registrationRequestHandler = RegistrationRequestHandler(requestBody)
                isAwaitingResponse = true

                registrationRequestHandler.sendRequest(object : ResponseListener {
                    override fun <T> onSuccessfulResponse(response: SuccessfulResponseBody<T>) {
                        isAwaitingResponse = false
                        onSuccessfulRegistration(username)
                    }

                    override fun onErrorResponse(response: ErrorResponseBody) {
                        isAwaitingResponse = false

                        errorMessage = response.message + " "
                        errorMessage += when (response.error_code) {
                            101 -> "Check username."
                            102 -> "Username is already used. Please enter another one."
                            103 -> "Email is invalid."
                            104 -> "Email entered is already used. Do you already have an account?"
                            105 -> "Password is invalid. Make sure it has at least 7 characters with at least 1 number."
                            106 -> "Selected role is invalid!"
                            107 -> "First name is invalid!"
                            108 -> "Last name is invalid!"
                            else -> ""
                        }
                    }

                    override fun onNetworkFailure(t: Throwable) {
                        isAwaitingResponse = false
                        errorMessage = "Network error occured, please try again later..."
                    }
                })
            }
        )
    }
}

@Preview
@Composable
fun RegistrationPagePreview() {
    RegistrationPage({})
}
