package com.mido.yarmoukguide.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "professors_table",
    foreignKeys = [
        ForeignKey(
            entity = Department::class,
            parentColumns = ["id"],
            childColumns = ["departmentOwnerId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Professor(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String, // اسم الدكتور
    val title: String, // درجته العلمية (e.g., "Professor", "Assistant Professor")
    val email: String? = null, // إيميله (اختياري)
    val officeLocation: String? = null, // مكان مكتبه (اختياري)
    val departmentOwnerId: Int // الـ ID بتاع القسم اللي الدكتور ده تبعه
)