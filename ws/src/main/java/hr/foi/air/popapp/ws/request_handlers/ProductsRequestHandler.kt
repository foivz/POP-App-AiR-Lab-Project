package hr.foi.air.popapp.ws.request_handlers

import hr.foi.air.popapp.core.login.network.models.SuccessfulResponseBody
import hr.foi.air.popapp.ws.models.responses.Product
import hr.foi.air.popapp.ws.network.NetworkService
import retrofit2.Call

class ProductsRequestHandler(private val jwt: String) : TemplateRequestHandler<Product>() {
    override fun getServiceCall(): Call<SuccessfulResponseBody<Product>> {
        val service = NetworkService.productsService
        return service.getProducts("Bearer $jwt")
    }
}
