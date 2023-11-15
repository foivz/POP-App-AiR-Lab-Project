package hr.foi.air.popapp.ws.models.responses

import com.google.gson.annotations.SerializedName

data class Store(
    @SerializedName("id") var storeId: Int? = null,
    @SerializedName("store_name") var name: String? = null,
    @SerializedName("latitude") var latitude: Double? = null,
    @SerializedName("longitude") var longitude: Double? = null
)
