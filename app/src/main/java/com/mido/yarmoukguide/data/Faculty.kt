package com.mido.yarmoukguide.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "faculties_table")
data class Faculty(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val description: String
)