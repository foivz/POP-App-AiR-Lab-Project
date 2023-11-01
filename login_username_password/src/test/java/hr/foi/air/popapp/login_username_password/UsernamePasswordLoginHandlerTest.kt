package hr.foi.air.popapp.login_username_password

import hr.foi.air.popapp.core.login.LoginOutcomeListener
import hr.foi.air.popapp.core.login.LoginUserData
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UsernamePasswordLoginHandlerTest {
    @Test
    fun givenCorrectCredentials_whenLoginHandlerUsedWithUsernameAndPassword_thenJwtTokenReceived() = runBlocking {
        val actualUser = ("dhuff" to "test123")
        val loginToken = UsernamePasswordLoginToken(actualUser.first, actualUser.second)
        val handler = UsernamePasswordLoginHandler()

        val deferred = CompletableDeferred<LoginUserData>()

        handler.handleLogin(loginToken, object : LoginOutcomeListener {
            override fun onSuccessfulLogin(loginUserData: LoginUserData) {
                println(loginUserData.toString())
                deferred.complete(loginUserData)
            }

            override fun onFailedLogin(reason: String) {
                deferred.completeExceptionally(Exception(reason))
            }
        })

        val loginUserData = deferred.await()
        Assert.assertEquals("Dayton", loginUserData.firstName)
        assert(loginUserData.jwt.length > 5)
    }

    @Test
    fun givenBadCredentials_whenLoginHandlerUsedWithUsernameAndPassword_throwError() = runBlocking {
        val actualUser = ("bad username" to "bad password")
        val loginToken = UsernamePasswordLoginToken(actualUser.first, actualUser.second)
        val handler = UsernamePasswordLoginHandler()

        val deferred = CompletableDeferred<String>()

        handler.handleLogin(loginToken, object : LoginOutcomeListener {
            override fun onSuccessfulLogin(loginUserData: LoginUserData) {
                deferred.completeExceptionally(Exception("User logged in despite the odds."))
            }

            override fun onFailedLogin(reason: String) {
                deferred.complete(reason)
            }
        })

        val reasonForFailure = deferred.await()
        Assert.assertEquals("Please check your credentials!", reasonForFailure)
    }
}
