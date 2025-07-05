package com.mido.yarmoukguide.data

class FacultyRepository(private val facultyDao: FacultyDao) {
    fun getAllFaculties(): List<Faculty>{
        return facultyDao.getAllFaculties()
    }

    suspend fun addFaculty(faculty: Faculty){
        facultyDao.insert(faculty)
    }
}