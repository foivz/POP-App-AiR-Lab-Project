package hr.foi.air.popapp.ws.models

import com.google.gson.annotations.SerializedName

data class NewStoreBody(
    @SerializedName("store_name") val storeName: String,
    val latitude: Double,
    val longitude: Double
)
