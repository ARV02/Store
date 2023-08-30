package com.example.store.data.repository

import com.example.store.data.database.DBHelper
import com.example.store.data.model.ProductsResponse
import com.example.store.data.network.service.ProductsService
import javax.inject.Inject

class ProductsRepository @Inject constructor(private val productsService: ProductsService,
                                             /*private val productDB: DBHelper*/) {

    suspend fun getProductsFromApi(): List<ProductsResponse> {
        return productsService.getProducts()
    }

    /*suspend fun getProductFromDB(product: ProductsResponse) {
        productDB.addProduct(product)
    }*/
}