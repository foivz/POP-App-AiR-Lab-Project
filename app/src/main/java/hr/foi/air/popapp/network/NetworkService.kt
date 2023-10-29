package hr.foi.air.popapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkService {
    private const val BASE_URL = "http://ase.foi.hr/pop/api/v2/"

    private var instance: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val authService: AuthenticationService = instance.create(AuthenticationService::class.java)
}
