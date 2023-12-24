package hr.foi.air.popapp.ws.models.responses.braintree

import com.google.gson.annotations.SerializedName


data class Descriptor(

    @SerializedName("name") var name: String? = null,
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("url") var url: String? = null
 
)
