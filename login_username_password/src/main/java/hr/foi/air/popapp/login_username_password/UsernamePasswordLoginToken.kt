package hr.foi.air.popapp.login_username_password

import hr.foi.air.popapp.core.login.LoginToken

class UsernamePasswordLoginToken : LoginToken {

    private val authorizers = emptyMap<String, String>()

    override fun getAuthorizers(): Map<String, String> {
        return authorizers
    }
}
