package hr.foi.air.popapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hr.foi.air.popapp.context.Auth
import hr.foi.air.popapp.core.login.network.ResponseListener
import hr.foi.air.popapp.core.login.network.models.ErrorResponseBody
import hr.foi.air.popapp.core.login.network.models.SuccessfulResponseBody
import hr.foi.air.popapp.ws.models.responses.Product
import hr.foi.air.popapp.ws.request_handlers.ProductsRequestHandler

class ProductsViewModel : ViewModel() {

    private val _products: MutableLiveData<List<Product>> = MutableLiveData(mutableListOf())
    val products: LiveData<List<Product>> = _products

    fun fetchProducts() {
        val productsRequestHandler = ProductsRequestHandler(Auth.loggedInUserData!!.jwt)

        productsRequestHandler.sendRequest(object : ResponseListener<Product> {
            override fun onSuccessfulResponse(response: SuccessfulResponseBody<Product>) {
                _products.value = response.data.toMutableList()
            }

            override fun onErrorResponse(response: ErrorResponseBody) {
                println("Error receiving response: ${response.error_message}")
            }

            override fun onNetworkFailure(t: Throwable) {
                println("Error contacting network...")
            }
        })
    }
}
