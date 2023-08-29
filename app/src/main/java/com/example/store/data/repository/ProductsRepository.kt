package com.example.store.data.repository

import com.example.store.data.model.ProductsResponse
import com.example.store.data.network.service.ProductsService
import javax.inject.Inject

class ProductsRepository @Inject constructor(private val productsService: ProductsService) {

    suspend fun getProductsFromApi(): List<ProductsResponse> {
        return productsService.getProducts()
    }
}