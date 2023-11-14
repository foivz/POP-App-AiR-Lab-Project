package hr.foi.air.popapp.ws.network

import hr.foi.air.popapp.core.login.network.models.SuccessfulResponseBody
import hr.foi.air.popapp.ws.models.responses.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ProductsService {
    @GET("products")
    fun getProducts(@Header("Authorization") authHeader: String): Call<SuccessfulResponseBody<Product>>
}
