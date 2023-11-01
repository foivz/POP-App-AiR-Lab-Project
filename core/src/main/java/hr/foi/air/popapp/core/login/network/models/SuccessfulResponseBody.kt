package hr.foi.air.popapp.core.login.network.models

class SuccessfulResponseBody<T>(success: Boolean, message: String, val data: Array<T>) : ResponseBody(success, message)
