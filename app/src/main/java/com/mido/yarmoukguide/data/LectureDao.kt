// في ملف data/LectureDao.kt
package com.mido.yarmoukguide.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface LectureDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(lectures: List<Lecture>)

    @Query("SELECT * FROM lectures_table")
    fun getAllLectures(): Flow<List<Lecture>>
}