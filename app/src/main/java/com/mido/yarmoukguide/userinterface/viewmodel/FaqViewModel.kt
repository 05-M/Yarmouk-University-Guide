// في ملف ui/viewmodel/FaqViewModel.kt

package com.mido.yarmoukguide.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.mido.yarmoukguide.data.FaqItem
import com.mido.yarmoukguide.data.Repository
import com.mido.yarmoukguide.data.YarmoukGuideDatabase
import kotlinx.coroutines.flow.Flow

class FaqViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: Repository
    val allFaqs: Flow<List<FaqItem>>

    init {
        // بنعمل نفس اللي عملناه في FacultiesViewModel
        val database = YarmoukGuideDatabase.getDatabase(application)
        val facultyDao = database.facultyDao()
        val departmentDao = database.departmentDao()
        val faqDao = database.faqDao()
        val lectureDao = database.lectureDao()
        val newsDao = database.newsDao()

        repository = Repository(facultyDao, departmentDao, faqDao, lectureDao, newsDao)

        // --- هنا بنجيب الأسئلة من الـ Repository ---
        allFaqs = repository.allFaqs
    }
}