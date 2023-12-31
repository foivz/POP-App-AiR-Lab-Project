package hr.foi.air.popapp.ws.request_handlers

import hr.foi.air.popapp.core.login.network.models.SuccessfulResponseBody
import hr.foi.air.popapp.ws.models.NewTransactionBody
import hr.foi.air.popapp.ws.models.responses.braintree.BraintreeResponse
import hr.foi.air.popapp.ws.network.NetworkService
import retrofit2.Call

class BraintreeRequestHandler(
    private val jwt: String,
    private val amount: Double,
    private val nonce: String
) : TemplateRequestHandler<BraintreeResponse>() {
    override fun getServiceCall(): Call<SuccessfulResponseBody<BraintreeResponse>> {
        return NetworkService.braintreeService.createTransaction(
            "Bearer $jwt",
            NewTransactionBody(
                amountValue = amount,
                nonceFromTheClient = nonce
            )
        )
    }
}
