package com.mido.yarmoukguide.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DepartmentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(department: Department)

    @Query("SELECT * FROM departments_table WHERE facultyOwnerId = :facultyId ORDER BY name ASC")
    fun getDepartmentsForFaculty(facultyId: Int): Flow<List<Department>>
}