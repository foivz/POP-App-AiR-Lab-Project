package hr.foi.air.popapp.ws.models.responses.braintree

import com.google.gson.annotations.SerializedName


data class DisbursementDetails(

    @SerializedName("disbursement_date") var disbursementDate: String? = null,
    @SerializedName("settlement_currency_iso_code") var settlementCurrencyIsoCode: String? = null,
    @SerializedName("funds_held") var fundsHeld: Boolean? = null,
    @SerializedName("success") var success: Boolean? = null,
    @SerializedName("settlement_currency_exchange_rate") var settlementCurrencyExchangeRate: String? = null,
    @SerializedName("settlement_amount") var settlementAmount: String? = null,
    @SerializedName("valid") var valid: Boolean? = null

)
