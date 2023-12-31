package com.example.ecommerce1.ui.firstPage.bottemBar

import android.content.Context
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.example.ecommerce1.R

class BottomBarView(context: Context) : LinearLayout(context) {
    private val explorerCell = BottemBarCell(context).apply {
        setTitle("Explorer")
        setImage(R.drawable.btn_1)
        titleColor(R.color.green)
    }
    private val wishListCell = BottemBarCell(context).apply {
        setTitle("Wishlist")
        setImage(R.drawable.btn_2)
    }
    private val cartCell = BottemBarCell(context).apply {
        setTitle("Cart")
        setImage(R.drawable.btn_3)
    }
    private val profileCell = BottemBarCell(context).apply {
        setTitle("Profile")
        setImage(R.drawable.btn_4)
    }

    private val cellWidth = (context.resources.displayMetrics.widthPixels - 24) / 4

    init {
        setBackgroundColor(ContextCompat.getColor(context, R.color.white))
        setPadding(12,0,12,0)
        orientation = HORIZONTAL

        addView(explorerCell, LayoutParams(cellWidth, LayoutParams.MATCH_PARENT))
        addView(wishListCell, LayoutParams(cellWidth, LayoutParams.MATCH_PARENT))
        addView(cartCell, LayoutParams(cellWidth, LayoutParams.MATCH_PARENT))
        addView(profileCell, LayoutParams(cellWidth, LayoutParams.MATCH_PARENT))
    }
}
