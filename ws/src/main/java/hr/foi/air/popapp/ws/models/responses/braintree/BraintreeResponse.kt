package hr.foi.air.popapp.ws.models.responses.braintree

import com.google.gson.annotations.SerializedName


data class BraintreeResponse(

    @SerializedName("message") var message: String? = null,
    @SerializedName("success") var success: Boolean? = null,
    @SerializedName("data") var data: ArrayList<Data> = arrayListOf()

)
