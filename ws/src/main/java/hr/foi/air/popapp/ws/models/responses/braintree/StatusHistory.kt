package hr.foi.air.popapp.ws.models.responses.braintree

import com.google.gson.annotations.SerializedName


data class StatusHistory(

    @SerializedName("amount") var amount: Int? = null,
    @SerializedName("status") var status: String? = null,
    @SerializedName("timestamp") var timestamp: String? = null,
    @SerializedName("source") var source: String? = null,
    @SerializedName("user") var user: String? = null

)
