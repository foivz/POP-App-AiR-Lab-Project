package hr.foi.air.popapp.navigation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import hr.foi.air.popapp.core.login.LoginHandler
import hr.foi.air.popapp.login_username_password.UsernamePasswordLoginHandler
import hr.foi.air.popapp.login_username_password.UsernamePasswordLoginToken
import hr.foi.air.popapp.ui.components.PasswordTextField
import hr.foi.air.popapp.ui.components.StyledButton
import hr.foi.air.popapp.ui.components.StyledTextField
import hr.foi.air.popapp.viewmodels.LoginViewModel

@Composable
fun LoginPage(
    viewModel: LoginViewModel = viewModel(),
    onSuccessfulLogin: () -> Unit,
    loginHandler: LoginHandler
) {
    val username = viewModel.username.observeAsState().value!!
    val password = viewModel.password.observeAsState().value!!

    var awaitingResponse by remember { mutableStateOf(false) }
    val errorMessage = viewModel.errorMessage.observeAsState().value!!

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        if (errorMessage.isBlank()) {
            Text(
                "With your POP-App account you can log in the application. " +
                        "Please note that the course teacher needs to approve your account before you can successfully log in."
            )
        } else {
            Text(
                text = errorMessage,
                modifier = Modifier.fillMaxWidth(),
                color = Color.Red,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(50.dp))

        StyledTextField(
            label = "Username",
            value = username,
            onValueChange = { viewModel.username.value = it })
        PasswordTextField(
            label = "Password",
            value = password,
            onValueChange = { viewModel.password.value = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
        )

        Spacer(modifier = Modifier.height(50.dp))

        StyledButton(
            label = "Login",
            enabled = !awaitingResponse,
            onClick = {
                val usernamePasswordToken = UsernamePasswordLoginToken(username, password)
                awaitingResponse = true
                viewModel.login(loginHandler, usernamePasswordToken, onSuccessfulLogin = onSuccessfulLogin)
            }
        )
    }
}

@Preview
@Composable
fun LoginPagePreview() {
    LoginPage(
        onSuccessfulLogin = {},
        loginHandler = UsernamePasswordLoginHandler()
    )
}
