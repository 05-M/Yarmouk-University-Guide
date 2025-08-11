package com.mido.yarmoukguide.data

data class NewsItem(
    val id: Int,
    val title: String,
    val summary: String,
    val date: String,
    val imageUrl: String? = null
)