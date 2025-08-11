package com.mido.yarmoukguide.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_table")
data class NewsItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val summary: String,
    val date: String,
    val imageUrl: String? = null
)