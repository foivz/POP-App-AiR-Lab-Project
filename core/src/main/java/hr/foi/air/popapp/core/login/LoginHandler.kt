package hr.foi.air.popapp.core.login

interface LoginHandler {

    /**
     * Execute login and notify loginHandler.
     * @param loginToken A token defined by a module, which enables executing of login functionality.
     * @param loginListener A listener set to notify the user on the outcome of this log in method.
     */
    fun handleLogin(loginToken: LoginToken, loginListener: LoginOutcomeListener)
}
