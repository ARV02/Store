package com.example.store.data.network.service

import com.example.store.data.model.ProductsResponse
import com.example.store.data.network.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductsService @Inject constructor(private val api: ApiInterface) {

    suspend fun getProducts(): List<ProductsResponse> {
        return withContext(Dispatchers.IO) {
            api.getProducts()
        }
    }
}