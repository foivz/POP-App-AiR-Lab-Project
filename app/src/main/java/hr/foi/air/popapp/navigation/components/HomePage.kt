package hr.foi.air.popapp.navigation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.DrawerValue
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalDrawer
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hr.foi.air.popapp.context.Auth
import hr.foi.air.popapp.ui.components.MenuItem
import hr.foi.air.popapp.ui.theme.POPAppTheme
import kotlinx.coroutines.launch
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
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    ModalDrawer(drawerState = drawerState, drawerContent = {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.surface),
                onClick = {

                }
            ) {
                Icon(
                    imageVector = Icons.Default.Build,
                    contentDescription = null,
                    tint = MaterialTheme.colors.primary,
                    modifier = Modifier.size(48.dp)
                )
                Text(text = "Buy a new app theme")
            }
        }
    }) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Welcome, ${Auth.loggedInUserData?.firstName ?: "[Unknown name]"}")
                    },
                    navigationIcon = {
                        Button(onClick = {
                            coroutineScope.launch {
                                when (drawerState.currentValue) {
                                    DrawerValue.Open -> drawerState.close()
                                    DrawerValue.Closed -> drawerState.open()
                                }
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = null,
                            )
                        }
                    },
                )
            }
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background)
                    .padding(it)
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
