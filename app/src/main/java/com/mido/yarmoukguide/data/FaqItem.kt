package com.mido.yarmoukguide.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "faq_table")
data class FaqItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val question: String,
    val answer: String
)