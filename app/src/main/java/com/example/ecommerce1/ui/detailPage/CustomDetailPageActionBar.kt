package com.example.ecommerce1.ui.detailPage

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.ConstraintSet.*
import androidx.core.content.ContextCompat
import com.example.ecommerce1.R
import com.example.ecommerce1.extentions.dp

class CustomDetailPageActionBar(context: Context) : ConstraintLayout(context) {

    private val backButton = ImageView(context).apply {
        id = generateViewId()
        setImageDrawable(ContextCompat.getDrawable(context, R.drawable.arrow))
    }
    private val saveButton = ImageView(context).apply {
        id = generateViewId()
        setImageDrawable(ContextCompat.getDrawable(context, R.drawable.bookmark))
    }
    private val shareButton = ImageView(context).apply {
        id = generateViewId()
        setImageDrawable(ContextCompat.getDrawable(context, R.drawable.share))
    }

    init {
        id = generateViewId()

        addView(backButton, LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT))
        addView(saveButton, LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT))
        addView(shareButton, LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT))


        ConstraintSet().apply {
            //Clone
            clone(this@CustomDetailPageActionBar)
            //Back
            connect(backButton.id, START, PARENT_ID, START, 16.dp())
            connect(backButton.id, TOP, PARENT_ID, TOP, 24.dp())
            //Save
            connect(saveButton.id, BOTTOM, backButton.id, BOTTOM)
            connect(saveButton.id, END, PARENT_ID, END, 16.dp())
            connect(saveButton.id, TOP, backButton.id, TOP)
            //Share
            connect(shareButton.id, BOTTOM, saveButton.id, BOTTOM)
            connect(shareButton.id, END, saveButton.id, START, 8.dp())
            connect(shareButton.id, TOP, saveButton.id, TOP)
            // Apply
            applyTo(this@CustomDetailPageActionBar)
        }
    }
}