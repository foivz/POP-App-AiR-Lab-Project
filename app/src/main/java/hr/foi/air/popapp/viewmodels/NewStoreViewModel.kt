package hr.foi.air.popapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hr.foi.air.popapp.context.Auth
import hr.foi.air.popapp.core.login.network.ResponseListener
import hr.foi.air.popapp.core.login.network.models.ErrorResponseBody
import hr.foi.air.popapp.core.login.network.models.SuccessfulResponseBody
import hr.foi.air.popapp.ws.models.NewStoreBody
import hr.foi.air.popapp.ws.request_handlers.CreateStoreRequestHandler

class NewStoreViewModel : ViewModel() {
    val _storeName: MutableLiveData<String> = MutableLiveData("")
    private val _errorReason: MutableLiveData<String> = MutableLiveData("")
    private val _storeLatitude: MutableLiveData<Double> = MutableLiveData(0.0)
    private val _storeLongitude: MutableLiveData<Double> = MutableLiveData(0.0)

    val storeName: LiveData<String> = _storeName
    val errorReason: LiveData<String> = _errorReason

    fun setStoreName(newName: String) {
        _storeName.value = newName
    }

    fun setStoreLocation(latitude: Double, longitude: Double) {
        _storeLatitude.value = latitude
        _storeLongitude.value = longitude
    }

    fun createStore(onSuccessfulResponse: () -> Unit) {
        val requestHandler = CreateStoreRequestHandler(
            Auth.loggedInUserData!!.jwt,
            NewStoreBody(storeName.value!!, _storeLatitude.value!!, _storeLongitude.value!!)
        )
        requestHandler.sendRequest(
            object : ResponseListener {
                override fun <T> onSuccessfulResponse(response: SuccessfulResponseBody<T>) {
                    onSuccessfulResponse()
                }

                override fun onErrorResponse(response: ErrorResponseBody) {
                    _errorReason.value = response.message
                }

                override fun onNetworkFailure(t: Throwable) {
                    _errorReason.value = "Network error"
                }
            }
        )
    }
}
