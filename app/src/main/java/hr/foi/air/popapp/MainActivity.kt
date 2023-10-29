package hr.foi.air.popapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hr.foi.air.popapp.ui.theme.POPAppTheme
import hr.foi.air.popapp.ui.theme.Shapes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            POPAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Entry()
                }
            }
        }
    }
}

@Composable
fun Entry() {
    Scaffold(
        topBar = {
            Surface(color = MaterialTheme.colors.primary, modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.foibuilding), // Replace with your image resource
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp) // Set the desired height
                )
            }
        },
        bottomBar = {
            Text(
                text = "Copyright FOI 2023",
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            Text(
                text = "Welcome to POP App",
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            Button(
                onClick = {
                    Log.i("BUTTON", "Tried to login, but not implemented yet :(")
                },
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .defaultMinSize(minWidth = 80.dp)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant)
            ) {
                Text("Login", color = Color.White)
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Divider(modifier = Modifier.fillMaxWidth(0.47f), color = Color.LightGray, thickness = 2.dp)
                Text("OR")
                Divider(modifier = Modifier.fillMaxWidth(), color = Color.LightGray, thickness = 2.dp)
            }

            Button(
                onClick = {
                    Log.i("BUTTON", "Tried to register, but not implemented yet :(")
                },
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .defaultMinSize(minWidth = 80.dp)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant),
                shape = Shapes.large
            ) {
                Text("Register", color = Color.White)
            }
        }
    }
}

@Preview
@Composable
fun EntryPreview() {
    Entry()
}
