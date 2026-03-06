package shop.zamzambookshop.app.ui.composable.screen.products

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import shop.zamzambookshop.app.R
import shop.zamzambookshop.app.data.model.Product
import shop.zamzambookshop.app.data.model.ProductCategory
import shop.zamzambookshop.app.ui.composable.shared.DataBasedContainer
import shop.zamzambookshop.app.ui.composable.shared.DataEmptyContent
import shop.zamzambookshop.app.ui.state.DataUiState
import shop.zamzambookshop.app.ui.viewmodel.ProductViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProductsScreen(
    modifier: Modifier = Modifier,
    viewModel: ProductViewModel = koinViewModel(),
    onNavigateToProductDetails: (productId: Int) -> Unit,
) {
    val productsState by viewModel.productsState.collectAsState()
    val selectedCategoriesState by viewModel.selectedCategoriesState.collectAsState()

    ProductsContent(
        productsState = productsState,
        selectedCategories = selectedCategoriesState,
        modifier = modifier,
        onCategoryClick = viewModel::selectCategory,
        onNavigateToProductDetails = onNavigateToProductDetails,
    )
}

@Composable
private fun ProductsContent(
    productsState: DataUiState<List<Product>>,
    selectedCategories: Set<ProductCategory>,
    modifier: Modifier = Modifier,
    onCategoryClick: (ProductCategory) -> Unit,
    onNavigateToProductDetails: (productId: Int) -> Unit,
) {
    DataBasedContainer<List<Product>>(
        dataState = productsState,
        dataPopulated = {
            ProductsPopulated(
                products = (productsState as DataUiState.Populated).data,
                selectedCategories = selectedCategories,
                modifier = modifier,
                onCategoryClick = onCategoryClick,
                onNavigateToProductDetails = onNavigateToProductDetails,
            )
        },
        dataEmpty = {
            DataEmptyContent(
                primaryText = stringResource(R.string.products_state_empty_primary_text),
                modifier = Modifier.fillMaxSize(),
            )
        },
    )
}

@Composable
private fun ProductsPopulated(
    products: List<Product>,
    selectedCategories: Set<ProductCategory>,
    modifier: Modifier = Modifier,
    onCategoryClick: (ProductCategory) -> Unit,
    onNavigateToProductDetails: (productId: Int) -> Unit,
) {
    LazyColumn(modifier = modifier) {
        item {
            ArticleCarousel(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(bottom = 8.dp),
            )
        }

        item {
            ProductFilter(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.surfaceVariant),
                selectedCategories = selectedCategories,
                onCategoryClick = onCategoryClick,
            )
        }

        items(products) { product ->
            ZMZBKProductItem(
                product = product,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                onClick = { onNavigateToProductDetails(product.id) },
            )
        }
    }
}
