package hr.foi.air.popapp.ws.network

import hr.foi.air.popapp.core.login.network.models.ResponseBody
import hr.foi.air.popapp.core.login.network.models.SuccessfulResponseBody
import hr.foi.air.popapp.ws.models.LoggedInUserData
import hr.foi.air.popapp.ws.models.LoginBody
import hr.foi.air.popapp.ws.models.RegistrationBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationService {
    @POST("auth/register")
    fun registerUser(@Body registerBody: RegistrationBody): Call<ResponseBody>

    @POST("auth/login")
    fun loginUser(@Body loginBody: LoginBody): Call<SuccessfulResponseBody<LoggedInUserData>>
}
