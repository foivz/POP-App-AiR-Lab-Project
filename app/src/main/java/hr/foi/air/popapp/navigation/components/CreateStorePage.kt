package hr.foi.air.popapp.navigation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.utsman.osmandcompose.MapProperties
import com.utsman.osmandcompose.Marker
import com.utsman.osmandcompose.OpenStreetMap
import com.utsman.osmandcompose.ZoomButtonVisibility
import com.utsman.osmandcompose.rememberCameraState
import com.utsman.osmandcompose.rememberMarkerState
import hr.foi.air.popapp.ui.components.StyledButton
import hr.foi.air.popapp.ui.components.StyledTextField
import org.osmdroid.util.GeoPoint

@Composable
fun CreateStorePage(onStoreCreated: (newStoreId: Int) -> Unit) {
    var storeName by remember { mutableStateOf("") }
    val storeLocationMarkerState = rememberMarkerState(
        geoPoint = GeoPoint(0.0, 0.0)
    )
    val cameraState = rememberCameraState {
        geoPoint = GeoPoint(46.307679, 16.338106)
        zoom = 18.5
        speed = 10
    }
    var isStoreSet: Boolean by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        Text(
            text = "Create a Store",
            style = MaterialTheme.typography.h4,
        )

        StyledTextField(
            label = "Your new store name",
            value = storeName,
            onValueChange = { storeName = it },
        )

        Text(
            text = "Hold your finger where you want your store to be.",
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center
        )

        OpenStreetMap(
            modifier = Modifier
                .fillMaxHeight(0.75f)
                .fillMaxWidth()
                .border(2.dp, Color.Black, AbsoluteRoundedCornerShape(10.dp))
                .clip(AbsoluteRoundedCornerShape(10.dp)),
            cameraState = cameraState,
            onMapLongClick = {
                storeLocationMarkerState.geoPoint = it
                isStoreSet = true
            },
            properties = MapProperties(
                minZoomLevel = 17.0,
                maxZoomLevel = 20.0,
                isFlingEnable = false,
                zoomButtonVisibility = ZoomButtonVisibility.NEVER,
                isTilesScaledToDpi = true
            )
        ) {
            Marker(
                state = storeLocationMarkerState,
                visible = isStoreSet,
                infoWindowContent = {
                    StyledButton(label = "Naziv trgovine", onClick = { /*TODO*/ })
                },
            )
        }

        StyledButton(label = "Create store", onClick = { /*TODO*/ })
    }
}

@Preview
@Composable
fun CreateStorePagePreview() {
    CreateStorePage({})
}
