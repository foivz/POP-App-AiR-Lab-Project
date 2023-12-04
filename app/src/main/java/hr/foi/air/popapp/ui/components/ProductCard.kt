package hr.foi.air.popapp.ui.components

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import hr.foi.air.popapp.PaymentActivity
import hr.foi.air.popapp.ui.theme.Shapes
import hr.foi.air.popapp.ui.theme.Typography
import hr.foi.air.popapp.ws.models.responses.Product

@Composable
fun ProductCard(product: Product) {
    val context = LocalContext.current
    val intent = Intent(context, PaymentActivity::class.java)
    val decimalPrice: Double = product.price!!.div(100.0)
    Card(
        modifier = Modifier
            .padding(16.dp)
            .clickable {
                intent.putExtra("price", decimalPrice)
                context.startActivity(intent)
            },
        shape = Shapes.medium,
        backgroundColor = MaterialTheme.colors.background,
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
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
                    text = "Price: $$decimalPrice",
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

@Preview
@Composable
fun ProductCardPreview() {
    ProductCard(
        product = Product(
            id = 0,
            name = "Preview Product",
            description = "Lorem ipsum dolor sit amet",
            price = 10,
            quantity = 2
        )
    )
}
