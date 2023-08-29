package com.example.store.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.store.R
import com.example.store.data.model.ProductsResponse
import com.example.store.ui.view.ProductDetailsActivity

class ProductsAdapter(private val productsList: List<ProductsResponse>,
                      private val context: Context): RecyclerView.Adapter<ProductsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductsViewHolder(layoutInflater.inflate(R.layout.products_item, parent, false))
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val items = productsList[position]
        holder.bind(items)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ProductDetailsActivity::class.java)
            intent.apply {
                putExtra("productImage", items.image)
                putExtra("title", items.title)
                putExtra("description", items.description)
                putExtra("price", items.price)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = productsList.size
}