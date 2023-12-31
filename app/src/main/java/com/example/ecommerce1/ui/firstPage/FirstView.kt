package com.example.ecommerce1.ui.firstPage

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import com.example.ecommerce1.extentions.dp
import com.example.ecommerce1.repository.Lists
import com.example.ecommerce1.ui.firstPage.bottemBar.BottomBarView
import com.example.ecommerce1.ui.firstPage.category.CategoryView
import com.example.ecommerce1.ui.firstPage.popular.PopularView

class FirstView : Fragment() {

    private lateinit var frameLayout: FrameLayout
    private lateinit var scrollView: ScrollView
    private lateinit var linearLayout: LinearLayout
    private lateinit var actionBar: CustomFirstPageActionBar
    private lateinit var bannerView: Banner
    private lateinit var category: CategoryView
    private lateinit var popular: PopularView
    private lateinit var bottemBar: BottomBarView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        frameLayout = FrameLayout(requireContext())

        scrollView = ScrollView(requireContext())
        linearLayout = LinearLayout(requireContext()).apply {
            orientation = LinearLayout.VERTICAL
        }

        actionBar = CustomFirstPageActionBar(requireContext())
        bannerView = Banner(requireContext())
        category = CategoryView(requireContext())
        popular = PopularView(requireContext())
        bottemBar = BottomBarView(requireContext())

        frameLayout.addView(
            scrollView, FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
        )

        scrollView.addView(
            linearLayout, ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )

        linearLayout.addView(
            actionBar,
            LinearLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            )
        )

        linearLayout.addView(
            bannerView, LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                200.dp()
            )
        )
        linearLayout.addView(
            category, LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        )
        category.bindData(Lists.categories)

        val nestedScrollView = NestedScrollView(requireContext())
        nestedScrollView.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )

        nestedScrollView.addView(
            popular, LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        )
        popular.bindData(Lists.products)

        (nestedScrollView.layoutParams as LinearLayout.LayoutParams).bottomMargin =
            80.dp()

        linearLayout.addView(nestedScrollView)

        frameLayout.addView(
            bottemBar, FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                60.dp()
            ).apply {
                gravity = Gravity.BOTTOM
            }
        )

        return frameLayout
    }
}
