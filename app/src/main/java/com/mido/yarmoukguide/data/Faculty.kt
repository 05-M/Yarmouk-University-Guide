// في ملف: app/src/main/java/com/mido/yarmoukguide/data/Faculty.kt

package com.mido.yarmoukguide.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "faculties_table")
data class Faculty(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0, // لازم قيمة افتراضية عشان autoGenerate
    val name: String,
    val description: String
)