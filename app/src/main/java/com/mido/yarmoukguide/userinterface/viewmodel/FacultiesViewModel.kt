// في ملف: app/src/main/java/com/mido/yarmoukguide/ui/viewmodel/FacultiesViewModel.kt

package com.mido.yarmoukguide.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mido.yarmoukguide.data.Faculty
import com.mido.yarmoukguide.data.Repository
import com.mido.yarmoukguide.data.YarmoukGuideDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class FacultiesViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: Repository
    val allFaculties: Flow<List<Faculty>>

    init {
        val facultyDao = YarmoukGuideDatabase.getDatabase(application).facultyDao()
        repository = Repository(facultyDao)
        allFaculties = repository.allFaculties

        // نضيف البيانات المبدئية لو قاعدة البيانات فاضية
        viewModelScope.launch {
            if (repository.allFaculties.first().isEmpty()) {
                repository.insertInitialData()
            }
        }
    }

    // دالة عشان نجيب كلية واحدة بالـ ID بتاعها
    fun getFacultyById(id: Int): Flow<Faculty?> {
        return repository.getFacultyById(id)
    }
}