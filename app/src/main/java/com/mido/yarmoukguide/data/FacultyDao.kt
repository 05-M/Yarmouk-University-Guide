package com.mido.yarmoukguide.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface FacultyDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(faculty: Faculty)

    @Update
    suspend fun update(faculty: Faculty)

    @Delete
    suspend fun delete(faculty: Faculty)

    @Query("SELECT * FROM faculties_table WHERE id = :facultyId")
    fun getFacultyById(facultyId: Int): Faculty?

    @Query("SELECT * FROM faculties_table ORDER BY name ASC")
    fun getAllFaculties(): List<Faculty>
}