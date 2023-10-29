package hr.foi.air.popapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import hr.foi.air.popapp.navigation.components.EntryPage
import hr.foi.air.popapp.navigation.components.LoginPage
import hr.foi.air.popapp.navigation.components.RegistrationPage
import hr.foi.air.popapp.ui.theme.POPAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            POPAppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()

                    NavHost(navController, startDestination = "entry") {
                        composable("entry") {
                            EntryPage()
                        }
                        composable("register") {
                            RegistrationPage()
                        }
                        composable("login") {
                            LoginPage()
                        }
                    }
                }
            }
        }
    }
}
