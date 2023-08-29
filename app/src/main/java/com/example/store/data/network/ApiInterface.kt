package com.example.store.data.network

import com.example.store.data.model.ProductsResponse
import retrofit2.http.GET

interface ApiInterface {

    @GET("products")
    suspend fun getProducts(): List<ProductsResponse>
}