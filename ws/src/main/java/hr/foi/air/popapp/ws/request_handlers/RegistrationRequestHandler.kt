package hr.foi.air.popapp.ws.request_handlers

import hr.foi.air.popapp.core.login.network.models.SuccessfulResponseBody
import hr.foi.air.popapp.ws.models.RegistrationBody
import hr.foi.air.popapp.ws.models.responses.RegisteredUser
import hr.foi.air.popapp.ws.network.NetworkService
import retrofit2.Call

class RegistrationRequestHandler(private val requestBody: RegistrationBody) :
    TemplateRequestHandler<RegisteredUser>() {
    override fun getServiceCall(): Call<SuccessfulResponseBody<RegisteredUser>> {
        val service = NetworkService.authService
        return service.registerUser(requestBody)
    }

}
