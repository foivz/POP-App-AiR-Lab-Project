package hr.foi.air.popapp.ws.models.responses.braintree

import com.google.gson.annotations.SerializedName


data class Customer(

    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("updated_at") var updatedAt: String? = null,
    @SerializedName("company") var company: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("fax") var fax: String? = null,
    @SerializedName("first_name") var firstName: String? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("last_name") var lastName: String? = null,
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("website") var website: String? = null,
    @SerializedName("addresses") var addresses: ArrayList<String> = arrayListOf(),
    @SerializedName("amex_express_checkout_cards") var amexExpressCheckoutCards: ArrayList<String> = arrayListOf(),
    @SerializedName("android_pay_cards") var androidPayCards: ArrayList<String> = arrayListOf(),
    @SerializedName("apple_pay_cards") var applePayCards: ArrayList<String> = arrayListOf(),
    @SerializedName("credit_cards") var creditCards: ArrayList<String> = arrayListOf(),
    @SerializedName("custom_actions_payment_methods") var customActionsPaymentMethods: ArrayList<String> = arrayListOf(),
    @SerializedName("masterpass_cards") var masterpassCards: ArrayList<String> = arrayListOf(),
    @SerializedName("samsung_pay_cards") var samsungPayCards: ArrayList<String> = arrayListOf(),
    @SerializedName("sepa_direct_debit_accounts") var sepaDirectDebitAccounts: ArrayList<String> = arrayListOf(),
    @SerializedName("us_bank_accounts") var usBankAccounts: ArrayList<String> = arrayListOf(),
    @SerializedName("venmo_accounts") var venmoAccounts: ArrayList<String> = arrayListOf(),
    @SerializedName("visa_checkout_cards") var visaCheckoutCards: ArrayList<String> = arrayListOf(),
    @SerializedName("graph_qlid") var graphQlid: String? = null,
    @SerializedName("pay_pal_accounts") var payPalAccounts: ArrayList<String> = arrayListOf(),
    @SerializedName("payment_methods") var paymentMethods: ArrayList<String> = arrayListOf(),
    @SerializedName("default_payment_method") var defaultPaymentMethod: String? = null

)
