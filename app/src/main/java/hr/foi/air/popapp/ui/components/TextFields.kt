package hr.foi.air.popapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun PasswordTextField(
    label: String,
    value: String,
    onValueChange: (newValue: String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next)
) {
    StyledTextField(
        label = label,
        value = value,
        onValueChange = onValueChange,
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = keyboardOptions
    )
}

@Composable
fun StyledTextField(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    singleLine: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
    onValueChange: (newValue: String) -> Unit,
) {
    OutlinedTextField(
        label = { Text(label) },
        value = value,
        onValueChange = onValueChange,
        visualTransformation = visualTransformation,
        singleLine = singleLine,
        keyboardOptions = keyboardOptions,
        modifier = modifier.fillMaxWidth(),
        colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = MaterialTheme.colors.primaryVariant)
    )
}
