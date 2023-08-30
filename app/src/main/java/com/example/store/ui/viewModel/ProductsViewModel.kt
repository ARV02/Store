package com.example.store.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.store.data.model.ProductsResponse
import com.example.store.data.model.UiState
import com.example.store.data.repository.ProductsRepository
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(private val productsRepository: ProductsRepository): ViewModel() {
    private val gson = Gson()

    private val _getProducts = MutableLiveData<UiState>()
    val getProducts: LiveData<UiState> = _getProducts


    private fun getProducts() {
        viewModelScope.launch{
            _getProducts.postValue(UiState.Success(productsRepository.getProductsFromApi()))
        }
    }

    /*private fun saveProduct() {
        viewModelScope.launch {
            val json = gson.fromJson(productsRepository.getProductsFromApi().toString(), ProductsResponse::class.java)
            productsRepository.getProductFromDB(json)
        }
    }*/

    init {
        getProducts()
        //saveProduct()
    }
}