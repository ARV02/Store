package com.example.store.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.store.data.model.ProductsResponse
import com.example.store.databinding.ProductsItemBinding

class ProductsViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ProductsItemBinding.bind(view)

    fun bind(products: ProductsResponse) {
        binding.productImage.load(products.image)
        binding.productTitle.text = products.title
        binding.productDescription.text = products.description
    }
}