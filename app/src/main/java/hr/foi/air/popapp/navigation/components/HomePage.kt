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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.ads.AdSize
import hr.foi.air.popapp.ads.AdmobBanner
import hr.foi.air.popapp.context.Auth
import hr.foi.air.popapp.ui.components.MenuItem
import hr.foi.air.popapp.ui.theme.POPAppTheme
import hr.foi.air.popapp.ui.theme.Typography
import java.util.Locale

val menuItemsAll: MutableList<Any> = mutableListOf(
    "Balance" to Icons.Default.Star,
    "Invoices" to Icons.Default.List
)
val menuItemsBuyer: MutableList<Any> = mutableListOf(
    "Buy" to Icons.Default.ShoppingCart,
)
val menuItemsSeller: MutableList<Any> = mutableListOf(
    "Products" to Icons.Default.ShoppingCart,
)

@Composable
fun HomePage(onMenuOptionSelected: (optionName: String) -> Unit) {
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

            val menuItemsList = getMenuItemsListBasedOnRole()

            items(menuItemsList) { listElement ->
                if (listElement is Pair<*, *>) {
                    val (text, icon) = listElement as Pair<String, ImageVector>
                    MenuItem(text, icon) {
                        onMenuOptionSelected(text.lowercase(Locale.getDefault()))
                    }
                } else if (listElement is String && listElement == "show commerical") {
                    AdmobBanner(adSize = AdSize.LARGE_BANNER, modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

private fun getMenuItemsListBasedOnRole(): MutableList<Any> {
    val menuItems = when (Auth.loggedInUserData!!.role) {
        "buyer" -> menuItemsBuyer
        "seller" -> menuItemsSeller
        else -> mutableListOf()
    }


    menuItemsAll.add("show commerical")
    menuItemsAll.add("show commerical")

    return menuItemsAll
}

@Preview
@Composable
fun HomePagePreview() {
    POPAppTheme {
        HomePage({})
    }
}
