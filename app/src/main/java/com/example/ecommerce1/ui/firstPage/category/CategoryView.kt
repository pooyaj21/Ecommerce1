package com.example.ecommerce1.ui.firstPage.category

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.marginStart
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce1.R
import com.example.ecommerce1.extentions.dp
import com.example.ecommerce1.model.Category

class CategoryView(context: Context) : LinearLayout(context) {

    private val titleTextView = TextView(context).apply {
        text = "Categories"
        setTextColor(ContextCompat.getColor(context, R.color.black))
        textSize = 19F
        setTypeface(null, Typeface.BOLD)
        setPadding(24.dp(),0,0,8.dp())
    }
    private val categoriesAdapter = CategoryAdapter()
    private val categoriesRecyclerView = RecyclerView(context).apply {
        adapter = categoriesAdapter
        clipToPadding = false
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        setPadding(20.dp(),0,0,0)
    }

    init {
        orientation = VERTICAL

        addView(
            titleTextView, LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.TOP or Gravity.START
            }
        )
        addView(
            categoriesRecyclerView, LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
            )
        )

    }

    fun bindData(categories: List<Category>) {
        categoriesAdapter.bindData(categories)
    }
}