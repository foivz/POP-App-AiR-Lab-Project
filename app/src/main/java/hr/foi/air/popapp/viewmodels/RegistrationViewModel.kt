package hr.foi.air.popapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hr.foi.air.popapp.core.login.network.ResponseListener
import hr.foi.air.popapp.core.login.network.models.ErrorResponseBody
import hr.foi.air.popapp.core.login.network.models.SuccessfulResponseBody
import hr.foi.air.popapp.ws.models.RegistrationBody
import hr.foi.air.popapp.ws.request_handlers.RegistrationRequestHandler

class RegistrationViewModel : ViewModel() {
    val firstName: MutableLiveData<String> = MutableLiveData("")
    val lastName: MutableLiveData<String> = MutableLiveData("")
    val username: MutableLiveData<String> = MutableLiveData("")
    val email: MutableLiveData<String> = MutableLiveData("")
    val password: MutableLiveData<String> = MutableLiveData("")
    val confirmPassword: MutableLiveData<String> = MutableLiveData("")
    val role: MutableLiveData<String> = MutableLiveData("buyer")

    private val _errorMessage: MutableLiveData<String> = MutableLiveData("")
    val errorMessage: LiveData<String> = _errorMessage


    fun registerUser(onSuccess: () -> Unit, onFail: () -> Unit) {
        val requestBody = RegistrationBody(
            firstName.value!!,
            lastName.value!!,
            username.value!!,
            email.value!!,
            password.value!!,
            role.value!!,
        )
        val registrationRequestHandler = RegistrationRequestHandler(requestBody)

        registrationRequestHandler.sendRequest(object : ResponseListener {
            override fun <T> onSuccessfulResponse(response: SuccessfulResponseBody<T>) {
                onSuccess()
            }

            override fun onErrorResponse(response: ErrorResponseBody) {
                _errorMessage.value = response.message + " "
                _errorMessage.value += when (response.error_code) {
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
                onFail()
            }

            override fun onNetworkFailure(t: Throwable) {
                _errorMessage.value = "Network error occured, please try again later..."
                onFail()
            }
        })
    }
}
