package hr.foi.air.popapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hr.foi.air.popapp.context.Auth
import hr.foi.air.popapp.core.login.network.ResponseListener
import hr.foi.air.popapp.core.login.network.models.ErrorResponseBody
import hr.foi.air.popapp.core.login.network.models.SuccessfulResponseBody
import hr.foi.air.popapp.ws.models.responses.Store
import hr.foi.air.popapp.ws.request_handlers.AssignStoreRequestHandler
import hr.foi.air.popapp.ws.request_handlers.GetStoresRequestHandler

class StoresViewModel : ViewModel() {
    private val _stores: MutableLiveData<List<Store>> = MutableLiveData<List<Store>>()
    val stores: LiveData<List<Store>> = _stores

    private val _errorMessage: MutableLiveData<String> = MutableLiveData("")
    val errorMessage: LiveData<String> = _errorMessage

    private val _selectedStoreName: MutableLiveData<String> = MutableLiveData<String>()
    val selectedStoreName: LiveData<String> = _selectedStoreName

    fun fetchStores() {
        val requestHandler = GetStoresRequestHandler(Auth.loggedInUserData!!.jwt)
        requestHandler.sendRequest(
            object : ResponseListener<Store> {
                override fun onSuccessfulResponse(response: SuccessfulResponseBody<Store>) {
                    _stores.value = response.data.toList()
                }

                override fun onErrorResponse(response: ErrorResponseBody) {
                    _errorMessage.value = response.message
                }

                override fun onNetworkFailure(t: Throwable) {
                    _errorMessage.value = "Network error"
                }
            }
        )
    }

    fun setSelectedStoreName(selectedStoreName: String) {
        _selectedStoreName.value = selectedStoreName
    }

    fun assignStore() {
        val requestHandler = AssignStoreRequestHandler(
            Auth.loggedInUserData!!.jwt,
            Auth.loggedInUserData!!.userId,
            storeName = selectedStoreName.value!!
        )

        requestHandler.sendRequest(
            object : ResponseListener<Any?> {
                override fun onSuccessfulResponse(response: SuccessfulResponseBody<Any?>) {
                    TODO("Not yet implemented")
                }

                override fun onErrorResponse(response: ErrorResponseBody) {
                    TODO("Not yet implemented")
                }

                override fun onNetworkFailure(t: Throwable) {
                    TODO("Not yet implemented")
                }
            }
        )
    }
}
