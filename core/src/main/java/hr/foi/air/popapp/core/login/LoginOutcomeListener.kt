package hr.foi.air.popapp.core.login

interface LoginOutcomeListener {
    fun onSuccessfulLogin(loginUserData: LoginUserData)
    fun onFailedLogin(reason: String)
}
