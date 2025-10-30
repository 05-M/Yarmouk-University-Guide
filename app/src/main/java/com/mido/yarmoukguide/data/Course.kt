package com.mido.yarmoukguide.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "courses_table",
    foreignKeys = [
        ForeignKey(
            entity = Department::class,
            parentColumns = ["id"],
            childColumns = ["departmentOwnerId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Course(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String, // اسم المادة (e.g., "Calculus I")
    val code: String, // كود المادة (e.g., "MATH101")
    val creditHours: Int, // عدد الساعات المعتمدة
    val departmentOwnerId: Int // الـ ID بتاع القسم اللي المادة دي تابعة ليه
)