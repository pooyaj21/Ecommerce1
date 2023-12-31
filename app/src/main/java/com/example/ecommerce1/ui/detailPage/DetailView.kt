package com.example.ecommerce1.ui.detailPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.generateViewId
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.ConstraintSet.*
import androidx.fragment.app.Fragment

class DetailView : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = ConstraintLayout(requireContext())

        val customActionBar = CustomDetailPageActionBar(requireContext()).apply {
            id = generateViewId()
        }
        rootView.addView(
            customActionBar,
            ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            )
        )

        ConstraintSet().apply {
            //Clone
            clone(rootView)
            //Action bar
            connect(customActionBar.id, START, PARENT_ID, START)
            connect(customActionBar.id, END, PARENT_ID, END)
            connect(customActionBar.id, TOP, PARENT_ID, TOP)
            // Apply
            applyTo(rootView)
        }

        return rootView
    }
}
