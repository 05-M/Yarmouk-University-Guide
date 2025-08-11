package com.mido.yarmoukguide.userinterface.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mido.yarmoukguide.data.Department
import com.mido.yarmoukguide.data.Faculty
import com.mido.yarmoukguide.data.FacultyType
import com.mido.yarmoukguide.data.Repository
import com.mido.yarmoukguide.data.YarmoukGuideDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

// تأكد من الباكج نيم

class FacultiesViewModel(application: Application): AndroidViewModel(application){
    private val repository: Repository
    val allFaculties: Flow<List<Faculty>>
    val facultiesByType: StateFlow<Map<FacultyType, List<Faculty>>>

    init{
        val database = YarmoukGuideDatabase.getDatabase(application)
        val facultyDao = database.facultyDao()
        val departmentDao = database.departmentDao()
        val faqDao = database.faqDao()
        repository = Repository(facultyDao, departmentDao, faqDao)

        allFaculties = repository.allFaculties

        facultiesByType = repository.allFaculties
            .map { list -> list.groupBy { it.type } } // بنقسم البيانات
            .stateIn( // بنحولها لـ StateFlow
                scope = viewModelScope, // بنستخدم الـ scope بتاع الـ ViewModel
                started = SharingStarted.WhileSubscribed(5000), // يبدأ يجمع لما الـ UI يبدأ يسمعله
                initialValue = emptyMap() // قيمة ابتدائية
            )
        checkAndPopulateInitialData()
    }

    private fun checkAndPopulateInitialData() {
        viewModelScope.launch(Dispatchers.IO){
            if(repository.allFaculties.firstOrNull().isNullOrEmpty()){
                println("Database is Empty.Populating initial data...")
                repository.insertInitialData()
            } else{
                println("Database already has data.Skipping populating")
            }
        }
    }


    fun getFacultyById(id: Int):Flow<Faculty?>{
        return repository.getFacultyById(id)
    }

    fun getDepartmentsForFaculty(facultyId: Int): Flow<List<Department>>{
        return repository.getDepartmentsForFaculty(facultyId)
    }
}

