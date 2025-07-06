// في ملف: app/src/main/java/com/mido/yarmoukguide/data/FacultyDao.kt

package com.mido.yarmoukguide.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow // <<< هنستخدم Flow عشان البيانات تتحدث تلقائياً

@Dao
interface FacultyDao {

    // دالة لإضافة كلية واحدة
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(faculty: Faculty)

    // دالة لجلب كل الكليات، وهترجع Flow
    // Flow يعني "تيار" من البيانات، كل ما البيانات تتغير في قاعدة البيانات، الـ UI هيعرف لوحده
    @Query("SELECT * FROM faculties_table ORDER BY name ASC")
    fun getAllFaculties(): Flow<List<Faculty>>

    // دالة لجلب كلية واحدة بالـ ID بتاعها
    @Query("SELECT * FROM faculties_table WHERE id = :facultyId")
    fun getFacultyById(facultyId: Int): Flow<Faculty?> // ممكن ترجع null لو الـ ID مش موجود
}