package com.example.ecommerce1.ui.firstPage.category

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Typeface
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.ecommerce1.R
import com.example.ecommerce1.model.Category

class CategoryCell(context: Context) : LinearLayout(context) {
    private val imageView = ImageView(context).apply {}
    private val title = TextView(context).apply {
        textAlignment = TEXT_ALIGNMENT_CENTER
        setTextColor(ContextCompat.getColor(context, R.color.black))

    }

    private val imageSize = (Resources.getSystem().displayMetrics.widthPixels) / 5


    init {
        orientation = VERTICAL
        addView(imageView, LayoutParams(imageSize, imageSize))
        addView(
            title, LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT
            )
        )
    }

    fun bindCategory(category: Category) {
        imageView.setImageDrawable(ContextCompat.getDrawable(context, category.image))
        title.text = category.name
    }
}