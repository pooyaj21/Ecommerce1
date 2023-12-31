package com.example.ecommerce1.ui.firstPage.bottemBar

import android.content.Context
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat

class BottemBarCell(context: Context) : LinearLayout(context) {
    private val imageIcon = ImageView(context)
    private val title = TextView(context).apply {
        textAlignment = TEXT_ALIGNMENT_CENTER
    }
    init {
        orientation = VERTICAL
        addView(imageIcon, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT))
        addView(title, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT))
    }


    fun setImage(image: Int) {
        imageIcon.setImageDrawable(ContextCompat.getDrawable(context, image))
    }

    fun setTitle(title: String) {
        this.title.text = title
    }

    fun titleColor(color: Int) {
        title.setTextColor(ContextCompat.getColor(context, color))
    }
}