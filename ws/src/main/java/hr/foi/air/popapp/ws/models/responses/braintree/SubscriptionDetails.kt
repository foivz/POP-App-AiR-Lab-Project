package hr.foi.air.popapp.ws.models.responses.braintree

import com.google.gson.annotations.SerializedName


data class SubscriptionDetails(

    @SerializedName("billing_period_end_date") var billingPeriodEndDate: String? = null,
    @SerializedName("billing_period_start_date") var billingPeriodStartDate: String? = null

)
