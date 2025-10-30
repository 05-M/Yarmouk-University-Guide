package com.mido.yarmoukguide.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CourseDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(courses: List<Course>)

    @Query("SELECT * FROM courses_table WHERE departmentOwnerId = :departmentId ORDER BY code ASC")
    fun getCoursesForDepartment(departmentId: Int): Flow<List<Course>>
}
