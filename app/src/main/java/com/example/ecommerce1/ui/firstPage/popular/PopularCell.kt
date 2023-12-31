package com.example.ecommerce1.ui.firstPage.popular

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.ConstraintSet.*
import androidx.core.content.ContextCompat
import com.example.ecommerce1.R
import com.example.ecommerce1.extentions.dp
import com.example.ecommerce1.model.Product

class PopularCell(context: Context) : ConstraintLayout(context) {
    private val mainBackGround = GradientDrawable().apply {
        shape = GradientDrawable.RECTANGLE
        setColor(ContextCompat.getColor(context, R.color.gray))
    }
    private val favoriteBackGround = GradientDrawable().apply {
        val radius = 30.dp().toFloat()
        shape = GradientDrawable.RECTANGLE
        setColor(ContextCompat.getColor(context, R.color.white))
        cornerRadii = floatArrayOf(0f, 0f, radius, radius, radius, radius, 0f, 0f)
    }
    private val detailsBackGround = GradientDrawable().apply {
        val radius = 20.dp().toFloat()
        shape = GradientDrawable.RECTANGLE
        setColor(ContextCompat.getColor(context, R.color.white))
        cornerRadii = floatArrayOf(0f, 0f, 0f, 0f, radius, radius, radius, radius)
    }

    private val favoriteConstraint = ConstraintLayout(context).apply {
        id = generateViewId()
        background = favoriteBackGround
    }
    private val favoriteNumber = TextView(context).apply {
        id = generateViewId()
        text = "0"
        setTextColor(ContextCompat.getColor(context, R.color.black))
    }
    private val favoriteImage = ImageView(context).apply {
        id = generateViewId()
        setImageDrawable(ContextCompat.getDrawable(context, R.drawable.star))
    }

    private val productImage = ImageView(context).apply {
        id = generateViewId()
        background = mainBackGround
    }

    private val detailsConstraint = ConstraintLayout(context).apply {
        id = generateViewId()
        background = detailsBackGround
    }
    private val detailsTitle = TextView(context).apply {
        id = generateViewId()
        text = "Title"
        isSingleLine = true
        setTextColor(ContextCompat.getColor(context, R.color.black))
    }
    private val detailsPrice = TextView(context).apply {
        id = generateViewId()
        text = "$123"
        setTextColor(ContextCompat.getColor(context, R.color.green))
    }
    private val detailsReviewImage = ImageView(context).apply {
        id = generateViewId()
        setImageDrawable(ContextCompat.getDrawable(context, R.drawable.review))
    }
    private val detailsReviewText = TextView(context).apply {
        id = generateViewId()
        text = "1"
        setTextColor(ContextCompat.getColor(context, R.color.black))
    }

    init {
        elevation = 3F

        favoriteConstraint.apply {
            addView(
                favoriteNumber,
                LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            )
            addView(
                favoriteImage,
                LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            )

            ConstraintSet().apply {
                //Clone
                clone(favoriteConstraint)
                //number
                connect(favoriteNumber.id, BOTTOM, PARENT_ID, BOTTOM)
                connect(favoriteNumber.id, START, PARENT_ID, START, 8.dp())
                connect(favoriteNumber.id, TOP, PARENT_ID, TOP)
                //Star
                connect(favoriteImage.id, BOTTOM, PARENT_ID, BOTTOM)
                connect(favoriteImage.id, TOP, PARENT_ID, TOP)
                connect(favoriteImage.id, END, PARENT_ID, END)
                connect(favoriteImage.id, START, favoriteNumber.id, END)
                // Apply
                applyTo(favoriteConstraint)
            }
        }
        detailsConstraint.apply {
            addView(
                detailsTitle,
                LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            )
            addView(
                detailsPrice,
                LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            )
            addView(
                detailsReviewImage,
                LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            )
            addView(
                detailsReviewText,
                LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            )

            ConstraintSet().apply {
                //Clone
                clone(detailsConstraint)
                //Title
                connect(detailsTitle.id, START, PARENT_ID, START, 8.dp())
                connect(detailsTitle.id, TOP, PARENT_ID, TOP, 8.dp())
                //Price
                connect(detailsPrice.id, BOTTOM, PARENT_ID, BOTTOM)
                connect(detailsPrice.id, START, detailsTitle.id, START)
                connect(detailsPrice.id, TOP, detailsTitle.id, BOTTOM)
                //Review
                connect(detailsReviewImage.id, BOTTOM, detailsPrice.id, BOTTOM)
                connect(detailsReviewImage.id, END, PARENT_ID, END, 8.dp())

                connect(detailsReviewText.id, BOTTOM, detailsReviewImage.id, BOTTOM)
                connect(detailsReviewText.id, END, detailsReviewImage.id, START,8.dp())
                connect(detailsReviewText.id, TOP, detailsReviewImage.id, TOP)
                // Apply
                applyTo(detailsConstraint)
            }
        }



        addView(productImage, LayoutParams(175.dp(), 155.dp()))
        addView(favoriteConstraint, LayoutParams(55.dp(), 22.dp()))
        addView(detailsConstraint, LayoutParams(195.dp(), 70.dp()))

        ConstraintSet().apply {
            // Clone
            clone(this@PopularCell)
            // Image
            connect(productImage.id, START, PARENT_ID, START, 8.dp())
            connect(productImage.id, END, PARENT_ID, END, 8.dp())
            connect(productImage.id, TOP, PARENT_ID, TOP, 8.dp())
            // Favorite
            connect(favoriteConstraint.id, START, PARENT_ID, START)
            connect(favoriteConstraint.id, TOP, PARENT_ID, TOP, 16.dp())
            // Details
            connect(detailsConstraint.id, TOP, productImage.id, BOTTOM, 8.dp())
            connect(detailsConstraint.id, START, PARENT_ID, START)
            connect(detailsConstraint.id, END, PARENT_ID, END)
            // Apply
            applyTo(this@PopularCell)
        }
    }

    fun bindDate(product: Product) {
        detailsTitle.text = product.name
        detailsPrice.text = "$${product.price}"
        detailsReviewText.text = product.reviews.toString()
        favoriteNumber.text = product.score.toString()
        productImage.setImageDrawable(ContextCompat.getDrawable(context, product.image))
    }
}