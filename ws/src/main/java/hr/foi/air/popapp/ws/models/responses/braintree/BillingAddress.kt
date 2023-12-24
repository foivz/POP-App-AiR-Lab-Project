package hr.foi.air.popapp.ws.models.responses.braintree

import com.google.gson.annotations.SerializedName


data class BillingAddress(

    @SerializedName("company") var company: String? = null,
    @SerializedName("country_code_alpha2") var countryCodeAlpha2: String? = null,
    @SerializedName("country_code_alpha3") var countryCodeAlpha3: String? = null,
    @SerializedName("country_code_numeric") var countryCodeNumeric: String? = null,
    @SerializedName("country_name") var countryName: String? = null,
    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("customer_id") var customerId: String? = null,
    @SerializedName("extended_address") var extendedAddress: String? = null,
    @SerializedName("first_name") var firstName: String? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("last_name") var lastName: String? = null,
    @SerializedName("locality") var locality: String? = null,
    @SerializedName("phone_number") var phoneNumber: String? = null,
    @SerializedName("postal_code") var postalCode: String? = null,
    @SerializedName("region") var region: String? = null,
    @SerializedName("recipient_name") var recipientName: String? = null,
    @SerializedName("street_address") var streetAddress: String? = null,
    @SerializedName("updated_at") var updatedAt: String? = null

)
