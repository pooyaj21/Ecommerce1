package com.example.ecommerce1.repository

import com.example.ecommerce1.R
import com.example.ecommerce1.model.Category
import com.example.ecommerce1.model.Product

object Lists {
    val categories = listOf(
        Category(R.drawable.cat1, "Digitals"),
        Category(R.drawable.cat2, "cloths"),
        Category(R.drawable.cat3, "Tools"),
        Category(R.drawable.cat4, "Beauty")
    )

    val products = listOf(
        Product(
            "T-shirt black",
            "Elevate your wardrobe with our Classic Black Tee – a versatile and essential piece for every closet.\n" +
                    "Crafted with the perfect blend of comfort and style, this T-shirt is made from premium, breathable fabric that feels soft against your skin.\n" +
                    "The timeless black hue effortlessly complements any outfit, making it a go-to choice for casual days or a night out.\n" +
                    "The classic fit ensures a flattering silhouette for all body types, while the durable construction ensures long-lasting wear.\n" +
                    "Whether you're dressing up or keeping it casual, our Classic Black Tee is the wardrobe staple you've been looking for.\n" +
                    "Upgrade your style with simplicity – order yours today!",
            R.drawable.item_1, 15, 4.0, 500
        ),
        Product(
            "Smart Watch",
            "Step into the future with our cutting-edge Smart Watch. This sleek and stylish device seamlessly combines fashion with functionality, providing you with a world of possibilities at your fingertips.\n" +
                    "Featuring advanced health monitoring capabilities, stay on top of your fitness goals with real-time heart rate, sleep tracking, and activity analysis. The intuitive touch screen interface allows you to effortlessly navigate through a range of features,\n" +
                    " from receiving notifications and calls to controlling your music and capturing moments with the built-in camera.\n" +
                    "Designed for the modern lifestyle, our Smart Watch is water-resistant, ensuring it can keep up with your active routine. Sync it with your smartphone to unlock even more features and customization options.\n" +
                    "Stay connected, stay fit, and stay on time with our Smart Watch Revolution. Embrace the future today!",
            R.drawable.item_2,
            10,
            4.5,
            450
        ),
        Product(
            "Iphone 14",
            "Introducing the iPhone 14, where innovation meets sophistication. Elevate your mobile experience with cutting-edge technology and sleek design.\n" +
                    "The iPhone 14 boasts a stunning edge-to-edge display that brings your content to life with vibrant colors and sharp clarity. Capture moments like never before with an advanced camera system that pushes the boundaries of mobile photography.\n" +
                    "Under the hood, a powerful processor ensures seamless performance, allowing you to multitask, game, and stream with ease. The latest iOS brings new features and enhancements, keeping you at the forefront of mobile technology.\n" +
                    "Stay connected in style with the sleek and premium build of the iPhone 14. With enhanced security features and a range of customization options, it's not just a phone; it's a statement.\n" +
                    "Experience the future of smartphones – pre-order your iPhone 14 now and join the next generation of mobile innovation!",
            R.drawable.item_3,
            15,
            4.3,
            800
        ),
        Product(
            "Vision Pro LED TV",
            "Immerse yourself in the ultimate entertainment experience with the Vision Pro LED TV. Elevate your viewing with stunning visuals and cutting-edge technology.\n" +
                    "Featuring a sleek, slim design, this TV seamlessly blends with any room decor. The vibrant and crystal-clear display brings your favorite shows, movies, and games to life in vivid detail.\n" +
                    "With smart functionality, the Vision Pro LED TV lets you access a world of content. Stream your favorite apps, browse the web, and enjoy a range of features at your fingertips. The intuitive remote control and user-friendly interface make navigating a breeze.\n" +
                    "Enhance your audio-visual experience with powerful sound that complements the stunning visuals. Whether you're a movie buff, a gamer, or a sports enthusiast, the Vision Pro LED TV delivers a captivating experience.\n" +
                    "Upgrade your home entertainment setup – bring home the Vision Pro LED TV and redefine the way you watch, play, and enjoy!",
            R.drawable.item_4,
            18,
            4.0,
            1500
        )
    )
}