package com.example.store.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
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
                UiState.Loading -> {
                    binding.progressBar.isVisible = true
                }
                is UiState.Success -> {
                    binding.progressBar.isVisible = false
                    productsList.addAll(it.genericResponse)
                    binding.recyclerView.adapter?.notifyDataSetChanged()
                    Log.w("Data", it.toString())
                }
                is UiState.Failure -> {
                    binding.progressBar.isVisible = true
                    Toast.makeText(this, "Something wrong! :(", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}