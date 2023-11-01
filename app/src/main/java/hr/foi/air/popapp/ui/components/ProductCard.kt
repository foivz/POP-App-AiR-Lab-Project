package hr.foi.air.popapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import hr.foi.air.popapp.ui.theme.Shapes
import hr.foi.air.popapp.ui.theme.Typography
import hr.foi.air.popapp.ws.models.responses.Product

@Composable
fun ProductCard(product: Product) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = Shapes.medium,
        backgroundColor = MaterialTheme.colors.background,
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Product ID: ${product.id}",
                style = Typography.caption,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = product.name!!,
                style = Typography.h6,
                color = MaterialTheme.colors.primary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = product.description!!,
                style = Typography.body1
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Price: $${product.price?.div(100)}",
                    style = Typography.h6,
                    color = MaterialTheme.colors.primary
                )
                Text(
                    text = "Quantity: ${product.quantity}",
                    style = Typography.h6
                )
            }
        }
    }
}
