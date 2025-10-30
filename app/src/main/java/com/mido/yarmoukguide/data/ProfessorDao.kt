package com.mido.yarmoukguide.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfessorDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(professors: List<Professor>)

    @Query("SELECT * FROM professors_table WHERE departmentOwnerId = :departmentId ORDER BY name ASC")
    fun getProfessorsForDepartment(departmentId: Int): Flow<List<Professor>>
}