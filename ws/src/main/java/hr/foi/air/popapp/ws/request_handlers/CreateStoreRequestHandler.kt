package hr.foi.air.popapp.ws.request_handlers

import hr.foi.air.popapp.core.login.network.models.SuccessfulResponseBody
import hr.foi.air.popapp.ws.models.NewStoreBody
import hr.foi.air.popapp.ws.models.responses.Store
import hr.foi.air.popapp.ws.network.NetworkService
import retrofit2.Call

class CreateStoreRequestHandler(private val jwt: String, private val body: NewStoreBody) :
    TemplateRequestHandler<Store>() {
    override fun getServiceCall(): Call<SuccessfulResponseBody<Store>> {
        val service = NetworkService.storesService
        return service.createStore("Bearer $jwt", body)
    }
}
