package hr.foi.air.popapp.core.login.network

interface RequestHandler<T> {
    fun sendRequest(responseListener: ResponseListener<T>)
}
