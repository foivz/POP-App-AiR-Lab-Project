package hr.foi.air.popapp.navigation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hr.foi.air.popapp.context.Auth
import hr.foi.air.popapp.core.login.LoginHandler
import hr.foi.air.popapp.core.login.LoginOutcomeListener
import hr.foi.air.popapp.core.login.LoginUserData
import hr.foi.air.popapp.login_username_password.UsernamePasswordLoginHandler
import hr.foi.air.popapp.login_username_password.UsernamePasswordLoginToken
import hr.foi.air.popapp.ui.components.PasswordTextField
import hr.foi.air.popapp.ui.components.StyledButton
import hr.foi.air.popapp.ui.components.StyledTextField

@Composable
fun LoginPage(
    onSuccessfulLogin: () -> Unit,
    loginHandler: LoginHandler
) {
    var username by remember { mutableStateOf("sbarry") }
    var password by remember { mutableStateOf("test123") }

    var awaitingResponse by remember { mutableStateOf(false) }
    var errorMessage by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        if (errorMessage == "") {
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

        StyledTextField(label = "Username", value = username, onValueChange = { username = it })
        PasswordTextField(
            label = "Password",
            value = password,
            onValueChange = { password = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
        )

        Spacer(modifier = Modifier.height(50.dp))

        StyledButton(
            label = "Login",
            enabled = !awaitingResponse,
            onClick = {
                val usernamePasswordToken = UsernamePasswordLoginToken(username, password)

                awaitingResponse = true

                loginHandler.handleLogin(usernamePasswordToken, object : LoginOutcomeListener {
                    override fun onSuccessfulLogin(loginUserData: LoginUserData) {
                        awaitingResponse = false
                        Auth.loggedInUserData = loginUserData
                        onSuccessfulLogin()
                    }

                    override fun onFailedLogin(reason: String) {
                        awaitingResponse = false
                        errorMessage = reason
                    }
                })
            }
        )
    }
}

@Preview
@Composable
fun LoginPagePreview() {
    LoginPage({}, UsernamePasswordLoginHandler())
}
