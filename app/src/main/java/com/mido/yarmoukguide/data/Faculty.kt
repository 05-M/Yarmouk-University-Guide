// في ملف: app/src/main/java/com/mido/GetYourGuide/data/Faculty.kt

package com.mido.yarmoukguide.data

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey

enum class FacultyType{
    SCIENTIFIC,
    HUMANITARIAN,
    MEDICAL
}

@Entity(tableName = "faculties_table")
data class Faculty(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0, // لازم قيمة افتراضية عشان autoGenerate
    val name: String,
    val description: String,
    val type: FacultyType,
    @DrawableRes val imageResId: Int,
    val contactInfo: String? = null,
    val locationOnMap:String? = null
)