package hr.foi.air.popapp.core.login.network.models

class ErrorResponseBody(
    success: Boolean,
    message: String,
    val error_code: Int,
    val error_message: String
) : ResponseBody(success, message)
