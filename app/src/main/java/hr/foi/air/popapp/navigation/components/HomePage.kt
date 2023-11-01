package hr.foi.air.popapp.navigation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hr.foi.air.popapp.context.Auth
import hr.foi.air.popapp.ui.components.MenuItem
import hr.foi.air.popapp.ui.theme.POPAppTheme
import hr.foi.air.popapp.ui.theme.Typography
import java.util.*

@Composable
fun HomePage(onMenuOptionSelected: (optionName: String) -> Unit) {
    val menuItems = listOf(
        "Products" to Icons.Default.ShoppingCart,
        "Balance" to Icons.Default.Star,
        "Invoices" to Icons.Default.List,
    )

    Column(modifier = Modifier.background(MaterialTheme.colors.background)) {
        Text(
            text = "Welcome, ${Auth.loggedInUserData?.firstName ?: "[Unknown name]"}",
            style = Typography.h4,
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colors.primaryVariant,
            textAlign = TextAlign.Center
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            items(menuItems) { (text, icon) ->
                MenuItem(text, icon) { onMenuOptionSelected(text.lowercase(Locale.getDefault())) }
            }
        }
    }
}

@Preview
@Composable
fun HomePagePreview() {
    POPAppTheme {
        HomePage({})
    }
}
