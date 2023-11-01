package hr.foi.air.popapp.ws

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class RegisterServiceTest {
    @Test
    fun testRegistrationRoute() {
        val existingUsername = "cvelasquez"

        val url = "http://ase.foi.hr/pop/api/v2/auth/register"
        val jsonForExistingUser = "{\n" +
                "    \"first_name\": \"SomeName\",\n" +
                "    \"last_name\": \"SomeSurname\",\n" +
                "    \"username\": \"$existingUsername\",\n" +
                "    \"email\": \"someemail@ase.foi.hr\",\n" +
                "    \"password\": \"test123\",\n" +
                "    \"role\": \"buyer\"\n" +
                "}"
        val client = OkHttpClient()

        val requestBody = jsonForExistingUser.toRequestBody("application/json".toMediaType())
        val request = Request.Builder()
            .url(url)
            .post(requestBody)
            .build()

        client.newCall(request).execute().body.also { res ->
            val stringResponseBody = res?.string()!!
            assertTrue(stringResponseBody.contains("Could not register user!"))
        }
    }
}
