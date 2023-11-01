package hr.foi.air.popapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import hr.foi.air.popapp.login_username_password.UsernamePasswordLoginHandler
import hr.foi.air.popapp.navigation.components.EntryPage
import hr.foi.air.popapp.navigation.components.HomePage
import hr.foi.air.popapp.navigation.components.LoginPage
import hr.foi.air.popapp.navigation.components.registration.PostRegistrationNotice
import hr.foi.air.popapp.navigation.components.registration.ProductsPage
import hr.foi.air.popapp.navigation.components.registration.RegistrationPage
import hr.foi.air.popapp.ui.theme.POPAppTheme

class MainActivity : ComponentActivity() {

    private val loginHandlers = listOf(UsernamePasswordLoginHandler())
    private val currentLoginHandler = loginHandlers[0]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            POPAppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()

                    NavHost(navController, startDestination = "entry") {
                        composable("entry") {
                            EntryPage(
                                onLoginButtonClick = {
                                    navController.navigate("login")
                                },
                                onRegistrationButtonClick = {
                                    navController.navigate("register")
                                }
                            )
                        }
                        composable("register") {
                            RegistrationPage(
                                onSuccessfulRegistration = { newUsername ->
                                    navController.navigate("register/$newUsername/notice")
                                }
                            )
                        }
                        composable(
                            "register/{username}/notice",
                            arguments = listOf(navArgument("username") { type = NavType.StringType })
                        ) { backStackEntry ->
                            PostRegistrationNotice(
                                newUsername = backStackEntry.arguments?.getString("username") ?: "?",
                                onNoticeUnderstood = {
                                    repeat(2) { navController.popBackStack() }
                                }
                            )
                        }
                        composable("login") {
                            LoginPage(
                                onSuccessfulLogin = {
                                    navController.navigate("home")
                                },
                                loginHandler = currentLoginHandler
                            )
                        }
                        composable("home") {
                            HomePage(onMenuOptionSelected = { selectedRoute ->
                                when (selectedRoute) {
                                    "products" -> navController.navigate("products")
                                    else -> Toast.makeText(
                                        applicationContext,
                                        "Not implemented yet",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            })
                        }
                        composable("products") {
                            ProductsPage()
                        }
                    }
                }
            }
        }
    }
}
