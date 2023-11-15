package hr.foi.air.popapp.navigation.components.registration

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import hr.foi.air.popapp.ui.components.PasswordTextField
import hr.foi.air.popapp.ui.components.StyledButton
import hr.foi.air.popapp.ui.components.StyledTextField
import hr.foi.air.popapp.viewmodels.RegistrationViewModel

@Composable
fun RegistrationPage(
    viewModel: RegistrationViewModel = viewModel(),
    onSuccessfulRegistration: (newUsername: String) -> Unit
) {
    val firstName = viewModel.firstName.observeAsState().value ?: ""
    val lastName = viewModel.lastName.observeAsState().value ?: ""
    val username = viewModel.username.observeAsState().value ?: ""
    val email = viewModel.email.observeAsState().value ?: ""
    val password = viewModel.password.observeAsState().value ?: ""
    val confirmPassword = viewModel.confirmPassword.observeAsState().value ?: ""
    val role = viewModel.role.observeAsState().value ?: ""

    var isAwaitingResponse by remember { mutableStateOf(false) }
    val errorMessage = viewModel.errorMessage.observeAsState().value ?: ""
    var roleDropdownExpanded by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        Text(
            text = "Create an Account",
            style = MaterialTheme.typography.h4,
        )

        if (errorMessage.isBlank()) {
            Text(
                text = errorMessage,
                color = Color.Red
            )
        }

        StyledTextField(
            label = "First name",
            value = firstName,
            onValueChange = { viewModel.firstName.value = it })

        StyledTextField(
            label = "Last name",
            value = lastName,
            onValueChange = { viewModel.lastName.value = it })

        StyledTextField(
            label = "Username",
            value = username,
            onValueChange = { viewModel.username.value = it })

        StyledTextField(
            label = "Email",
            value = email,
            onValueChange = { viewModel.email.value = it })

        PasswordTextField(
            label = "Password",
            value = password,
            onValueChange = { viewModel.password.value = it })

        PasswordTextField(
            label = "Confirm password",
            value = confirmPassword,
            onValueChange = { viewModel.confirmPassword.value = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
        )

        Text(
            text = "Choose your starting role:",
            style = MaterialTheme.typography.h6,
        )
        for (roleName in viewModel.possibleRoles) {
            Row {
                Checkbox(
                    checked = role == roleName,
                    onCheckedChange = { viewModel.role.value = roleName }
                )
                Text(
                    text = roleName,
                    modifier = Modifier.padding(top = 12.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(50.dp))

        StyledButton(
            label = "Register",
            enabled = !isAwaitingResponse,
            onClick = {
                isAwaitingResponse = true

                viewModel.registerUser(
                    onSuccess = {
                        isAwaitingResponse = false
                        onSuccessfulRegistration(username)
                    },
                    onFail = {
                        isAwaitingResponse = false
                    }
                )
            }
        )
    }
}

@Preview
@Composable
fun RegistrationPagePreview() {
    RegistrationPage(onSuccessfulRegistration = {})
}
