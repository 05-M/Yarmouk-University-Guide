// في ملف ui/viewmodel/DepartmentViewModel.kt

package com.mido.yarmoukguide.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.mido.yarmoukguide.data.Course
import com.mido.yarmoukguide.data.Department
import com.mido.yarmoukguide.data.Professor
import com.mido.yarmoukguide.data.Repository
import com.mido.yarmoukguide.data.YarmoukGuideDatabase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class DepartmentViewModel(application: Application, savedStateHandle: SavedStateHandle) : AndroidViewModel(application) {

    private val repository: Repository

    // 1. بنجيب الـ departmentId اللي اتبعت للشاشة من الـ savedStateHandle
    private val departmentId: Int = checkNotNull(savedStateHandle["departmentId"])

    // 2. بنعرف الـ StateFlows بتاعتنا
    val department: StateFlow<Department?>
    val courses: StateFlow<List<Course>>
    val professors: StateFlow<List<Professor>>

    init {
        // بنركب البازل بتاع الـ Repository
        val database = YarmoukGuideDatabase.getDatabase(application)
        // ... (هنا المفروض نجيب كل الـ DAOs) ...
        val allDaos = database.let {
            Repository(it.facultyDao(), it.departmentDao(), it.faqDao(), it.lectureDao(), it.newsDao(), it.courseDao(), it.professorDao())
        }
        repository = allDaos

        // 3. بنبدأ نجيب البيانات تلقائياً باستخدام الـ ID اللي معانا
        department = repository.getDepartmentById(departmentId)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = null
            )

        courses = repository.getCoursesForDepartment(departmentId)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )

        professors = repository.getProfessorsForDepartment(departmentId)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )
    }
}