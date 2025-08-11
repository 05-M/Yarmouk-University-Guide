// في ملف ui/viewmodel/ScheduleViewModel.kt

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.mido.yarmoukguide.data.Lecture
import com.mido.yarmoukguide.data.Repository
import com.mido.yarmoukguide.data.YarmoukGuideDatabase
import kotlinx.coroutines.flow.Flow

class ScheduleViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: Repository
    val weeklySchedule: Flow<List<Lecture>>

    init {
        val database = YarmoukGuideDatabase.getDatabase(application)
        // بنجيب كل الـ DAOs اللي محتاجينها
        val facultyDao = database.facultyDao()
        val departmentDao = database.departmentDao()
        val faqDao = database.faqDao()
        val lectureDao = database.lectureDao()
        val newsDao = database.newsDao()

        repository = Repository(facultyDao, departmentDao, faqDao, lectureDao, newsDao)

        // --- هنا بنجيب الجدول من الـ Repository ---
        weeklySchedule = repository.allLectures
    }
}