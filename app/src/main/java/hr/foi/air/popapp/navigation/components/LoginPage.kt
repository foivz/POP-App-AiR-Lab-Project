package hr.foi.air.popapp.navigation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hr.foi.air.popapp.ui.components.PasswordTextField
import hr.foi.air.popapp.ui.components.StyledButton
import hr.foi.air.popapp.ui.components.StyledTextField

@Composable
fun LoginPage() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "With your POP-App account you can log in the application. " +
                    "Please note that the course teacher needs to approve your account before you can successfully log in."
        )

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
            onClick = { }
        )
    }
}

@Preview
@Composable
fun LoginPagePreview() {
    LoginPage()
}
