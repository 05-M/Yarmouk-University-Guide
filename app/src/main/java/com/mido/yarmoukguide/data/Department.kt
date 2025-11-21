package com.mido.yarmoukguide.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "departments_table",
    foreignKeys = [
        ForeignKey(
            entity = Faculty::class,// بنقوله إن فيه علاقة مع جدول الكليات
            parentColumns = ["id"],// العمود اللي في جدول الكليات (اللي هو الـ Primary Key بتاعها)
            childColumns = ["facultyOwnerId"],// العمود اللي في جدول الأقسام اللي بيربطهم ببعض
            onDelete = ForeignKey.CASCADE// معناها: لو مسحنا كلية، امسح كل الأقسام اللي تابعة ليها تلقائياً
        )
    ]
)
data class Department(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val facultyOwnerId: Int,
    // --- الحقول الجديدة اللي هنضيفها ---
    val description: String? = null,         // الوصف الطويل بتاع القسم
    val headOfDepartment: String? = null,    // اسم رئيس القسم
    val locationInFaculty: String? = null,   // مكانه في الكلية
    val contactEmail: String? = null,        // ايميل التواصل
    val contactPhone: String? = null         // تليفون التواصل
    // نقدر نضيف أي حاجة تانية بعدين بنفس الطريقة
)