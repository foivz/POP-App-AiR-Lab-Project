package hr.foi.air.popapp.core.login

interface LoginOutcomeListener {
    fun onSuccessfulLogin(username: String)
    fun onFailedLogin(reason: String)
}
