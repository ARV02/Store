package com.example.store.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.store.data.model.UiState
import com.example.store.data.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(private val productsRepository: ProductsRepository): ViewModel() {
    private val _getProducts = MutableLiveData<UiState>()
    val getProducts: LiveData<UiState> = _getProducts

    fun getProducts() {
        viewModelScope.launch{
            _getProducts.postValue(UiState.Success(productsRepository.getProductsFromApi()))
        }
    }

    init {
        getProducts()
    }
}