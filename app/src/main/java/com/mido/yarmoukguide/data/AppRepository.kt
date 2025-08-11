// في ملف: app/src/main/java/com/mido/yarmoukguide/data/Repository.kt

package com.mido.yarmoukguide.data

import kotlinx.coroutines.flow.Flow
class Repository(
    private val facultyDao: FacultyDao,
    private val departmentDao: DepartmentDao,
    private val faqDao: FaqDao
) {

    val allFaculties: Flow<List<Faculty>> = facultyDao.getAllFaculties()

    fun getFacultyById(id: Int): Flow<Faculty?> {
        return facultyDao.getFacultyById(id)
    }

    fun getDepartmentsForFaculty(facultyId: Int): Flow<List<Department>> {
        return departmentDao.getDepartmentsForFaculty(facultyId)
    }

    val allFaqs: Flow<List<FaqItem>> = faqDao.getAllFaqs()

    suspend fun insertInitialData() {
        //الكليات الصحية
        facultyDao.insert(Faculty(id = 1, name = "Medicine", description = "The Faculty of Medicine is one of the top faculties...", type = FacultyType.MEDICAL))
        facultyDao.insert(Faculty(id = 2, name = "Pharmacy", description = "The Faculty of Pharmacy", type = FacultyType.MEDICAL))
        facultyDao.insert(Faculty(id = 3, name = "Nursing", description = "The Faculty of Nursing", type = FacultyType.MEDICAL))

        //الكليات العلمية
        facultyDao.insert(Faculty(id = 4, name = "Science", description = "The Faculty of Science has many departments...", type = FacultyType.SCIENTIFIC))
        facultyDao.insert(Faculty(id = 5, name = "Hijjawi", description = "The Faculty of Engineering is known for...", type = FacultyType.SCIENTIFIC))
        facultyDao.insert(Faculty(id = 6, name = "IT and CS", description = "The Faculty of IT", type = FacultyType.SCIENTIFIC))

        //الكليات الإنسانية
        facultyDao.insert(Faculty(id = 7, name = "Law", description = "The Faculty of Law prepares students for...", type = FacultyType.HUMANITARIAN))
        facultyDao.insert(Faculty(id = 8, name = "Arts", description = "The Faculty of Arts ", type = FacultyType.HUMANITARIAN))
        facultyDao.insert(Faculty(id = 9, name = "Business", description = "The Faculty of Business", type = FacultyType.HUMANITARIAN))
        facultyDao.insert(Faculty(id = 10, name = "Al-Shari'a", description = "The Faculty of Al-shari'a", type = FacultyType.HUMANITARIAN))
        facultyDao.insert(Faculty(id = 11, name = "Educational Science", description = "The Faculty of Educational Science", type = FacultyType.HUMANITARIAN))
        facultyDao.insert(Faculty(id = 12, name = "Physical Education & Sport Sciences", description = "The Faculty of Physical Education", type = FacultyType.HUMANITARIAN))
        facultyDao.insert(Faculty(id = 13, name = "Fine Arts", description = "The Faculty of Fine Arts", type = FacultyType.HUMANITARIAN))
        facultyDao.insert(Faculty(id = 14, name = "Archaeology And Anthropology", description = "The Faculty of Archaeology", type = FacultyType.HUMANITARIAN))
        facultyDao.insert(Faculty(id = 15, name = "Tourism and Hotels", description = "The Faculty of Tourism", type = FacultyType.HUMANITARIAN))
        facultyDao.insert(Faculty(id = 16, name = "Mass Communication", description = "The Faculty of Mass Communication", type = FacultyType.HUMANITARIAN))


        // أقسام كلية العلوم (اللي الـ ID بتاعها 4)
        departmentDao.insert(Department(name = "Physics", facultyOwnerId = 4, description = "Physics Department"))
        departmentDao.insert(Department(name = "Chemistry", facultyOwnerId = 4, description = "Chemistry Department"))
        departmentDao.insert(Department(name = "Mathematics", facultyOwnerId = 4, description = "Mathematics Department"))

        // أقسام كلية الهندسة (اللي الـ ID بتاعها 5)
        departmentDao.insert(Department(name = "Civil Engineering", facultyOwnerId = 5, description = "Civil Eng. Dept."))
        departmentDao.insert(Department(name = "Electrical Engineering", facultyOwnerId = 5, description = "Electrical Eng. Dept."))

        val initialFaqs = listOf(
            FaqItem(1, "كيف أسجل في الجامعة؟",
                "التسجيل يتم عبر بوابة الطالب الإلكترونية في بداية كل فصل دراسي. يجب عليك مراجعة التقويم الجامعي لمعرفة المواعيد الدقيقة."),
            FaqItem(2, "أين يقع مكتب شؤون الطلاب؟", "يقع مكتب شؤون الطلاب في مبنى الإدارة الرئيسي، الدور الثاني، مكتب رقم 204."),
            FaqItem(3, "كيف يمكنني الحصول على البطاقة الجامعية؟", "يمكنك استلام بطاقتك الجامعية من عمادة شؤون الطلبة بعد إتمام عملية التسجيل ودفع الرسوم."),
            FaqItem(4, "ما هي مواعيد عمل المكتبة؟", "المكتبة تفتح أبوابها من الساعة 8:00 صباحاً حتى الساعة 4:00 مساءً من الأحد إلى الخميس."),
            FaqItem(5, "هل يوجد سكن طلابي؟", "نعم، توفر الجامعة سكناً للطلاب والطالبات. يمكنك التقديم عبر موقع السكن الجامعي الرسمي.")
        )
        faqDao.insertAll(initialFaqs)
    }
}