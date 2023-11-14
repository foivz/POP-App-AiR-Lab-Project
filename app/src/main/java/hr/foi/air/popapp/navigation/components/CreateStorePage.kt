package hr.foi.air.popapp.navigation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.utsman.osmandcompose.OpenStreetMap
import com.utsman.osmandcompose.rememberCameraState
import hr.foi.air.popapp.ui.components.StyledTextField
import org.osmdroid.util.GeoPoint

@Composable
fun CreateStorePage(onStoreCreated: (newStoreId: Int) -> Unit) {
    var storeName by remember { mutableStateOf("") }
    val cameraState = rememberCameraState {
        geoPoint = GeoPoint(46.307679, 16.338106)
        zoom = 18.5
    }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Create a Store",
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(vertical = 10.dp)
            )

            StyledTextField(
                label = "Your new store name",
                value = storeName,
                onValueChange = { storeName = it },
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }

        OpenStreetMap(
            modifier = Modifier
                .fillMaxHeight(0.75f)
                .fillMaxWidth(),
            cameraState = cameraState
        )
    }
}

@Preview
@Composable
fun CreateStorePagePreview() {
    CreateStorePage({})
}
