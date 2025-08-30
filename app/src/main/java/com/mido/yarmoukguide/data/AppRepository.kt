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
        facultyDao.insert(Faculty(id = 1,
            name = "Medicine",
            description = "The Faculty of Medicine at Yarmouk University was established in the academic year 2014/2013." +
                    " This was done to provide Jordan, the region," +
                    " and the world with competent doctors who are responsible and contribute to healthcare and scientific research." +
                    " The Faculty of Medicine is located within the campus of Yarmouk University," +
                    " the second oldest university in Jordan, established in 1976.",
            type = FacultyType.MEDICAL))

        facultyDao.insert(Faculty(id = 2,
            name = "Pharmacy",
            description = "The Faculty of Pharmacy at Yarmouk University was established in the academic year 2014/2013." +
                " This was done to provide Jordan, the region," +
                " and the world with competent doctors who are responsible and contribute to healthcare and scientific research." +
                " The Faculty of Pharmacy is located within the campus of Yarmouk University," +
                " the second oldest university in Jordan, established in 1976.",
            type = FacultyType.MEDICAL))

        facultyDao.insert(Faculty(id = 3,
            name = "Nursing",
            description = "The Faculty of Narcing in Yarmouk University was established in 2022...",
            type = FacultyType.MEDICAL))

        //الكليات العلمية
        facultyDao.insert(Faculty(id = 4,
            name = "Science",
            description = "The College of Science was established in 1976," +
                " concurrently with the establishment of the university, and was part of the College of Science and Arts." +
                " They were separated into two colleges in 1981. The college currently includes six academic departments:" +
                " Mathematics, Physics, Chemistry, Statistics, Life Sciences, and Earth and Environmental Sciences.",
            type = FacultyType.SCIENTIFIC))

        facultyDao.insert(Faculty(id = 5,
            name = "Hijjawi Faculty for Engineering Technology",
            description = "Hijjawi Faculty for Engineering Technology was established in 1984 through the generous " +
                    "support of the Scientific Foundation of Hisham Adeeb Hijjawi.",
            type = FacultyType.SCIENTIFIC))

        facultyDao.insert(Faculty(id = 6,
            name = "Faculty of information technology and computer science",
            description = "The Department of Information Technology was established at the beginning of " +
                    "the Faculty of Information Technology and Computer Science at Yarmouk University" +
                    " at the start of the academic year 2002/2003. The department offers a bachelor's" +
                    " degree in Business Information Technology and a specialization in Cybersecurity.",
            type = FacultyType.SCIENTIFIC))

        //الكليات الإنسانية
        facultyDao.insert(Faculty(id = 7,
            name = "Law",
            description = "The Law Faculty, as an independent entity, commenced its function in September 1999." +
                    "It succeeded the Law Department, which was established " +
                    "in 1991 as part of the Faculty of Economics & Administrative Sciences.",
            type = FacultyType.HUMANITARIAN))

        facultyDao.insert(Faculty(id = 8
            , name = "Arts",
            description = "When the University was established in 1976, " +
                    "the then Faculty of Arts and Science included specializations" +
                    " in science, arts, economics, and administrative sciences. The departments of Arabic, English," +
                    " Humanities and Social Sciences were the core of the Faculty of Arts," +
                    " which was established in 1981.",
            type = FacultyType.HUMANITARIAN))

        facultyDao.insert(Faculty(id = 9,
            name = "Business",
            description = "In 1981 Yarmouk University established a unique college under the title of" +
                    " “Faculty of Economics and Administrative Sciences”, with the objective of meeting stakeholders " +
                    "needs and contributing to the national business, organizational and management arena.",
            type = FacultyType.HUMANITARIAN))

        facultyDao.insert(Faculty(id = 10,
            name = "Al-Shari'a",
            description = "The Faculty of Al-shari'The Faculty of Sharia and Islamic Studies at Yarmouk University" +
                    "was established in 1990 to achieve the goals of higher education in the Hashemite Kingdom of Jordan." +
                    " It is a pioneering college that carries a significant burden of the concerns of this" +
                    " nation and strives hard to achieve the monumental objectives assigned to it," +
                    " whether related to education and caring for the student, who represents the core of the educational" +
                    " process, as he is the highest goal of this college, and being the most important element" +
                    " that supplies the local community with the capabilities and energies capable of meeting the needs of the present and the future",
            type = FacultyType.HUMANITARIAN))

        facultyDao.insert(Faculty(id = 11,
            name = "Educational Science",
            description = "The Faculty of Educational Sciences traces its origins to its early days as a department within the Faculty of Arts." +
                    " In the 1988/1989 academic year, it became an independent faculty, initially consisting of three departments:" +
                    " Education, Fine Arts, and Physical Education. In 1991/1992, the Department of Education expanded into three specialized departments:" +
                    " Curricula and Teaching Methods, Counseling and Educational Psychology, and Administration and Foundations of Education," +
                    " increasing the total number of departments to five. The following year, the Physical Education Department separated to" +
                    " form the independent Faculty of Physical Education. Later, in the 2001/2002 academic year," +
                    " the Fine Arts Department also became a separate faculty." +
                    "In the 2006/2007 academic year, the Primary Education Department branched off from the Department of Curricula" +
                    "and Teaching Methods. However, in 2016/2017, it was reintegrated under the name Department of Curriculum and Methods of " +
                    "Instruction. In 2023, the faculty’s name was officially changed from \"Faculty of Education\" to \"Faculty of Educational Sciences.\"",
            type = FacultyType.HUMANITARIAN))

        facultyDao.insert(Faculty(id = 12,
            name = "Physical Education & Sport Sciences",
            description = "The Faculty of Physical Education was established in 1993. Prior to this it was a department at the Faculty of Arts." +
                    "The department was incorporated in 1988 with the Faculty of Education and Fine Arts.",
            type = FacultyType.HUMANITARIAN))

        facultyDao.insert(Faculty(id = 13,
            name = "Fine Arts",
            description = "The Department of Fine Arts was founded at the beginning of the academic year 80/81 in the sections of the Faculty of Arts" +
                    " and remained in the Departments of Education and Arts, which was established in the academic year 88/89." +
                    " In 2000 year, the department became a College of Fine Arts .",
            type = FacultyType.HUMANITARIAN))

        facultyDao.insert(Faculty(id = 14,
            name = "Archaeology And Anthropology",
            description = "The Faculty of Archaeology and Anthropology at Yarmouk University was established in 1984, as the Institute of Archaeology and Anthropology," +
                    "aiming at conducting interdisciplinary researches and promoting public awareness of cultural heritage of Jordan and the Arab World.",
            type = FacultyType.HUMANITARIAN))

        facultyDao.insert(Faculty(id = 15,
            name = "Tourism and Hotels",
            description = "The College of Tourism and Hotel Management was established at Yarmouk University in the academic year 2011-2012 as part of the " +
                    "university's direction to provide qualified and specialized human resources that contribute to driving " +
                    "local economic and social development, and to contribute to improving the quality of tourism services" +
                    " locally and regionally by providing qualified and trained human resources in the tourism sector.",
            type = FacultyType.HUMANITARIAN))

        facultyDao.insert(Faculty(id = 16,
            name = "Mass Communication",
            description = "The Faculty of Mass Communication is one of the colleges of Yarmouk University in Jordan." +
                    " It was established in 1976 and is the first media college in Jordan.",
            type = FacultyType.HUMANITARIAN))

        //--------------------------------------------------------------------------------------------------------

        //أقسام الكليات
        // أقسام كلية الطب (اللي الـ ID بتاعها 1)
        departmentDao.insert(Department(name = "Department of Basic Medical Sciences", facultyOwnerId = 1, description = "Basic Medical Sciences department"))
        departmentDao.insert(Department(name = "Department of Basic Pathological Sciences (BPS)", facultyOwnerId = 1, description = "Basic Medical Sciences department"))
        departmentDao.insert(Department(name = "Department of Internal medicine", facultyOwnerId = 1, description = "Clinical Medical Sciences department"))
        departmentDao.insert(Department(name = "Department of General Surgery and Anesthesia", facultyOwnerId = 1, description = "Clinical Medical Sciences department"))
        departmentDao.insert(Department(name = "Department of Pediatrics, Family Medicine and Obstetrics & Gynecology", facultyOwnerId = 1, description = "Clinical Medical Sciences department"))

        // أقسام كلية الصيدلة (اللي الـ ID بتاعها 2)
        departmentDao.insert(Department(name = "Pharmaceutics and Pharmaceutical Technology", facultyOwnerId = 2, description = "Pharmaceutics and Pharmaceutical Technology department"))
        departmentDao.insert(Department(name = "Clinical Pharmacy and Pharmacy Practice", facultyOwnerId = 2, description = "Clinical Pharmacy and Pharmacy Practice department"))
        departmentDao.insert(Department(name = "Medicinal Chemistry and Pharmacognosy", facultyOwnerId = 2, description = "Medicinal Chemistry and Pharmacognosy department"))

        // أقسام كلية التمريض (اللي الـ ID بتاعها 3)
        departmentDao.insert(Department(name = "Basic Nursing", facultyOwnerId = 3, description = "Basic Nursing department"))
        departmentDao.insert(Department(name = "Clinical Nursing", facultyOwnerId = 3, description = "Clinical Nursing department"))

        // أقسام كلية العلوم (اللي الـ ID بتاعها 4)
        departmentDao.insert(Department(name = "Physics", facultyOwnerId = 4, description = "Physics Department"))
        departmentDao.insert(Department(name = "Chemistry", facultyOwnerId = 4, description = "Chemistry Department"))
        departmentDao.insert(Department(name = "Mathematics", facultyOwnerId = 4, description = "Mathematics Department"))
        departmentDao.insert(Department(name = "Statistics", facultyOwnerId = 4, description = "Statistics Department"))
        departmentDao.insert(Department(name = "Life Science", facultyOwnerId = 4, description = "Life Science Department"))
        departmentDao.insert(Department(name = "Earth and Environmental Science", facultyOwnerId = 4, description = "Earth and Environmental Science Department"))

        // أقسام كلية الهندسة (اللي الـ ID بتاعها 5)
        departmentDao.insert(Department(name = "Civil Engineering", facultyOwnerId = 5, description = "Civil Eng. Dept."))
        departmentDao.insert(Department(name = "Electronic Engineering", facultyOwnerId = 5, description = "Electrical Eng. Dept."))
        departmentDao.insert(Department(name = "Communication Engineering", facultyOwnerId = 5, description = "Communication Eng. Dept."))
        departmentDao.insert(Department(name = "Computer Engineering", facultyOwnerId = 5, description = "Computer Eng. Dept."))
        departmentDao.insert(Department(name = "Electrical Power Engineering", facultyOwnerId = 5, description = "Electrical Power Eng. Dept."))
        departmentDao.insert(Department(name = "Biomedical Systems and informatics Engineering", facultyOwnerId = 5, description = "Biomedical Systems Eng. Dept."))
        departmentDao.insert(Department(name = "industrial Engineering", facultyOwnerId = 5, description = "industrial Eng. Dept."))
        departmentDao.insert(Department(name = "Architectural Engineering", facultyOwnerId = 5, description = "Architectural Eng. Dept."))

        // أقسام كلية تكنولوجيا المعلومات (اللي الـ ID بتاعها 6)
        departmentDao.insert(Department(name = "Computer Science", facultyOwnerId = 6, description = "Computer Science Department"))
        departmentDao.insert(Department(name = "Information Systems", facultyOwnerId = 6, description = "Information Systems Department"))
        departmentDao.insert(Department(name = "Information Technology", facultyOwnerId = 6, description = "Information Technology Department"))

        // أقسام كلية القانون (اللي الـ ID بتاعها 7)
        departmentDao.insert(Department(name = "Public Law", facultyOwnerId = 7, description = "Public law Department"))
        departmentDao.insert(Department(name = "Private Law", facultyOwnerId = 7, description = "Private law Department"))

        // أقسام كلية الآداب (اللي الـ ID بتاعها 8)
        departmentDao.insert(Department(name = "Arabic Language", facultyOwnerId = 8, description = "Arabic language Department"))
        departmentDao.insert(Department(name = "English Language & Literature", facultyOwnerId = 8, description = "English Department"))
        departmentDao.insert(Department(name = "History & Civilization", facultyOwnerId = 8, description = "History & Civilization Department"))
        departmentDao.insert(Department(name = "Modern Languages", facultyOwnerId = 8, description = "Modern languages Department"))
        departmentDao.insert(Department(name = "Politics & International Studies", facultyOwnerId = 8, description = "Politics & International Studies Department"))
        departmentDao.insert(Department(name = "Sociology & Social Services", facultyOwnerId = 8, description = "Sociology & Social Services Department"))
        departmentDao.insert(Department(name = "Semitic & Oriental Languages", facultyOwnerId = 8, description = "Semitic & Oriental Languages Department"))
        departmentDao.insert(Department(name = "Geography", facultyOwnerId = 8, description = "Geography Department"))
        departmentDao.insert(Department(name = "Translation", facultyOwnerId = 8, description = "Translation Department"))
        departmentDao.insert(Department(name = "Humanitarian Service Courses", facultyOwnerId = 8, description = "Humanitarian Service Courses Department"))

        // أقسام كلية الأعمال (اللي الـ ID بتاعها 9)
        departmentDao.insert(Department(name = "Economics", facultyOwnerId = 9, description = "Economics Department"))
        departmentDao.insert(Department(name = "Business Administration", facultyOwnerId = 9, description = "Business Administration Department"))
        departmentDao.insert(Department(name = "Public Administration", facultyOwnerId = 9, description = "Public Administration Department"))
        departmentDao.insert(Department(name = "Finance & Banking Science", facultyOwnerId = 9, description = "Finance & Banking Science Department"))
        departmentDao.insert(Department(name = "Marketing", facultyOwnerId = 9, description = "Marketing Department"))
        departmentDao.insert(Department(name = "Accounting", facultyOwnerId = 9, description = "Accounting Department"))

        // أقسام كلية الشريعة (اللي الـ ID بتاعها 10)
        departmentDao.insert(Department(name = "Fiqh", facultyOwnerId = 10, description = "Fiqh Department"))
        departmentDao.insert(Department(name = "Usul Addin ", facultyOwnerId = 10, description = "Usul Addin Department"))
        departmentDao.insert(Department(name = "Islamic Economics & Banking", facultyOwnerId = 10, description = "Islamic Economics & Banking Department"))
        departmentDao.insert(Department(name = "Islamic Studies", facultyOwnerId = 10, description = "Islamic Studies Department"))

        // أقسام كلية العلوم التربوية (اللي الـ ID بتاعها 11)
        departmentDao.insert((Department(name = "Curriculum and Instruction", facultyOwnerId = 11, description = "Curriculum and Instruction Department")))
        departmentDao.insert((Department(name = "Counseling and Ed.Psychology", facultyOwnerId = 11, description = "Counseling and Ed.Psychology Department")))
        departmentDao.insert((Department(name = "Administration and Foundations", facultyOwnerId = 11, description = "Administration and Foundations Department")))


        // أقسام كلية التربية الرياضية (اللي الـ ID بتاعها 12)
        departmentDao.insert(Department(name = "Physical Education", facultyOwnerId = 12, description = "Physical Education Department"))
        departmentDao.insert(Department(name = "Sport Science", facultyOwnerId = 12, description = "Sport Science Department"))


        // أقسام كلية الفنون الجميلة (اللي الـ ID بتاعها 13)
        departmentDao.insert(Department(name = "Visual Arts", facultyOwnerId = 13, description = "Visual Arts Department"))
        departmentDao.insert(Department(name = "Drama", facultyOwnerId = 13, description = "Drama Department"))
        departmentDao.insert(Department(name = "Design", facultyOwnerId = 13, description = " Design Department"))
        departmentDao.insert(Department(name = "Music", facultyOwnerId = 13, description = "Music Department"))
        departmentDao.insert(Department(name = "Digital Arts", facultyOwnerId = 13, description = "Digital Arts Department"))
        departmentDao.insert(Department(name = "Art Education", facultyOwnerId = 13, description = "Art Education Department"))

        // أقسام كلية الآثار (اللي الـ ID بتاعها 14)
        departmentDao.insert(Department(name = "Archaeology", facultyOwnerId = 14, description = "Department of Archaeology"))
        departmentDao.insert(Department(name = "Anthropology", facultyOwnerId = 14, description = "Department of Anthropology"))
        departmentDao.insert(Department(name = " Conservation and Management of Cultural Resources", facultyOwnerId = 14, description = "Department of Conservation and Management of Cultural Resources "))

        // أقسام كلية السياحة والفنادق (اللي الـ ID بتاعها 15)
        departmentDao.insert(Department(name = "Hotel Management", facultyOwnerId = 15, description = "Hotel Management Department"))
        departmentDao.insert(Department(name = "Travel & Tourism", facultyOwnerId = 15, description = "Travel & Tourism Department"))

        // أقسام كلية الإعلام (اللي الـ ID بتاعها 16)
        departmentDao.insert(Department(name = "Journalism and Digital Media", facultyOwnerId = 16, description = "Journalism and Digital Media .Department"))
        departmentDao.insert(Department(name = "Radio and Television", facultyOwnerId = 16, description = "Radio and Television Department"))
        departmentDao.insert(Department(name = "Public Relations and Advertising", facultyOwnerId = 16, description = "Public Relations and Advertising Department"))


        val initialFaqs = listOf(
            FaqItem(1, "ماهي مميزات الدراسة في جامعة اليرموك؟",
                "تتميز جامعة اليرموك بأنها ثاني أقدم وأكبر جامعة رسمية في الأردن، وتعتبر من أعرق الجامعات الأردنية ،" +
                        " فتأسست بمرسوم ملكي سامي عام 1976. تقع داخل مدينة إربد شمال العاصمة الأردنية عمّان، مما يسهل الحصول على جميع الخدمات التي يحتاجها الطالب وعائلته." +
                        " يوجد في اليرموك 16 كلية، وعمادتان، و9 مراكز علمية، و5 كراسي علمية. تقدم شهادات متنوعة في مختلف الدرجات والتخصصات؛ 65    برنامج بكالوريوس و67 برنامج ماجستير،" +
                        " و16 برنامج دكتوراه، و3 برامج دبلوم عالٍ. تضم الجامعة حوالي 40,000 طالب وطالبة من 45 جنسية مختلفة، و1100 عضو هيئة تدريس من خريجي أعرق الجامعات العالمية المرموقة،" +
                        " و1400 " +
                        "موظف إداري. خرَّجت منذ نشأتها أكثر من 220 ألف طالب وطالبة." +
                        " ويوجد داخل اليرموك أكبر مكتبة في الأردن، وثلاثة متاحف، ومجمعات رياضية وتجارية، ويُعقد فيها العديد من النشاطات الرياضية والثقافية والفنية والمعارض الفنية والعروض الموسيقية. "),

            FaqItem(2, "ماهي التخصصات التي تقدمها جامعة اليرموك، وما هي رسوم ساعاتها المعتمدة؟",
                "يوجد أكثر من 148 برنامجاً في جامعة اليرموك؛ 65 برنامج بكالوريوس و67 برنامج ماجستير، و16 برنامج دكتوراه. للمزيد من المعلومات حول التخصصات المختلفة والرسوم الجامعية، " +
                        "قم بزيارة دائرة القبول والتسجيل (لبرامج البكالوريوس)، وعمادة البحث العلمي والدراسات العليا (لبرامج الماجستير والدكتوراه)."),

            FaqItem(3, "هل يوجد طلبات إلكترونية للتقديم مباشرة للدراسة في جامعة اليرموك؟",
                "نعم، بإمكانك الدخول عبر الروابط التالية وتقديم طلب إلكتروني لجميع طلبة الموازي والدولي (خارج طلبات القبول الموحد):\n" +
                        "\n" +
                        "بكالوريوس: https://talabat.yu.edu.jo\n" +
                        "دراسات عليا (ماجستير ودكتوراه): https://olia.yu.edu.jo\n" +
                        "دبلوم:https://diplom.yu.edu.jo"),

            FaqItem(4, "أين جامعة اليرموك من التصنيفات والتقييمات الدولية؟",
                "حصلت جامعة اليرموك في عام 2023 على تقييم 5 نجوم في تقييم QS-Stars من مؤسسة QS البريطانية، حيث حققت تقييم 5 نجوم في محاور: البيئة التدريسية، السمعة الوظيفية، التطوير الأكاديمي، المرافق والخدمات المساندة، الثقافة والفنون، والشمولية في خدمات ذوي الاحتياجات الخاصة.\n" +
                        "تقدمت جامعة اليرموك 200 مرتبة في تصنيف QS على مستوى الجامعات العالمية في إصدار 2024 لتصبح في المرتبة 1001-1200.\n" +
                        "تم تصنيف أنظمة المعلومات وعلوم الحاسوب في الترتيب 551-600 حسب تصنيف QS للمواضيع على مستوى الجامعات العالمية، كما تم تصنيف الأثار في الترتيب 201-240 في نفس التصنيف.\n" +
                        "تم تصنيف علوم الحاسوب في الترتيب 601-800 والفنون والعلوم الإنسانية في الترتيب 601+ والهندسة في الترتيب 801-1000 والعلوم الاجتماعية في الترتيب 801+ والأعمال في الترتيب 801+ والعلوم الفيزيائية في الترتيب 1000+ حسب تصنيف التايمز للتعليم العالي للمواضيع على مستوى الجامعات العالمية.\n" +
                        "صُنفت جامعة اليرموك في المرتبة 351-400 في تصنيف التايمز للعام 2023 لجامعات أسيا متقدمة 50 مرتبة مقارنة بالعام 2022.\n" +
                        "صُنفت جامعة اليرموك في المرتبة 301-350 في تصنيف التايمز للعام 2023 للجامعات الناشئة متقدمة 50 مرتبة مقارنة بالعام 2022.\n"),

            FaqItem(5, "ما هي الاعتمادات الدولية التي حصلت عليها جامعة اليرموك؟",
                "كلية السياحة - الاعتماد الدولي TedQal UNTO\n" +
                        "بعض تخصصات كلية الحجاوي للهندسة التكنولوجية - الاعتماد الأمريكي ABET\n" +
                        "بعص تخصصات كلية تكنولوجيا المعلومات وعلوم الحاسوب - الاعتماد الأمريكي ABET\n" +
                        "بعص تخصصات كلية العلوم - الاعتماد الأمريكي ABET\n" +
                        "كلية الصيدلة -الاعتماد الدولي ACPE\n" +
                        "كلية الطب – الاعتماد الدولي WFME\n" +
                        "كلية الأعمال – عضوية AACSB"),

            FaqItem(6,"ما هي مميزات مدينة إربد التي تقع فيها جامعة اليرموك؟",
                "إربد هي مدينة جامعية عريقة، أسماها اليونانيون قديماً باسم \"أرابيلا\" نسبةً لأراضيها الخصبة وسهولها الخضراء، مناخها المعتدل، وهي ثاني أكبر مدينة من حيث عدد السكان في الأردن، حيث يبلغ حوالي 2 مليون نسمة." +
                        " تقع على بعُد حوالي 70 كم شمال العاصمة عمان، وحوالي 20 كم جنوب الحدود السورية. يوجد فيها أماكن أثرية جميلة أهمها مدينة أم قيس التي تطل على نهر اليرموك" +
                        " وهضبة الجولان وبحيرة طبريا. وفيها العديد من المطاعم والأماكن الترفيهية والمراكز التجارية والصناعية كمدينة الحسن الرياضية التي تقع بجانب جامعة اليرموك." +
                        " كما تضم العديد من الجامعات الحكومية والخاصة، أبرزها جامعة اليرموك. للمزيد من المعلومات حول الأماكن السياحية في الأردن، قم بزيارة موقع تنشيط السياحة: http://ar.visitjordan.com/ "),

            FaqItem(7,"ما هي أماكن السكن والفنادق التي تقع في جامعة اليرموك ومحيطها؟",
                "يمكن للطالبات الوافدات استخدام السكن الجامعي داخل حرم جامعة اليرموك، والذي يكلف 15 دينارًا في الليلة (أو 250 دينارًا شهريًا)، حيث تقوم الجامعة في عمادة شؤون الطلبة - مكتب رقم (110)" +
                        " بتنفيذ فلسفة الجامعة المتعلقة بتأمين سكن مناسب للطالبات القادمات من خارج مدينة اربد، يبعد هذا السكن المسمى (ذات النطاقين)  حوالي ( 100 ) متر" +
                        " عن البوابة الشمالية للجامعة، وهيأت فيه سبل الراحة وكافة الخدمات الضرورية." +
                        " كما توجد العديد السكنات الطلابية والفنادق محيط الجامعة بإمكانك الذهاب إليها سيراً على الأقدام. تتراوح تكلفة الليلة في الفنادق من 30 - 50 دينار أردني (42- 70 دولاراً)."),

            FaqItem(8,"ماهي النشاطات التي يمكنني القيام بها داخل جامعة اليرموك؟",
                "زيارة مكتبة الجامعة: مكتبة الحسين بن طلال وهي من أكبر المكتبات على في الوطن العربي من حيث مساحتها وعدد المراجع والدوريات العلمية.\n" +
                        "زيارة المتاحف: يوجد ثلاثة متاحف في الحرم الجامعي: متحف التراث الأردني، ومتحف التاريخ الطبيعي، ومتحف النقود.\n" +
                        "نشاطات متنوعة في عمادة شؤون الطلبة، كالنشاطات الرياضية والثقافية والفنية والمعارض الفنية والعروض الموسيقية."),

            FaqItem(9,"هل يوجد تأمين صحي للطلبة؟\n",
                "نعم، يقدم قسم الـتأمين في دائرة الخدمات الطلابية/عمادة شؤون الطلبة، خدمات التأمين الصحي. ويعد الاشتراك في التأمين الصحي إلزامياً لجميع طلبة البكالوريوس المسجلين" +
                        " في الجامعة، ما عدا طلبة الدراسات المسائيـة والتأهيل التربوي والدبلوم والدراسات العليا العاملين إذا اثبتوا أنهم مشمولون بالتامين الصحي لدى الجهات التي يعملون بها." +
                        "  وتشتمل المعالجة في عيادات ومراكز ومستشفيات وزارة الصحة، ومستشفيات الجامعات الأردنية " +
                        "والخدمات الطبية الملكية ومستشفيات القطاع الخاص المتعاقد معها وعيادات القطاع الخاص. للمزيد حول تعليمات التأمين الصحي لطلبة جامعة اليرموك رقم (10) لسنة 2009، اضغط هنا."),

            FaqItem(10,"هل يوجد مركز صحي تابع للجامعة؟",
                "تحتوي جامعة اليرموك على مركز صحي داخل الجامعة والذي يهدف إلى تقديم الخدمات الصحية المجانية لمجتمع الجامعة من الطلبة وأعضاء الهيئتين التدريسية والإدارية وعائلاتهم."),

            FaqItem(11,"هل يوجد جهة في جامعة اليرموك ترعى الطلبة ذوي الاحتياجات الخاصة؟",
                "نعم، يوجد في عمادة شؤون الطلبة قسم خاص لرعاية الطلبة ذوي الاحتياجات الخاصة، يقوم القسم بمساعدتهم في القبول" +
                        " والتسجيل ويقدم العديد من المساعدات والخدمات  والدعم الأكاديمي لهم. توفر الجامعة مختبراً للحاسوب للطلبة الذين يعانون من المشاكل (الإعاقة ) البصرية،" +
                        " يحتوي على أجهزة خاصة وطابعات بريل، ويشرف عليه متخصصون. كما توفر مترجمين من الإناث والذكور لترجمة لغة الإشارة لطلبتها وزوارها، ممن يعانون ضعف السمع."),

            FaqItem(12,"هل يوجد قسم لمتابعة الطلبة الدوليين في جامعة اليرموك؟",
                "نعم، يوجد قسم رعاية الطلبة الوافدين في عمادة شؤون الطلبة، يقدم العديد من الخدمات المجانية والنشاطات. للمزيد من المعلومات والاستفسارات يرجى التواصل مع:\n" +
                        "قسم رعاية الطلبة الوافدين\n" +
                        "سائد عصام العزام\n" +
                        "هاتف: 0096227211111 فرعي: 2444\n" +
                        "البريد الإلكتروني :Saed.alazzam@yu.edu.jo\n" +
                        "الموقع الإلكتروني : https://dsa.yu.edu.jo/index.php/en"),

            FaqItem(13,"هل يمكنني معرفة من هم الأساتذة والأكاديميين في تخصصي؟",
                "نعم، بإمكانك الدخول إلى قاعدة بيانات أعضاء هيئة التدريس لتتعرف على جميع الأساتذة والأكاديميين في الجامعة والتعرف على مؤهلاتهم الأكاديمية وسيرهم الذاتية."),

            FaqItem(14,"كيف لي أن اعرف الأنظمة والقوانين في الجامعة؟",
                "بإمكانك الاطلاع على كافة الأنظمة القوانين المتعلقة بالطلبة من خلال زيارة موقع دائرة الشؤون القانونية للجامعة،" +
                        " أيضا على أهم الأسس والقرارات التي تتعلق بالشؤون القانونية للطالب. " +
                        "كما يمكنك أن تقدم الاقتراحات أو الشكاوى المخصصة للطلبة في حال كان لديك أي استفسار أو واجهتك أية صعوبات خلال العملية التعليمية." +
                        " ويرجى قراءة دليل الطالب الذي يحوي معلومات مهمة جداً ستساعدك خلال دراستك في جامعة اليرموك."),

            FaqItem(15,"هل يوجد موقع للتعلم الإلكتروني في الجامعة؟",
                "نعم، عند قبولك في الجامعة التي يحق لك الدخول على موقع التعلم الإلكتروني المخصص لجميع المساقات التي سوف تدرسها " +
                        "في الجامعة للتواصل مع مدرسيك وزملائك. وبإمكانك الدخول إلى مركز التعلم الإلكتروني للمزيد من المعلومات والفيديوهات الإرشادية."),

            FaqItem(16,"ما هو موقع الجامعة الجغرافي الذي يمكنني تتبعه عبر ال GPS؟",
                "• يمكنك من خلال الموقع الجغرافي الوصول إلى موقع جامعة اليرموك عبر خاصية ال GPS.\n" +
                        "• يمكنك استخدام خرائط الجامعة الموجودة على الموقع الرئيسي للجامعة.\n" +
                        "• يمكنك التنقل بين وحدات الجامعة من خلال خارطة الجامعة الإلكترونية بالإضافة إلى خارطة الجامعة المخصصة للطلبة ذوي الاحتياجات الخاصة ."),

            FaqItem(17,"ما هو المطار الرئيس في الأردن؟",
                "المطار الرئيس في الأردن هو مطار عمان الملكة علياء الدولي، يقع جنوب العاصمة الأردنية عمان. ويبعد عن جامعة اليرموك ساعة ونصف بالسيارة،" +
                        " تتوفر فيه سيارات الأجرة وشركات تأجير سيارات حديثة وسيارات خصوصي لنقل المسافرين بمبلغ لا يتجاوز 50 ديناراً (70 دولاراً).  "),

            FaqItem(18,"هل أحتاج لتأشيرة لدخول الأردن؟",
                "نعم تحتاج، يطلب منك جواز سفر وتأشيرة، ويصدر الأردن تأشيرات لغير الأردنيين عند" +
                        " وصولهم إلى مطار الملكة علياء الدولي. تكلفة التأشيرة 40 ديناراً أردنيًّا (57 دولاراً)" +
                        " لدخول واحد مع صلاحية شهر واحد. وينصح الطلبة الدوليون أخذ  تأشيرة مسبقة من خلال القنصليات الأردنية في دولهم. "),

            FaqItem(19,"كيف أصل من مطار الملكة علياء إلى مدينة إربد؟",
                "هناك 3 طرق للوصول من مطار الملكة علياء الدولي إلى مدينة إربد:\n" +
                        "• بواسطة سيارات الأجرة (تاكسي المطار): متوفرة على مدخل المطار بتكلفة 50 ديناراً أردنياً (70 دولاراً).\n" +
                        "• المواصلات العامة (الحافلات): خذ حافلة من المطار إلى محطة حافلات طبربور (40 دقيقة)، " +
                        "بتكلفة 5 دنانير أردني (7 دولارات)، ثم حافلة أخرى (جت أو حجازي) من محطة حافلات طبربور إلى إربد (ساعة ونصف) بتكلفة 5 دنانير أردني (7 دولارات).\n" +
                        "• شركات تأجير السيارات: متوفرة داخل المطار، بسعر إيجار يومي يقدر 50 ديناراً (70 دولاراً)."),

            FaqItem(20,"أين يمكنني تحويل العملات النقدية؟",
                "بإمكانك تحويل وصرف العملات النقدية في المطار أو من خلال العديد من محلات الصرافة القريبة من جامعة اليرموك،" +
                        " والموزعة في جميع المناطق في مدينة إربد. كما يوجد بنك القاهرة عمان داخل حرم جامعة اليرموك، يمكنه تقديم هذه الخدمة."),
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