package hr.foi.air.popapp.ws.models.responses

import com.google.gson.annotations.SerializedName

data class Store(
    @SerializedName("store_id") var storeId: Int? = null,
    @SerializedName("store_name") var storeName: String? = null
)
