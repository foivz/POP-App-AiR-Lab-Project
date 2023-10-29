package hr.foi.air.popapp.network.models

data class RegistrationBody(
    val first_name: String,
    val last_name: String,
    val username: String,
    val email: String,
    val password: String,
    val role: String,
)
