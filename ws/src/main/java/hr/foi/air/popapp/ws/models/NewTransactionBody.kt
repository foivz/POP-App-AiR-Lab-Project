package hr.foi.air.popapp.ws.models

import com.google.gson.annotations.SerializedName

data class NewTransactionBody(
    private val amountValue: Double,
    @SerializedName("nonce_from_the_client") val nonceFromTheClient: String
) {
    val amount: String = amountValue.toString()
        .replace(",", ".")
        .replace("[^\\.0-9]", "")
}
