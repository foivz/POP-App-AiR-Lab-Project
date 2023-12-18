package hr.foi.air.popapp.navigation.components

import android.app.Activity
import android.util.Log
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.billingclient.api.BillingClient
import com.android.billingclient.api.BillingClient.BillingResponseCode
import com.android.billingclient.api.BillingClientStateListener
import com.android.billingclient.api.BillingFlowParams
import com.android.billingclient.api.BillingResult
import com.android.billingclient.api.ProductDetails
import com.android.billingclient.api.PurchasesUpdatedListener
import com.android.billingclient.api.QueryProductDetailsParams
import com.android.billingclient.api.queryProductDetails
import hr.foi.air.popapp.context.Auth
import hr.foi.air.popapp.ui.components.MenuItem
import hr.foi.air.popapp.ui.theme.POPAppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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

private val purchasesUpdatedListener =
    PurchasesUpdatedListener { billingResult, purchases ->
        // To be implemented in a later section.
    }

private lateinit var billingClient: BillingClient

@Composable
fun HomePage(
    onMenuOptionSelected: (optionName: String) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    var queryProductDetailsParams: QueryProductDetailsParams? = null
    var queriedProductDetails: List<ProductDetails>? = null

    val context = LocalContext.current

    billingClient = BillingClient.newBuilder(context)
        .setListener(purchasesUpdatedListener)
        .enablePendingPurchases()
        .build()

    billingClient.startConnection(object : BillingClientStateListener {


        override fun onBillingSetupFinished(billingResult: BillingResult) {
            if (billingResult.responseCode == BillingResponseCode.OK) {
                Log.i("POPAPP_BILLING", "Google Billing - Successful: $billingResult")

                val productList = listOf(
                    QueryProductDetailsParams.Product.newBuilder()
                        .setProductId("red_theme")
                        .setProductType(BillingClient.ProductType.INAPP)
                        .build(),
                    QueryProductDetailsParams.Product.newBuilder()
                        .setProductId("blue_theme")
                        .setProductType(BillingClient.ProductType.INAPP)
                        .build()
                )
                queryProductDetailsParams = QueryProductDetailsParams.newBuilder().apply {
                    setProductList(productList)
                }.build()

                coroutineScope.launch {
                    val productDetailsResult = withContext(Dispatchers.IO) {
                        billingClient.queryProductDetails(queryProductDetailsParams!!)
                    }

                    queriedProductDetails = productDetailsResult.productDetailsList
                }

            } else {
                Log.i(
                    "POPAPP_BILLING",
                    "An error occured when setting up billing: ${billingResult.debugMessage}"
                )
            }
        }

        override fun onBillingServiceDisconnected() {
            Toast.makeText(context, "Disconnected from Google Billing", Toast.LENGTH_LONG).show()
        }
    })


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
                    val productDetailsParamsList = queriedProductDetails!!.map {
                        BillingFlowParams.ProductDetailsParams.newBuilder()
                            .setProductDetails(it)
                            .build()
                    }

                    val billingFlowParams = BillingFlowParams.newBuilder()
                        .setProductDetailsParamsList(productDetailsParamsList)
                        .build()


                    val billingResult =
                        billingClient.launchBillingFlow(context as Activity, billingFlowParams)

                    Log.i("BILLING_RESULT", billingResult.responseCode.toString())
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
