package hr.foi.air.popapp.core.login

interface LoginToken {
    fun getAuthorizers(): Map<String, String>
}
