package hr.foi.air.popapp.core.login.network

import hr.foi.air.popapp.core.login.network.models.ErrorResponseBody
import hr.foi.air.popapp.core.login.network.models.SuccessfulResponseBody

interface ResponseListener<T> {
    fun onSuccessfulResponse(response: SuccessfulResponseBody<T>)
    fun onErrorResponse(response: ErrorResponseBody)
    fun onNetworkFailure(t: Throwable)
}
