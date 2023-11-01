package hr.foi.air.popapp.ws.models.responses

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("image_url") var imageUrl: String? = null,
    @SerializedName("price") var price: Int? = null,
    @SerializedName("quantity") var quantity: Int? = null,
    @SerializedName("store") var store: Store? = Store()
)
