package hr.foi.air.popapp.ws.network

import hr.foi.air.popapp.core.login.network.models.SuccessfulResponseBody
import hr.foi.air.popapp.ws.models.NewTransactionBody
import hr.foi.air.popapp.ws.models.responses.braintree.BraintreeResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface BraintreeService {
    @POST("braintree/client-token")
    fun createTransaction(
        @Header("Authorization") authHeader: String,
        @Body body: NewTransactionBody
    ): Call<SuccessfulResponseBody<BraintreeResponse>>
}
