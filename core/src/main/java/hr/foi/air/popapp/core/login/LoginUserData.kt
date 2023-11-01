package hr.foi.air.popapp.core.login

/**
 * Data needed after login, received from the backend.
 * Any implementation of login must procure this information.
 */
data class LoginUserData(
    val userId: Int,
    val username: String,
    val firstName: String,
    val lastName: String,
    val role: String,
    val isAccepted: Boolean,
    val storeId: Int?,
    val storeName: String?,
    val jwt: String,
    val refreshToken: String
)
