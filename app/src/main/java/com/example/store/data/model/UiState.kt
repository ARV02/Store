package com.example.store.data.model

sealed class UiState {
    object Loading: UiState()
    data class Success(val genericResponse: List<ProductsResponse>): UiState()
    data class Failure(val message: String): UiState()
}