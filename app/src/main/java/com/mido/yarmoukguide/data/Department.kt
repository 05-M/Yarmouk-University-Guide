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
    val description: String? = null,
    val headOfDepartment: String? = null,
    val locationInFaculty: String? = null, // موقعه من الكلية
    val contactInfo: String? = null, // اتصل بنا
    val totalCreditHours: Int? = null, // عدد ساعات الخطة
    val estimatedCost: String? = null, // التكلفة التقديرية (كنص عشان ممكن يكون فيه تفاصيل)
    val careerFields: String? = null // مجالات العمل (كنص طويل، ممكن نفصله بـ \n)
    // ----------------------
)