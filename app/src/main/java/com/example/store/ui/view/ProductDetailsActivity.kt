package com.example.store.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import coil.load
import com.example.store.databinding.ActivityProductDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initElements()
    }

    private fun initElements() {
        val intent = intent
        val image = intent.getStringExtra("productImage")
        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val price = intent.getDoubleExtra("price",0.0)

        binding.photo.load(image)
        binding.title.text = title
        binding.description.text = description
        binding.price.text = "$ ${price}"
    }
}