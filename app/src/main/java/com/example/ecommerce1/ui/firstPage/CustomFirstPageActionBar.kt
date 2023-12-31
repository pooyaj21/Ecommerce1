package com.example.ecommerce1.ui.firstPage

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.GradientDrawable
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.ConstraintSet.*
import androidx.core.content.ContextCompat
import com.example.ecommerce1.R
import com.example.ecommerce1.extentions.dp

class CustomFirstPageActionBar(context: Context) : ConstraintLayout(context) {
    private val backGroundShape = GradientDrawable().apply {
        val radius = 30 * Resources.getSystem().displayMetrics.density
        shape = GradientDrawable.RECTANGLE
        setColor(ContextCompat.getColor(context, R.color.green))
        cornerRadii = floatArrayOf(0f, 0f, 0f, 0f, radius, radius, radius, radius)
    }
    private val editTextBackGroundShape = GradientDrawable().apply {
        val radius = 10.dp()
        shape = GradientDrawable.RECTANGLE
        setColor(ContextCompat.getColor(context, R.color.white))
        cornerRadius = radius.toFloat()
    }

    private val welcomeTextView = TextView(context).apply {
        id = generateViewId()
        text = "Welcome"
        setTextColor(ContextCompat.getColor(context, R.color.white))
    }
    private val userNameTextView = TextView(context).apply {
        id = generateViewId()
        text = "User"
        setTextColor(ContextCompat.getColor(context, R.color.white))
    }
    private val bellImageView = ImageView(context).apply {
        id = generateViewId()
        setImageDrawable(ContextCompat.getDrawable(context, R.drawable.bell))
    }
    private val alertImageView = ImageView(context).apply {
        id = generateViewId()
        setImageDrawable(ContextCompat.getDrawable(context, R.drawable.red_circle))
    }
    private val searchTextView = EditText(context).apply {
        val mainPadding = 8.dp()
        id = generateViewId()
        setCompoundDrawablesRelativeWithIntrinsicBounds(
            ContextCompat.getDrawable(context, R.drawable.search_icon), null, null, null
        )
        setPadding(mainPadding, mainPadding, mainPadding, mainPadding)
        compoundDrawablePadding = mainPadding
        background = editTextBackGroundShape
        hint = "Search Anything"
        setHintTextColor(ContextCompat.getColor(context, R.color.hint_text))
        setTextColor(ContextCompat.getColor(context, R.color.black))
    }

    private val mainMargin = 24.dp()
    private val searchBarMargin = 16.dp()

    private val searchBarHeight = 50.dp()

    init {
        background = backGroundShape
        addView(welcomeTextView,  LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT))
        addView(userNameTextView, LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT))
        addView(bellImageView,    LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT))
        addView(alertImageView,   LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT))
        addView(searchTextView, LayoutParams(LayoutParams.MATCH_PARENT,searchBarHeight))

        ConstraintSet().apply {
            //Clone
            clone(this@CustomFirstPageActionBar)
            //Welcome
            connect(welcomeTextView.id, START, PARENT_ID, START, mainMargin)
            connect(welcomeTextView.id, TOP, PARENT_ID, TOP, mainMargin)
            //User
            connect(userNameTextView.id, START, PARENT_ID, START, mainMargin)
            connect(userNameTextView.id, TOP, welcomeTextView.id, BOTTOM)
            //Bell
            connect(bellImageView.id, END, PARENT_ID, END, mainMargin)
            connect(bellImageView.id, TOP, welcomeTextView.id, BOTTOM)
            //Alert
            connect(alertImageView.id, BOTTOM, bellImageView.id, TOP)
            connect(alertImageView.id, END, PARENT_ID, END, mainMargin)
            connect(alertImageView.id, START, bellImageView.id, END)
            connect(alertImageView.id, TOP, bellImageView.id, TOP)
            //Search
            connect(searchTextView.id, BOTTOM, PARENT_ID, BOTTOM,searchBarMargin)
            connect(searchTextView.id, END, PARENT_ID, END, mainMargin)
            connect(searchTextView.id, START, PARENT_ID, START,mainMargin)
            connect(searchTextView.id, TOP, userNameTextView.id, BOTTOM,searchBarMargin)
            // Apply
            applyTo(this@CustomFirstPageActionBar)
        }
    }
}