package hr.foi.air.popapp

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.braintreepayments.api.DropInClient
import com.braintreepayments.api.DropInListener
import com.braintreepayments.api.DropInRequest
import com.braintreepayments.api.DropInResult
import hr.foi.air.popapp.context.Auth
import hr.foi.air.popapp.core.login.network.ResponseListener
import hr.foi.air.popapp.core.login.network.models.ErrorResponseBody
import hr.foi.air.popapp.core.login.network.models.SuccessfulResponseBody
import hr.foi.air.popapp.databinding.ActivityPaymentBinding
import hr.foi.air.popapp.ws.models.responses.braintree.BraintreeResponse
import hr.foi.air.popapp.ws.request_handlers.BraintreeRequestHandler


class PaymentActivity : FragmentActivity(), DropInListener {
    private lateinit var dropInClient: DropInClient
    private var price: Double = 0.0
    private lateinit var binding: ActivityPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        price = intent.getDoubleExtra("price", 0.0)

        dropInClient = DropInClient(this, "sandbox_bnr6gk5y_qvb7z2b79whqxrkr")
        dropInClient.setListener(this)
        binding.button.setOnClickListener {
            dropInClient.launchDropIn(DropInRequest())
        }
    }

    override fun onDropInSuccess(dropInResult: DropInResult) {
        val request = BraintreeRequestHandler(
            jwt = Auth.loggedInUserData!!.jwt,
            amount = price,
            dropInResult.paymentMethodNonce!!.string
        )
        request.sendRequest(object : ResponseListener<BraintreeResponse> {
            override fun onSuccessfulResponse(response: SuccessfulResponseBody<BraintreeResponse>) {
                Toast.makeText(
                    this@PaymentActivity,
                    "Payment successful",
                    Toast.LENGTH_SHORT
                ).show()
                this@PaymentActivity.finish()
            }

            override fun onErrorResponse(response: ErrorResponseBody) {
                Toast.makeText(
                    this@PaymentActivity,
                    "Payment could not be made.",
                    Toast.LENGTH_SHORT
                ).show()
                this@PaymentActivity.finish()
            }

            override fun onNetworkFailure(t: Throwable) {
                Toast.makeText(
                    this@PaymentActivity,
                    "Could not connect to network.",
                    Toast.LENGTH_SHORT
                ).show()
                this@PaymentActivity.finish()
            }
        })
    }

    override fun onDropInFailure(error: Exception) {
        Toast.makeText(this, error.message ?: error.toString(), Toast.LENGTH_LONG).show()
    }
}
