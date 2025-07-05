package com.mido.yarmoukguide.data

data class Lecture(
    val id: Int,
    val subjectName: String,
    val location: String,
    val dayOfWeek: String,
    val startTime: String,
    val endTime: String
)