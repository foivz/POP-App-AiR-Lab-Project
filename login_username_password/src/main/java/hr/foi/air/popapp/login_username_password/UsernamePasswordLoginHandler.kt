package hr.foi.air.popapp.login_username_password

import hr.foi.air.popapp.core.login.LoginHandler
import hr.foi.air.popapp.core.login.LoginOutcomeListener
import hr.foi.air.popapp.core.login.LoginToken
import hr.foi.air.popapp.core.login.LoginUserData
import hr.foi.air.popapp.core.login.network.ResponseListener
import hr.foi.air.popapp.core.login.network.models.ErrorResponseBody
import hr.foi.air.popapp.core.login.network.models.SuccessfulResponseBody
import hr.foi.air.popapp.ws.models.LoginBody
import hr.foi.air.popapp.ws.request_handlers.LoginRequestHandler

class UsernamePasswordLoginHandler : LoginHandler {
    override fun handleLogin(
        loginToken: LoginToken,
        loginListener: LoginOutcomeListener
    ) {
        if (loginToken !is UsernamePasswordLoginToken) {
            throw IllegalArgumentException("Must receive UsernamePasswordLoginToken instance for 'loginToken'!")
        }

        val authorizers = loginToken.getAuthorizers()
        val username = authorizers["username"]!!
        val password = authorizers["password"]!!

        val loginRequestHandler = LoginRequestHandler(LoginBody(username, password))

        loginRequestHandler.sendRequest(
            object : ResponseListener {
                override fun <LoggedInUserData> onSuccessfulResponse(response: SuccessfulResponseBody<LoggedInUserData>) {
                    val loginUserData =
                        response.data[0] as hr.foi.air.popapp.ws.models.LoggedInUserData

                    loginListener.onSuccessfulLogin(
                        LoginUserData(
                            userId = loginUserData.id!!,
                            username = loginUserData.username!!,
                            firstName = loginUserData.firstName!!,
                            lastName = loginUserData.lastName!!,
                            role = loginUserData.role!!,
                            isAccepted = loginUserData.isAccepted!!,
                            storeId = loginUserData.store?.storeId,
                            storeName = loginUserData.store?.storeName,
                            jwt = loginUserData.tokenPair!!.accessToken!!,
                            refreshToken = loginUserData.tokenPair!!.refreshToken.token!!,
                        )
                    )
                }

                override fun onErrorResponse(response: ErrorResponseBody) {
                    loginListener.onFailedLogin(response.message)
                }

                override fun onNetworkFailure(t: Throwable) {
                    loginListener.onFailedLogin(t.message ?: "Could not connect to network.")
                }

            }
        )
    }
}
