package hr.foi.air.popapp.ws.request_handlers

import hr.foi.air.popapp.core.login.network.models.SuccessfulResponseBody
import hr.foi.air.popapp.ws.network.NetworkService
import retrofit2.Call

class AssignStoreRequestHandler(
    private val jwt: String,
    private val userId: Int,
    private val storeName: String
) : TemplateRequestHandler<Any?>() {
    override fun getServiceCall(): Call<SuccessfulResponseBody<Any?>> {
        return NetworkService.userService.assignStore(
            "Bearer $jwt",
            userId,
            storeName
        )
    }
}
