package shop.zamzambookshop.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import shop.zamzambookshop.app.data.model.Product
import shop.zamzambookshop.app.data.model.ProductCategory
import shop.zamzambookshop.app.data.repository.ProductRepository
import shop.zamzambookshop.app.ui.state.DataUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductViewModel(
    private val productRepository: ProductRepository,
) : ViewModel() {
    private val _allProductsState =
        MutableStateFlow<DataUiState<List<Product>>>(DataUiState.Initial)

    private val _productsState = MutableStateFlow<DataUiState<List<Product>>>(DataUiState.Initial)
    val productsState: StateFlow<DataUiState<List<Product>>>
        get() = _productsState.asStateFlow()

    private val _selectedCategoriesState = MutableStateFlow<Set<ProductCategory>>(emptySet())
    val selectedCategoriesState: StateFlow<Set<ProductCategory>>
        get() = _selectedCategoriesState.asStateFlow()

    init {
        observeProducts()
    }

    fun observeProducts() {
        viewModelScope.launch {
            productRepository.observeAll().collect { products ->
                _allProductsState.value = if (products.isNotEmpty()) {
                    DataUiState.Populated(products)
                } else {
                    DataUiState.Empty
                }

                updateProductsState()
            }
        }
    }

    private fun updateProductsState() {
        val allProductsState = _allProductsState.value
        val selectedCategories = _selectedCategoriesState.value

        _productsState.value = when (allProductsState) {
            DataUiState.Initial -> DataUiState.Initial

            DataUiState.Empty -> DataUiState.Empty

            is DataUiState.Populated -> {
                val filtered = if (selectedCategories.isEmpty()) {
                    allProductsState.data
                } else {
                    allProductsState.data.filter { it.category in selectedCategories }
                }

                if (filtered.isEmpty()) {
                    DataUiState.Empty
                } else {
                    DataUiState.Populated(filtered)
                }
            }

        }
    }


    fun selectCategory(category: ProductCategory) {
        _selectedCategoriesState.update { selected ->
            if (category in selected) selected - category else selected + category
        }
        updateProductsState()
    }
}