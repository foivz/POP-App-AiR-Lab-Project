package hr.foi.air.popapp.ws.models.responses

import com.google.gson.annotations.SerializedName

data class RegisteredUser(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("role") var role: String? = null,
    @SerializedName("store") var store: String? = null,
    @SerializedName("event") var event: Int? = null,
    @SerializedName("first_name") var firstName: String? = null,
    @SerializedName("last_name") var lastName: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("username") var username: String? = null,
    @SerializedName("date_of_register") var dateOfRegister: String? = null,
    @SerializedName("balance") var balance: Int? = null,
    @SerializedName("is_accepted") var isAccepted: Boolean? = null
)
