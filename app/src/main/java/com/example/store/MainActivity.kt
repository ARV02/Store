package com.example.store

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.store.adapters.ProductsAdapter
import com.example.store.data.model.UiState
import com.example.store.data.model.ProductsResponse
import com.example.store.databinding.ActivityMainBinding
import com.example.store.ui.viewModel.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var productsAdapter: ProductsAdapter

    private val productsViewModel: ProductsViewModel by viewModels()
    private val productsList = mutableListOf<ProductsResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initElements()
    }

    private fun initElements() {
        productsAdapter = ProductsAdapter(productsList, this)
        binding.recyclerView.adapter = productsAdapter
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        productsViewModel.getProducts.observe(this) {
            when(it) {
                UiState.Loading -> {}
                is UiState.Success -> {
                    productsList.addAll(it.genericResponse)
                    binding.recyclerView.adapter?.notifyDataSetChanged()
                    Log.w("Data", it.toString())
                }
                is UiState.Failure -> {}
            }
        }
    }
}