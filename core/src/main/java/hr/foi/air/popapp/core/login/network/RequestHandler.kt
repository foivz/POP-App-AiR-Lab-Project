package hr.foi.air.popapp.core.login.network

interface RequestHandler {
    fun sendRequest(responseListener: ResponseListener)
}
