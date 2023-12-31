package com.example.ecommerce1.ui.firstPage.popular

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce1.model.Product

class PopularAdapter :
    RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {
    private val products = mutableListOf<Product>()

    inner class PopularViewHolder(val popularCell: PopularCell) :
        RecyclerView.ViewHolder(popularCell)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val popularCell = PopularCell(parent.context)
        return PopularViewHolder(popularCell)
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val product = products[position]
        holder.popularCell.bindDate(product)
    }

    override fun getItemCount(): Int {
        return products.size
    }
    

    fun bindData(products: List<Product>) {
        this.products.clear()
        this.products.addAll(products)
        notifyDataSetChanged()
    }
}
