package com.mido.yarmoukguide.userinterface.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mido.yarmoukguide.data.Faculty
import com.mido.yarmoukguide.data.FacultyRepository
import com.mido.yarmoukguide.data.YarmoukGuideDatabase
import kotlinx.coroutines.launch

class FacultiesViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: FacultyRepository
    val faculties: List<Faculty>
    init{
        val facultyDao = YarmoukGuideDatabase.getDataBase(application).facultyDao()
        repository = FacultyRepository(facultyDao)

        faculties = repository.getAllFaculties()
        if(faculties.isEmpty()){
            addInitialData()
        }
    }

    private fun addInitialData() {
        viewModelScope.launch {
            repository.addFaculty(Faculty(name = "Science", description = "Faculty of science...."))
            repository.addFaculty(Faculty(name = "Medicine", description = "Faculty of medicine..."))
            repository.addFaculty(Faculty(name = "Engineering", description = "Faculty of engineering..."))
            repository.addFaculty(Faculty(name = "Law", description = "Faculty of law..."))
        }
    }


}