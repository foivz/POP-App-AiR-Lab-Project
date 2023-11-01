package hr.foi.air.popapp.ws.models.responses

import com.google.gson.annotations.SerializedName

data class TokenPair(
    @SerializedName("access_token") val accessToken: String? = null,
    @SerializedName("refresh_token") val refreshToken: RefreshToken = RefreshToken()
)

data class RefreshToken(
    val token: String? = null,
    @SerializedName("valid_for") val validFor: Validity = Validity()
)

data class Validity(
    @SerializedName("time_amount") val timeAmount: Int? = null,
    @SerializedName("time_unit") val timeUnit: String? = null
)
