package com.example.ecommerce1.model

data class Product(
    val name: String,
    val description: String,
    val image: Int,
    val reviews: Int,
    val score: Double,
    val price: Int
)