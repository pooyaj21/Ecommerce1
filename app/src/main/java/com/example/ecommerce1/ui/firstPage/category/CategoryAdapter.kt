package com.example.ecommerce1.ui.firstPage.category

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce1.R
import com.example.ecommerce1.model.Category

class CategoryAdapter() : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private val categories = mutableListOf<Category>()

    inner class CategoryViewHolder(val categoryCell: CategoryCell) :
        RecyclerView.ViewHolder(categoryCell)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val categoryCell = CategoryCell(parent.context)
        return CategoryViewHolder(categoryCell)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.categoryCell.bindCategory(category)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    fun bindData(categories: List<Category>) {
        this.categories.clear()
        this.categories.addAll(categories)
        this.categories.add(Category(R.drawable.cat5,"View all"))
        notifyDataSetChanged()
    }
}
