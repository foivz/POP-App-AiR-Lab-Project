package hr.foi.air.popapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hr.foi.air.popapp.context.Auth
import hr.foi.air.popapp.core.login.LoginHandler
import hr.foi.air.popapp.core.login.LoginOutcomeListener
import hr.foi.air.popapp.core.login.LoginToken
import hr.foi.air.popapp.core.login.LoginUserData

class LoginViewModel : ViewModel() {
    val username: MutableLiveData<String> = MutableLiveData("")
    val password: MutableLiveData<String> = MutableLiveData("")
    private val _errorMessage: MutableLiveData<String> = MutableLiveData("")
    val errorMessage: LiveData<String> = _errorMessage

    fun login(
        loginHandler: LoginHandler,
        loginToken: LoginToken,
        onSuccessfulLogin: () -> Unit,
        onFailedLogin: () -> Unit
    ) {
        loginHandler.handleLogin(loginToken, object : LoginOutcomeListener {
            override fun onSuccessfulLogin(loginUserData: LoginUserData) {
                Auth.loggedInUserData = loginUserData
                onSuccessfulLogin()
            }

            override fun onFailedLogin(reason: String) {
                _errorMessage.value = reason
                onFailedLogin()
            }
        })
    }
}
