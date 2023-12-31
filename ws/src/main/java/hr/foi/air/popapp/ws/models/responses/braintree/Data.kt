package hr.foi.air.popapp.ws.models.responses.braintree

import com.google.gson.annotations.SerializedName


data class Data(

    @SerializedName("billing_address") var billingAddress: BillingAddress? = BillingAddress(),
    @SerializedName("shipping_address") var shippingAddress: ShippingAddress? = ShippingAddress(),
    @SerializedName("amex_express_checkout_details") var amexExpressCheckoutDetails: String? = null,
    @SerializedName("android_pay_details") var androidPayDetails: String? = null,
    @SerializedName("apple_pay_details") var applePayDetails: String? = null,
    @SerializedName("amount") var amount: Int? = null,
    @SerializedName("discount_amount") var discountAmount: String? = null,
    @SerializedName("service_fee_amount") var serviceFeeAmount: String? = null,
    @SerializedName("shipping_amount") var shippingAmount: String? = null,
    @SerializedName("tax_amount") var taxAmount: String? = null,
    @SerializedName("recurring") var recurring: Boolean? = null,
    @SerializedName("tax_exempt") var taxExempt: Boolean? = null,
    @SerializedName("authorization_expires_at") var authorizationExpiresAt: String? = null,
    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("updated_at") var updatedAt: String? = null,
    @SerializedName("credit_card") var creditCard: CreditCard? = CreditCard(),
    @SerializedName("custom_actions_payment_method_details") var customActionsPaymentMethodDetails: String? = null,
    @SerializedName("network_token") var networkToken: String? = null,
    @SerializedName("customer") var customer: Customer? = Customer(),
    @SerializedName("descriptor") var descriptor: Descriptor? = Descriptor(),
    @SerializedName("disbursement_details") var disbursementDetails: DisbursementDetails? = DisbursementDetails(),
    @SerializedName("escrow_status") var escrowStatus: String? = null,
    @SerializedName("facilitated_details") var facilitatedDetails: String? = null,
    @SerializedName("facilitator_details") var facilitatorDetails: String? = null,
    @SerializedName("gateway_rejection_reason") var gatewayRejectionReason: String? = null,
    @SerializedName("installment_count") var installmentCount: String? = null,
    @SerializedName("ach_return_responses") var achReturnResponses: ArrayList<String> = arrayListOf(),
    @SerializedName("add_ons") var addOns: ArrayList<String> = arrayListOf(),
    @SerializedName("authorization_adjustments") var authorizationAdjustments: ArrayList<String> = arrayListOf(),
    @SerializedName("discounts") var discounts: ArrayList<String> = arrayListOf(),
    @SerializedName("disputes") var disputes: ArrayList<String> = arrayListOf(),
    @SerializedName("installments") var installments: ArrayList<String> = arrayListOf(),
    @SerializedName("refunded_installments") var refundedInstallments: ArrayList<String> = arrayListOf(),
    @SerializedName("status_history") var statusHistory: ArrayList<StatusHistory> = arrayListOf(),
    @SerializedName("partial_settlement_transaction_ids") var partialSettlementTransactionIds: ArrayList<String> = arrayListOf(),
    @SerializedName("refund_ids") var refundIds: ArrayList<String> = arrayListOf(),
    @SerializedName("local_payment_details") var localPaymentDetails: String? = null,
    @SerializedName("masterpass_card_details") var masterpassCardDetails: String? = null,
    @SerializedName("processor_response_type") var processorResponseType: String? = null,
    @SerializedName("risk_data") var riskData: String? = null,
    @SerializedName("samsung_pay_card_details") var samsungPayCardDetails: String? = null,
    @SerializedName("sca_exemption_requested") var scaExemptionRequested: String? = null,
    @SerializedName("sepa_direct_debit_account_details") var sepaDirectDebitAccountDetails: String? = null,
    @SerializedName("status") var status: String? = null,
    @SerializedName("ach_return_code") var achReturnCode: String? = null,
    @SerializedName("acquirer_reference_number") var acquirerReferenceNumber: String? = null,
    @SerializedName("additional_processor_response") var additionalProcessorResponse: String? = null,
    @SerializedName("authorized_transaction_id") var authorizedTransactionId: String? = null,
    @SerializedName("avs_error_response_code") var avsErrorResponseCode: String? = null,
    @SerializedName("avs_postal_code_response_code") var avsPostalCodeResponseCode: String? = null,
    @SerializedName("avs_street_address_response_code") var avsStreetAddressResponseCode: String? = null,
    @SerializedName("channel") var channel: String? = null,
    @SerializedName("currency_iso_code") var currencyIsoCode: String? = null,
    @SerializedName("cvv_response_code") var cvvResponseCode: String? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("merchant_account_id") var merchantAccountId: String? = null,
    @SerializedName("network_response_code") var networkResponseCode: String? = null,
    @SerializedName("network_response_text") var networkResponseText: String? = null,
    @SerializedName("network_transaction_id") var networkTransactionId: String? = null,
    @SerializedName("order_id") var orderId: String? = null,
    @SerializedName("payment_instrument_type") var paymentInstrumentType: String? = null,
    @SerializedName("plan_id") var planId: String? = null,
    @SerializedName("processor_authorization_code") var processorAuthorizationCode: String? = null,
    @SerializedName("processor_response_code") var processorResponseCode: String? = null,
    @SerializedName("processor_response_text") var processorResponseText: String? = null,
    @SerializedName("processor_settlement_response_code") var processorSettlementResponseCode: String? = null,
    @SerializedName("processor_settlement_response_text") var processorSettlementResponseText: String? = null,
    @SerializedName("purchase_order_number") var purchaseOrderNumber: String? = null,
    @SerializedName("refunded_transaction_id") var refundedTransactionId: String? = null,
    @SerializedName("retrieval_reference_number") var retrievalReferenceNumber: String? = null,
    @SerializedName("sepa_direct_debit_return_code") var sepaDirectDebitReturnCode: String? = null,
    @SerializedName("settlement_batch_id") var settlementBatchId: String? = null,
    @SerializedName("ships_from_postal_code") var shipsFromPostalCode: String? = null,
    @SerializedName("subscription_id") var subscriptionId: String? = null,
    @SerializedName("voice_referral_number") var voiceReferralNumber: String? = null,
    @SerializedName("subscription_details") var subscriptionDetails: SubscriptionDetails? = SubscriptionDetails(),
    @SerializedName("three_dsecure_info") var threeDsecureInfo: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("us_bank_account_details") var usBankAccountDetails: String? = null,
    @SerializedName("venmo_account_details") var venmoAccountDetails: String? = null,
    @SerializedName("visa_checkout_card_details") var visaCheckoutCardDetails: String? = null,
    @SerializedName("processed_with_network_token") var processedWithNetworkToken: Boolean? = null,
    @SerializedName("retried") var retried: Boolean? = null,
    @SerializedName("disbursed") var disbursed: Boolean? = null,
    @SerializedName("graph_qlid") var graphQlid: String? = null,
    @SerializedName("pay_pal_details") var payPalDetails: String? = null,
    @SerializedName("pay_pal_here_details") var payPalHereDetails: String? = null

)
