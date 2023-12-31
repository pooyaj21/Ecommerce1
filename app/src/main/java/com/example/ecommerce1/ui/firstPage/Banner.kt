package com.example.ecommerce1.ui.firstPage

import android.content.Context
import android.content.res.Resources
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.ConstraintSet.*
import androidx.core.content.ContextCompat
import com.example.ecommerce1.R
import com.example.ecommerce1.extentions.dp

class Banner(context: Context) : ConstraintLayout(context) {
    private val buttonBackgroundShape = GradientDrawable().apply {
        val radius = 50 * Resources.getSystem().displayMetrics.density
        shape = GradientDrawable.RECTANGLE
        setColor(ContextCompat.getColor(context, R.color.orange))
        cornerRadius = radius
    }

    private val imageView = ImageView(context).apply {
        id = generateViewId()
        setImageDrawable(ContextCompat.getDrawable(context, R.drawable.top_banner))
    }
    private val titleTextView = TextView(context).apply {
        id = generateViewId()
        text = "Discount 20% For\nHeadPhones"
        setTextColor(ContextCompat.getColor(context, R.color.yellow))
        setTypeface(null, Typeface.BOLD)
        textSize = 20f
    }
    private val button = Button(context).apply {
        id = generateViewId()
        text = "Buy now"
        background = buttonBackgroundShape
    }

    private val mainMargin = 16.dp()
    private val imageMargin = 24.dp()

    init {
        addView(imageView, LayoutParams(0, 0))
        addView(titleTextView, LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT))
        addView(button, LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT))

        ConstraintSet().apply {
            //Clone
            clone(this@Banner)
            //Image
            connect(imageView.id, START, PARENT_ID, START, imageMargin)
            connect(imageView.id, END, PARENT_ID, END, imageMargin)
            connect(imageView.id, TOP, PARENT_ID, TOP, imageMargin)
            connect(imageView.id, BOTTOM, PARENT_ID, BOTTOM, imageMargin)
            //Title
            connect(titleTextView.id, BOTTOM, imageView.id, BOTTOM, mainMargin)
            connect(titleTextView.id, START, imageView.id, START, mainMargin)
            //Button
            connect(button.id, END, imageView.id, END, mainMargin)
            connect(button.id, BOTTOM, titleTextView.id, BOTTOM)
            connect(button.id, TOP, titleTextView.id, TOP, mainMargin)
            // Apply
            applyTo(this@Banner)
        }
    }

}