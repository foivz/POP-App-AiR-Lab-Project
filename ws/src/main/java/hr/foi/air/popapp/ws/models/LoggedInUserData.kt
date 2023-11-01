package hr.foi.air.popapp.ws.models

import com.google.gson.annotations.SerializedName
import hr.foi.air.popapp.ws.models.responses.Store
import hr.foi.air.popapp.ws.models.responses.TokenPair

data class LoggedInUserData(
    @SerializedName("token_pair") var tokenPair: TokenPair? = TokenPair(),
    @SerializedName("id") var id: Int? = null,
    @SerializedName("first_name") var firstName: String? = null,
    @SerializedName("last_name") var lastName: String? = null,
    @SerializedName("username") var username: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("role") var role: String? = null,
    @SerializedName("is_accepted") var isAccepted: Boolean? = null,
    @SerializedName("store") var store: Store? = Store()
)
