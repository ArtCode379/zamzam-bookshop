package shop.zamzambookshop.app.ui.composable.screen.orders

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import shop.zamzambookshop.app.R
import shop.zamzambookshop.app.data.entity.OrderEntity
import shop.zamzambookshop.app.ui.composable.shared.DataBasedContainer
import shop.zamzambookshop.app.ui.composable.shared.DataEmptyContent
import shop.zamzambookshop.app.ui.composable.shared.ItemsList
import shop.zamzambookshop.app.ui.state.DataUiState
import shop.zamzambookshop.app.ui.viewmodel.OrderViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun OrdersScreen(
    modifier: Modifier = Modifier,
    viewModel: OrderViewModel = koinViewModel(),
) {
    val ordersState by viewModel.ordersState.collectAsState()

    OrdersContent(
        ordersState = ordersState,
        modifier = modifier,
    )
}

@Composable
private fun OrdersContent(
    ordersState: DataUiState<List<OrderEntity>>,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {

        DataBasedContainer(
            dataState = ordersState,

            dataPopulated = {
                OrdersPopulated(
                    orders = (ordersState as DataUiState.Populated).data,
                )
            },

            dataEmpty = {
                DataEmptyContent(
                    primaryText = stringResource(R.string.orders_state_empty_primary_text),
                    modifier = Modifier.fillMaxSize(),
                )
            },
        )
    }
}

@Composable
private fun OrdersPopulated(
    orders: List<OrderEntity>,
    modifier: Modifier = Modifier,
) {

    ItemsList(
        items = orders,
        modifier = Modifier.fillMaxSize(),
        itemCard = { order -> OrderItem(order) }
    )
}