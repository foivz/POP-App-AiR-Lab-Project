package hr.foi.air.popapp.navigation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hr.foi.air.popapp.R
import hr.foi.air.popapp.ui.components.AdMobBanner
import hr.foi.air.popapp.ui.theme.Shapes

@Composable
fun EntryPage(
    onLoginButtonClick: () -> Unit,
    onRegistrationButtonClick: () -> Unit,
) {
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
                onClick = onLoginButtonClick,
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
                Divider(
                    modifier = Modifier.fillMaxWidth(0.47f),
                    color = Color.LightGray,
                    thickness = 2.dp
                )
                Text("OR")
                Divider(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.LightGray,
                    thickness = 2.dp
                )
            }

            Button(
                onClick = onRegistrationButtonClick,
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .defaultMinSize(minWidth = 80.dp)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant),
                shape = Shapes.large
            ) {
                Text("Register", color = Color.White)
            }

            AdMobBanner(unitId = "ca-app-pub-3940256099942544/6300978111")
        }
    }
}

@Preview
@Composable
fun EntryPagePreview() {
    EntryPage({}, {})
}
