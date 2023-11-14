package hr.foi.air.popapp.ws.request_handlers

import hr.foi.air.popapp.core.login.network.models.SuccessfulResponseBody
import hr.foi.air.popapp.ws.models.LoggedInUserData
import hr.foi.air.popapp.ws.models.LoginBody
import hr.foi.air.popapp.ws.network.NetworkService
import retrofit2.Call

class LoginRequestHandler(private val requestBody: LoginBody) :
    TemplateRequestHandler<LoggedInUserData>() {
    override fun getServiceCall(): Call<SuccessfulResponseBody<LoggedInUserData>> {
        val service = NetworkService.authService
        return service.loginUser(requestBody)
    }
}
