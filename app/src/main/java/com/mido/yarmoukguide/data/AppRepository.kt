// في ملف: app/src/main/java/com/mido/yarmoukguide/data/Repository.kt

package com.mido.yarmoukguide.data

import kotlinx.coroutines.flow.Flow
class Repository(
    private val facultyDao: FacultyDao,
    private val departmentDao: DepartmentDao,
    private val faqDao: FaqDao,
    private val lectureDao: LectureDao,
    private val newsDao: NewsDao
) {

    val allFaculties: Flow<List<Faculty>> = facultyDao.getAllFaculties()

    fun getFacultyById(id: Int): Flow<Faculty?> {
        return facultyDao.getFacultyById(id)
    }

    fun getDepartmentsForFaculty(facultyId: Int): Flow<List<Department>> {
        return departmentDao.getDepartmentsForFaculty(facultyId)
    }

    val allFaqs: Flow<List<FaqItem>> = faqDao.getAllFaqs()

    val allLectures: Flow<List<Lecture>> = lectureDao.getAllLectures()

    val allNews: Flow<List<NewsItem>> = newsDao.getAllNews()

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

        val initialLectures = listOf(
            Lecture(1, "CS101: Intro to Programming", "Hall 101", "Sunday", "08:00 AM", "09:30 AM"),
            Lecture(2, "MATH201: Calculus II", "Hall 305", "Sunday", "11:30 AM", "01:00 PM"),

            // محاضرات يوم الإثنين
            Lecture(3, "PHY102: Physics II", "Lab 2B", "Monday", "10:00 AM", "11:30 AM"),

            // محاضرات يوم الثلاثاء
            Lecture(4, "CS101: Intro to Programming", "Hall 101", "Tuesday", "08:00 AM", "09:30 AM"),
            Lecture(5, "ENG205: Technical Writing", "Hall 401", "Tuesday", "02:00 PM", "03:30 PM"),

            // محاضرات يوم الأربعاء
            Lecture(6, "PHY102: Physics II", "Lab 2B", "Wednesday", "10:00 AM", "11:30 AM"),
            Lecture(7, "MATH201: Calculus II", "Hall 305", "Wednesday", "11:30 AM", "01:00 PM"),

            // محاضرات يوم الخميس
            Lecture(8, "ENG205: Technical Writing", "Hall 401", "Thursday", "02:00 PM", "03:30 PM")
        )
        lectureDao.insertAll(initialLectures)

        val initialNews =  listOf(
            NewsItem(1, "فتح باب التسجيل للفصل الصيفي", "أعلنت دائرة القبول والتسجيل عن بدء استقبال طلبات التسجيل للفصل الصيفي للعام الدراسي 2024/2025 اعتباراً من الأسبوع القادم.", "July 5, 2025", null),
            NewsItem(2, "ورشة عمل عن الذكاء الاصطناعي", "تنظم كلية تكنولوجيا المعلومات وعلوم الحاسوب ورشة عمل متقدمة حول أحدث تطبيقات الذكاء الاصطناعي. الدعوة عامة للجميع.", "July 8, 2025", "https://example.com/ai_workshop_image.jpg"),
            NewsItem(3, "نهائي بطولة الجامعة لكرة القدم", "تقام المباراة النهائية لبطولة الجامعة يوم الخميس القادم على الملعب الرئيسي. لا تفوتوا تشجيع فريقكم!", "July 10, 2025", null),
            NewsItem(4, "تأجيل امتحانات منتصف الفصل", "نظراً للظروف الجوية، تم تأجيل امتحانات منتصف الفصل المقررة يوم الأربعاء إلى إشعار آخر. يرجى متابعة الإعلانات.", "July 12, 2025", null),
            NewsItem(5, "افتتاح معرض الكتاب السنوي", "تدعوكم المكتبة الرئيسية لحضور افتتاح معرض الكتاب السنوي، والذي يضم آلاف العناوين الجديدة بخصومات خاصة للطلاب.", "July 15, 2025", "https://example.com/book_fair_image.jpg")
        )
        newsDao.insertAll(initialNews)
    }
}