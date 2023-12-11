package hr.foi.air.popapp.navigation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hr.foi.air.popapp.context.Auth
import hr.foi.air.popapp.ui.components.MenuItem
import hr.foi.air.popapp.ui.theme.POPAppTheme
import hr.foi.air.popapp.ui.theme.Typography
import java.util.Locale

val menuItemsAll = listOf(
    "Balance" to Icons.Default.Star,
    "Invoices" to Icons.Default.List
)
val menuItemsBuyer = listOf(
    "Buy" to Icons.Default.ShoppingCart,
)
val menuItemsSeller = listOf(
    "Products" to Icons.Default.ShoppingCart,
)

@Composable
fun HomePage(onMenuOptionSelected: (optionName: String) -> Unit) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier.background(MaterialTheme.colors.primaryVariant),
                horizontalArrangement = Arrangement.End
            ) {
                Button(onClick = {

                }) {
                    Text(text = "Purchase a different app theme")
                }
            }
        }
    ) {

        Column(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(it)
        ) {
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
                items(getMenuItemsListBasedOnRole()) { (text, icon) ->
                    MenuItem(text, icon) {
                        onMenuOptionSelected(text.lowercase(Locale.getDefault()))
                    }
                }

                items(menuItemsAll) { (text, icon) ->
                    MenuItem(
                        text,
                        icon
                    ) { onMenuOptionSelected(text.lowercase(Locale.getDefault())) }
                }
            }
        }
    }
}

private fun getMenuItemsListBasedOnRole(): List<Pair<String, ImageVector>> {
    return when (Auth.loggedInUserData!!.role) {
        "buyer" -> menuItemsBuyer
        "seller" -> menuItemsSeller
        else -> listOf()
    }
}

@Preview
@Composable
fun HomePagePreview() {
    POPAppTheme {
        HomePage({})
    }
}
