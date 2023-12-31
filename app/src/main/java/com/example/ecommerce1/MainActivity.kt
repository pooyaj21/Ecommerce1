package com.example.ecommerce1

import android.os.Bundle
import android.view.View.generateViewId
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.ecommerce1.ui.detailPage.DetailView
import com.example.ecommerce1.ui.firstPage.FirstView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val frameLayout = FrameLayout(this).apply {
            id = generateViewId()
        }
        val firstScreen = FirstView ()


        setContentView(frameLayout)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(frameLayout.id, firstScreen)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
        }

    }
}
