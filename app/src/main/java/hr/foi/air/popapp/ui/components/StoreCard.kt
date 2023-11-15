package hr.foi.air.popapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hr.foi.air.popapp.ui.theme.Shapes
import hr.foi.air.popapp.ui.theme.Typography
import hr.foi.air.popapp.ws.models.responses.Store

@Composable
fun StoreCard(store: Store) {
    Card(
        modifier = Modifier.padding(16.dp),
        shape = Shapes.medium,
        backgroundColor = MaterialTheme.colors.background,
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = store.latitude.toString(),
                style = Typography.caption,
                color = Color.Gray
            )
            Text(
                text = store.longitude.toString(),
                style = Typography.caption,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = store.name!!,
                style = Typography.h6,
                color = MaterialTheme.colors.primary
            )
        }
    }
}

@Preview
@Composable
fun StoreCardPreview() {
    StoreCard(
        store = Store(
            id = 0,
            name = "Preview Store",
            latitude = 46.308511369831756,
            longitude = 16.33807884329653
        )
    )
}
