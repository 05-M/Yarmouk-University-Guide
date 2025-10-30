package com.mido.yarmoukguide.userinterface.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.mido.yarmoukguide.data.NewsItem
import com.mido.yarmoukguide.data.Repository
import com.mido.yarmoukguide.data.YarmoukGuideDatabase
import kotlinx.coroutines.flow.Flow

class NewsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository
    val allNews: Flow<List<NewsItem>>

    init {
        val database = YarmoukGuideDatabase.getDatabase(application)
        // بنجيب كل الـ DAOs اللي محتاجينها
        val facultyDao = database.facultyDao()
        val departmentDao = database.departmentDao()
        val faqDao = database.faqDao()
        val lectureDao = database.lectureDao()
        val newsDao = database.newsDao()
        val courseDao = database.courseDao()
        val professorDao = database.professorDao()


        repository = Repository(facultyDao, departmentDao, faqDao, lectureDao, newsDao,courseDao,professorDao)

        allNews = repository.allNews
    }
}