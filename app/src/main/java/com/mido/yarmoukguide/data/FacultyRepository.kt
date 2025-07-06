// في ملف: app/src/main/java/com/mido/yarmoukguide/data/Repository.kt

package com.mido.yarmoukguide.data

import kotlinx.coroutines.flow.Flow

class Repository(private val facultyDao: FacultyDao) {

    val allFaculties: Flow<List<Faculty>> = facultyDao.getAllFaculties()

    fun getFacultyById(id: Int): Flow<Faculty?> {
        return facultyDao.getFacultyById(id)
    }

    suspend fun insertInitialData() {
        facultyDao.insert(Faculty(name = "Science", description = "The Faculty of Science has many departments..."))
        facultyDao.insert(Faculty(name = "Medicine", description = "The Faculty of Medicine is one of the top faculties..."))
        facultyDao.insert(Faculty(name = "Engineering", description = "The Faculty of Engineering is known for..."))
        facultyDao.insert(Faculty(name = "Law", description = "The Faculty of Law prepares students for..."))
    }
}