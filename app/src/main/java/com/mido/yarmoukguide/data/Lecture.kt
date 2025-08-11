package com.mido.yarmoukguide.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lectures_table")
data class Lecture(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val subjectName: String,
    val location: String,
    val dayOfWeek: String,
    val startTime: String,
    val endTime: String
)