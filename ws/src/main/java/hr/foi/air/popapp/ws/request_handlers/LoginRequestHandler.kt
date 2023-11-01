package hr.foi.air.popapp.ws.request_handlers

import com.google.gson.Gson
import hr.foi.air.popapp.core.login.network.RequestHandler
import hr.foi.air.popapp.core.login.network.ResponseListener
import hr.foi.air.popapp.core.login.network.models.ErrorResponseBody
import hr.foi.air.popapp.core.login.network.models.SuccessfulResponseBody
import hr.foi.air.popapp.ws.models.LoggedInUserData
import hr.foi.air.popapp.ws.models.LoginBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRequestHandler(private val requestBody: LoginBody) : RequestHandler {
    override fun sendRequest(responseListener: ResponseListener) {
        val service = hr.foi.air.popapp.ws.network.NetworkService.authService
        val serviceCall = service.loginUser(requestBody)

        serviceCall.enqueue(object : Callback<SuccessfulResponseBody<LoggedInUserData>> {

            override fun onResponse(
                call: Call<SuccessfulResponseBody<LoggedInUserData>>,
                response: Response<SuccessfulResponseBody<LoggedInUserData>>
            ) {
                if (response.isSuccessful) {
                    responseListener.onSuccessfulResponse(response.body() as SuccessfulResponseBody<LoggedInUserData>)
                } else {
                    val errorResponse = Gson().fromJson(response.errorBody().string(), ErrorResponseBody::class.java)
                    responseListener.onErrorResponse(errorResponse)
                }
            }

            override fun onFailure(call: Call<SuccessfulResponseBody<LoggedInUserData>>, t: Throwable) {
                responseListener.onNetworkFailure(t)
            }

        })
    }
}
