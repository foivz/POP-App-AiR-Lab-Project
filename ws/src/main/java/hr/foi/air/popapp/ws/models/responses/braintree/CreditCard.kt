package hr.foi.air.popapp.ws.models.responses.braintree

import com.google.gson.annotations.SerializedName


data class CreditCard(

    @SerializedName("billing_address") var billingAddress: String? = null,
    @SerializedName("bin") var bin: String? = null,
    @SerializedName("cardholder_name") var cardholderName: String? = null,
    @SerializedName("card_type") var cardType: String? = null,
    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("customer_id") var customerId: String? = null,
    @SerializedName("customer_location") var customerLocation: String? = null,
    @SerializedName("expiration_month") var expirationMonth: String? = null,
    @SerializedName("expiration_year") var expirationYear: String? = null,
    @SerializedName("image_url") var imageUrl: String? = null,
    @SerializedName("last4") var last4: String? = null,
    @SerializedName("commercial") var commercial: String? = null,
    @SerializedName("debit") var debit: String? = null,
    @SerializedName("durbin_regulated") var durbinRegulated: String? = null,
    @SerializedName("healthcare") var healthcare: String? = null,
    @SerializedName("payroll") var payroll: String? = null,
    @SerializedName("prepaid") var prepaid: String? = null,
    @SerializedName("product_id") var productId: String? = null,
    @SerializedName("country_of_issuance") var countryOfIssuance: String? = null,
    @SerializedName("issuing_bank") var issuingBank: String? = null,
    @SerializedName("unique_number_identifier") var uniqueNumberIdentifier: String? = null,
    @SerializedName("subscriptions") var subscriptions: ArrayList<String> = arrayListOf(),
    @SerializedName("token") var token: String? = null,
    @SerializedName("updated_at") var updatedAt: String? = null,
    @SerializedName("verification") var verification: String? = null,
    @SerializedName("account_type") var accountType: String? = null,
    @SerializedName("venmo_sdk") var venmoSdk: Boolean? = null,
    @SerializedName("network_tokenized") var networkTokenized: Boolean? = null,
    @SerializedName("masked_number") var maskedNumber: String? = null,
    @SerializedName("default") var default: Boolean? = null,
    @SerializedName("expiration_date") var expirationDate: String? = null,
    @SerializedName("expired") var expired: Boolean? = null

)
