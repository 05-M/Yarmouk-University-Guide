// في ملف: app/src/main/java/com/mido/yarmoukguide/data/Repository.kt

package com.mido.yarmoukguide.data

import com.mido.yarmoukguide.R
import kotlinx.coroutines.flow.Flow

class Repository(
    private val facultyDao: FacultyDao,
    private val departmentDao: DepartmentDao,
    private val faqDao: FaqDao,
    private val lectureDao: LectureDao,
    private val newsDao: NewsDao,
    private val courseDao: CourseDao,
    private val professorDao: ProfessorDao
) {

    val allFaculties: Flow<List<Faculty>> = facultyDao.getAllFaculties()

    fun getFacultyById(id: Int): Flow<Faculty?> {
        return facultyDao.getFacultyById(id)
    }

    fun getDepartmentsForFaculty(facultyId: Int): Flow<List<Department>> {
        return departmentDao.getDepartmentsForFaculty(facultyId)
    }
    fun getDepartmentById(id: Int): Flow<Department?> {
        return departmentDao.getDepartmentById(id)
    }

    fun getCoursesForDepartment(departmentId: Int): Flow<List<Course>> {
        return courseDao.getCoursesForDepartment(departmentId)
    }

    fun getProfessorsForDepartment(departmentId: Int): Flow<List<Professor>> {
        return professorDao.getProfessorsForDepartment(departmentId)
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
            type = FacultyType.MEDICAL,
            imageResId = R.drawable.faculty_medicine,
            contactInfo = " اربد- الاردن, ص.ب 566 الرمز البريدي 21163\n" +
                    " medicine.fac@yu.edu.jo\n" +
                    " 962-2-7211111 (3037)\n" +
                    " 7211111 2 962 +",
            locationOnMap = "Building s2, second floor"))

        facultyDao.insert(Faculty(id = 2,
            name = "Pharmacy",
            description = "The Faculty of Pharmacy at Yarmouk University was established in the academic year 2014/2013." +
                " This was done to provide Jordan, the region," +
                " and the world with competent doctors who are responsible and contribute to healthcare and scientific research." +
                " The Faculty of Pharmacy is located within the campus of Yarmouk University," +
                " the second oldest university in Jordan, established in 1976.",
            type = FacultyType.MEDICAL,
            imageResId = R.drawable.faculty_pharmacy,
            contactInfo = "Phone : 027211111 (7200/7201)\n" +
                    "  Fax : 7065 / 7211165\n" +
                    "  E-mail : Pharmacy.fac@yu.edu.jo\n" +
                    "  Address :Yarmouk University, Irbid, Jordan",
            locationOnMap = "Building s2, second floor"))

        facultyDao.insert(Faculty(id = 3,
            name = "Nursing",
            description = "The Faculty of Narcing in Yarmouk University was established in 2022...",
            type = FacultyType.MEDICAL,
            imageResId = R.drawable.faculty_nursing,
            contactInfo = "العنوان : جامعة اليرموك , اربد, الأردن\n" +
                    " Narcing.fac@yu.edu.jo\n" +
                    " 027211111 (...)",
            locationOnMap = "Building s2, second floor"))

        //الكليات العلمية
        facultyDao.insert(Faculty(id = 4,
            name = "Science",
            description = "The College of Science was established in 1976," +
                " concurrently with the establishment of the university, and was part of the College of Science and Arts." +
                " They were separated into two colleges in 1981. The college currently includes six academic departments:" +
                " Mathematics, Physics, Chemistry, Statistics, Life Sciences, and Earth and Environmental Sciences.",
            type = FacultyType.SCIENTIFIC,
            imageResId = R.drawable.faculty_science,
            contactInfo = "Phone : 027211111 (2411 / 2412)\n" +
                    "\n" +
                    "Fax : 0096227211117\n" +
                    "\n" +
                    "E-mail : Science.fac@yu.edu.jo\n" +
                    "\n" +
                    "Address :Yarmouk University, Irbid, Jordan",
            locationOnMap = "Building s2, second floor"))

        facultyDao.insert(Faculty(id = 5,
            name = "Hijjawi Faculty for Engineering Technology",
            description = "Hijjawi Faculty for Engineering Technology was established in 1984 through the generous " +
                    "support of the Scientific Foundation of Hisham Adeeb Hijjawi.",
            type = FacultyType.SCIENTIFIC,
            imageResId = R.drawable.faculty_engineer,
            contactInfo = "Hijjawi Faculty for Engineering Technology, Yarmouk University, Irbid 21163, Jordan\n" +
                    "\n" +
                    " engineering.fac@yu.edu.jo\n" +
                    "\n" +
                    " +962 2 721 1111 (4251)",
            locationOnMap = "Building s2, second floor"))

        facultyDao.insert(Faculty(id = 6,
            name = "Faculty of information technology and computer science",
            description = "The Department of Information Technology was established at the beginning of " +
                    "the Faculty of Information Technology and Computer Science at Yarmouk University" +
                    " at the start of the academic year 2002/2003. The department offers a bachelor's" +
                    " degree in Business Information Technology and a specialization in Cybersecurity.",
            type = FacultyType.SCIENTIFIC,
            imageResId = R.drawable.faculty_it,
            contactInfo = "جامعة اليرموك , اربد, الأردن\n" +
                    " it.fac@yu.edu.jo\n" +
                    " 027211111 (2632)\n" +
                    " 0096227211128",
            locationOnMap = "Building s2, second floor"))

        //الكليات الإنسانية
        facultyDao.insert(Faculty(id = 7,
            name = "Law",
            description = "The Law Faculty, as an independent entity, commenced its function in September 1999." +
                    "It succeeded the Law Department, which was established " +
                    "in 1991 as part of the Faculty of Economics & Administrative Sciences.",
            type = FacultyType.HUMANITARIAN,
            imageResId = R.drawable.faculty_law,
            contactInfo = "اربد- الاردن, ص.ب 566 الرمز البريدي 21163\n" +
                    " law.fac@yu.edu.jo\n" +
                    " هاتف : 027211111 (4201)\n" +
                    " فاكس : 0096227211193",
            locationOnMap = "Building s2, second floor"))

        facultyDao.insert(Faculty(id = 8
            , name = "Arts",
            description = "When the University was established in 1976, " +
                    "the then Faculty of Arts and Science included specializations" +
                    " in science, arts, economics, and administrative sciences. The departments of Arabic, English," +
                    " Humanities and Social Sciences were the core of the Faculty of Arts," +
                    " which was established in 1981.",
            type = FacultyType.HUMANITARIAN,
            imageResId = R.drawable.faculty_arts,
            contactInfo = "اربد- الاردن, ص.ب 566 الرمز البريدي 21163\n" +
                    " Art.fac@yu.edu.jo\n" +
                    " 027211111 (2900)",
            locationOnMap = "Building s2, second floor"))

        facultyDao.insert(Faculty(id = 9,
            name = "Business",
            description = "In 1981 Yarmouk University established a unique college under the title of" +
                    " “Faculty of Economics and Administrative Sciences”, with the objective of meeting stakeholders " +
                    "needs and contributing to the national business, organizational and management arena.",
            type = FacultyType.HUMANITARIAN,
            imageResId = R.drawable.faculty_business,
            contactInfo = " العنوان : جامعة اليرموك , اربد, الأردن\n" +
                    " economics.fac@yu.edu.jo\n" +
                    "  027211111 (6800)\n" +
                    "  0096227211147",
            locationOnMap = "Building s2, second floor"))

        facultyDao.insert(Faculty(id = 10,
            name = "Al-Shari'a",
            description = "The Faculty of Al-shari'The Faculty of Sharia and Islamic Studies at Yarmouk University" +
                    "was established in 1990 to achieve the goals of higher education in the Hashemite Kingdom of Jordan." +
                    " It is a pioneering college that carries a significant burden of the concerns of this" +
                    " nation and strives hard to achieve the monumental objectives assigned to it," +
                    " whether related to education and caring for the student, who represents the core of the educational" +
                    " process, as he is the highest goal of this college, and being the most important element" +
                    " that supplies the local community with the capabilities and energies capable of meeting the needs of the present and the future",
            type = FacultyType.HUMANITARIAN,
            imageResId = R.drawable.faculty_sharia,
            contactInfo = " هاتف : 027211111 (5413)\n" +
                    "  فاكس : 7211196 (4196)\n" +
                    "  البريد الالكنروني : sharia.fac@yu.edu.jo\n" +
                    "  العنوان : جامعة اليرموك , اربد, الأردن",
            locationOnMap = "Building s2, second floor"))

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
            type = FacultyType.HUMANITARIAN,
            imageResId = R.drawable.faculty_educational_science,
            contactInfo = "البريد الإلكتروني: education.fac@yu.edu.jo\n" +
                    "هاتف: 0096227211147\n" +
                    "فاكس:3729 أو 3728",
            locationOnMap = "Building s2, second floor"))

        facultyDao.insert(Faculty(id = 12,
            name = "Physical Education & Sport Sciences",
            description = "The Faculty of Physical Education was established in 1993. Prior to this it was a department at the Faculty of Arts." +
                    "The department was incorporated in 1988 with the Faculty of Education and Fine Arts.",
            type = FacultyType.HUMANITARIAN,
            imageResId = R.drawable.faculty_sport,
            contactInfo = " العنوان : جامعة اليرموك , اربد, الأردن\n" +
                    " Physicaledu.fac@yu.edu.jo\n" +
                    " 027211111 (2591)",
            locationOnMap = "Building s2, second floor"))

        facultyDao.insert(Faculty(id = 13,
            name = "Fine Arts",
            description = "The Department of Fine Arts was founded at the beginning of the academic year 80/81 in the sections of the Faculty of Arts" +
                    " and remained in the Departments of Education and Arts, which was established in the academic year 88/89." +
                    " In 2000 year, the department became a College of Fine Arts .",
            type = FacultyType.HUMANITARIAN,
            imageResId = R.drawable.faculty_fine_arts,
            contactInfo = "Phone : 027211111(2581)\n" +
                    "Fax : 027211112\n" +
                    "E-mail : Finarts.fac@yu.edu.jo\n" +
                    "Address :Yarmouk University, Irbid, Jordan",
            locationOnMap = "Building s2, second floor"))

        facultyDao.insert(Faculty(id = 14,
            name = "Archaeology And Anthropology",
            description = "The Faculty of Archaeology and Anthropology at Yarmouk University was established in 1984, as the Institute of Archaeology and Anthropology," +
                    "aiming at conducting interdisciplinary researches and promoting public awareness of cultural heritage of Jordan and the Arab World.",
            type = FacultyType.HUMANITARIAN,
            imageResId = R.drawable.faculty_archaeology,
            contactInfo = "Phone : 027211111 (2271)\n" +
                    "Fax : 0096227211155\n" +
                    "E-mail : archaeology.fac@yu.edu.jo\n" +
                    "Address :Yarmouk University, Irbid, Jordan",
            locationOnMap = "Building s2, second floor"))

        facultyDao.insert(Faculty(id = 15,
            name = "Tourism and Hotels",
            description = "The College of Tourism and Hotel Management was established at Yarmouk University in the academic year 2011-2012 as part of the " +
                    "university's direction to provide qualified and specialized human resources that contribute to driving " +
                    "local economic and social development, and to contribute to improving the quality of tourism services" +
                    " locally and regionally by providing qualified and trained human resources in the tourism sector.",
            type = FacultyType.HUMANITARIAN,
            imageResId = R.drawable.faculty_tourism,
            contactInfo = "A Yarmouk university, Irbid - Jordan\n" +
                    "Etourism.fac@yu.edu.jo\n" +
                    "P027211111  (2863 / 2862)\n" +
                    "F0096227211153 / 3953",
            locationOnMap = "Building s2, second floor"))

        facultyDao.insert(Faculty(id = 16,
            name = "Mass Communication",
            description = "The Faculty of Mass Communication is one of the colleges of Yarmouk University in Jordan." +
                    " It was established in 1976 and is the first media college in Jordan.",
            type = FacultyType.HUMANITARIAN,
            imageResId = R.drawable.faculty_mass,
            contactInfo = "Phone : 027211111 (6900)\n" +
                    "\n" +
                    "Fax : 0096227211148\n" +
                    "\n" +
                    "E-mail : mass.fac@yu.edu.jo\n" +
                    "\n" +
                    "Address :Yarmouk University, Irbid, Jordan",
            locationOnMap = "Building s2, second floor"))

        //--------------------------------------------------------------------------------------------------------

        //أقسام الكليات
        // أقسام كلية الطب (اللي الـ ID بتاعها 1)
        departmentDao.insert(Department(
            name = "Department of Basic Medical Sciences",
            facultyOwnerId = 1,
            description = "Welcome to the Department of Basic Medical Sciences (BMS), which was established in 2016. BMS is one of the academic departments of Faculty of Medicine in Yarmouk Uuniversity. It deals with medical students in their first three years (Pre-clinical years), to build their basic knowledge resposible to understand the clinical cases , how the healthy body works from the genetic level through the cell , tissues, organs and systems, so they will be able to understand first the normal body structures and activities then secondly how any defect in them will cause diseases.\n" +
                    "The subjects in the scope of BMS department are: Anatomy, Physiology, Biochemistry, Genetics, Histology and Pharmacology.Department of Basic Medical Sciences serves medical students by educating them some of the important basic subjects that build their knowledge to prepare them for the clinical education in the second half of their medical education journey. The specialties under the umbrella of this department are: Anatomy, Physiology, Biochemistry, Genetics, Histology and Pharmacology. The staff in the department include skilled and distinguished teachers who are certified by prestigious international universities. Other than teaching they are active in research work, self and institutional development, supervise students' non academic activities , in addition to networking with national and international universities in academic and research fields.\n" +
                    " \n" +
                    "The main aim of our department is to enrich the knowledge of our students by basic medical sciences by theoretical lectures and applied practical training in the laboratories. This integrated approach is done by integrated body systems courses, where all specialties cooperate together to body systems one by one and let the student understand the relation among all specialties to comprehend the system function.\n" +
                    " \n" +
                    "The system courses given in the department are: Respiratory system, Cardiovascular system, Lymphatic system, Endocrine system,  Musculo-skeletal system Central and Peripheral nervous system and Urogenital system.\n" +
                    " \n" +
                    "The department includes well equipped teaching halls with audio-video new systems and teaching and research labs with many modern teaching facilities and equipment like for example the  virtual dissection table (Anatomage) and other body simulation objects, in an effort to provide the best basic medical knowledge for our students in the first three years of their medical studies.\n" +
                    " \n" +
                    "The Laboratories of  the department are:\n" +
                    "- Anatomy Lab\n" +
                    "- Physiology Lab\n" +
                    "- Biochemistry Lab",
            headOfDepartment = "Prof. Osama Yousef Abu Al-rub",
            locationInFaculty = "",
            contactEmail = "Email:medicine.fac@yu.edu.jo\n" +
                    "Osama.Yousef@yu.edu.jo",
            contactPhone = "phone no.  7211111-2-00962     Ext.: 7242"
        ))
        departmentDao.insert(Department(
            name = "Department of Basic Pathological Sciences (BPS)",
            facultyOwnerId = 1,
            description = "Welcome to the Department of Basic Pathological Sciences (BPS), which was established in 2024. BPS is one of the academic departments of the Faculty of Medicine in Yarmouk University that deals with specialties that prepare the medical students to understand the pathologies that affect the human body and the primary measures to deal with them in the community, reaching the highest level of public health.\n" +
                    "The subjects in the scope of BPS department are: Pathology, Medical Microbiology, Immunology, Community Medicine and Public Health.The Department of Basic Pathological Sciences at the Faculty of Medicine was established in 2024 . It emerged from the former Basic Medical Sciences. The Department of Basic Pathological Sciences is one of the basic pillars for teaching the pre-clinical sciences to medical students which include:\n" +
                    "\n" +
                    "Pathology, Immunology, Medical microbiology, Public health, Bio-statistics and Public health &Community medicine.\n" +
                    "\n" +
                    " The department recruits a group of faculty members who finished their higher degrees from a number of the best international universities.  Faculty staff are distinguished in providing medical education, scientific research and community services. \n" +
                    "\n" +
                    "  The study in the courses is offered by the department through theoretical lectures and practical laboratories. Beginning from the second year, the teaching plan of the integrated body systems includes the following:\n" +
                    "\n" +
                    "Respiratory, cardiovascular, lymphatic, gastrointestinal, endocrine, musculoskeletal, central and peripheral nervous system and urogenital system. \n" +
                    "\n" +
                    "Classrooms are equipped with the latest audio and video equipment. In addition to that,  the faculty runs the laboratories with the modern laboratory equipment to achieve the goal of obtaining a high quality medical education. The department's teaching mission is complemented by other basic medical sciences in order to provide medical students in the first three years with a strong background that serves as the beginning of clinical practice. \n" +
                    "\n" +
                    "Many teaching and research laboratories are in service in our department:\n" +
                    "\n" +
                    "Microbiology lab\n" +
                    "Anatomy&Histopathology lab",
            headOfDepartment = "Dr. Maryam Al-Omari",
            locationInFaculty = "",
            contactEmail = "Email:medicine.fac@yu.edu.jon\n" +
                    "Maryam.o@yu.edu.jo",
            contactPhone = "phone no.  00962-2-7211111   Ext.: 7113"
        ))
        departmentDao.insert(Department(
            name = "Department of Internal medicine",
            facultyOwnerId = 1,
            description = "Welcome to the Department of Internal Medicine, a leading department of the Faculty of Medicine. We are committed to achieving excellence in education and patient care; our department is dedicated to teaching medical students and equipping them to diagnose and treat diseases of internal medicine, dermatology, and psychological disorders.  We provide our students with the clinical and scientific knowledge necessary for a fulfilling career in healthcare through rigorous academic programs and practical clinical experiences. Our objective is to enable medical professionals to provide outstanding patient care.\n" +
                    "The Department of Internal Medicine of the Faculty of Medicine at Yarmouk University was established in 2024 and emerged as the former Clinical Medical Sciences department.\n",
            headOfDepartment = "Dr. Mohammad Athamneh",
            locationInFaculty = "",
            contactEmail = "Email:medicine.fac@yu.edu.jo" +
                    "m.athamneh@yu.edu.jo",
            contactPhone = "Phone no.: 00962-2-7211111     Ext.: 3037"
        ))
        departmentDao.insert(Department(
            name = "Department of General Surgery and Anesthesia",
            facultyOwnerId = 1,
            description = "Welcome to the Department of Surgery and Anesthesia at the Faculty of Medicine, which is one of the main departments that contributes to" +
                    " honing the clinical and academic skills of medical students. It combines intensive theoretical education with advanced practical training," +
                    " providing students with a comprehensive opportunity to develop their knowledge and skills in a wide range of surgical and anesthesiology specialties, ensuring their preparation for a successful professional future in various fields of medicine.",
            headOfDepartment = "Dr. Raed Ennab",
            locationInFaculty = "",
            contactEmail = " medicine.fac@yu.edu.jo" +
                    "raed.ennab@yu.edu.jo",
            contactPhone = "Phone no.: 00962-2-7211111     Ext.: 3037"
        ))
        departmentDao.insert(Department(
            name = "Department of Pediatrics, Family Medicine and Obstetrics & Gynecology",
            facultyOwnerId = 1,
            description = "We welcome you to the introductory page of the Department of Pediatrics, Family Medicine, and Obstetrics and Gynecology at the Faculty of Medicine. " +
                    "This department plays a crucial role in building the medical and scientific skills of medical students in clinical stages by integrating comprehensive theoretical " +
                    "education with advanced practical training. The department provides students with the opportunity to deepen their knowledge and develop their skills in family and pediatric care as well as women's health, ensuring their preparedness for a successful professional future.",
            headOfDepartment = "Dr. Dina Hisham Qa'adan",
            locationInFaculty = "",
            contactEmail = " medicine.fac@yu.edu.jo" +
                    "dina.qaadan@yu.edu.jo",
            contactPhone = "Phone no.: 00962-2-7211111     Ext.: 3037"
        ))

        // أقسام كلية الصيدلة (اللي الـ ID بتاعها 2)
        departmentDao.insert(Department(
            name = "Pharmaceutics and Pharmaceutical Technology",
            facultyOwnerId = 2,
            description = "Welcome to the Department of the Pharmaceutics and Pharmaceutical Technology.This department comprises a group of faculty members from a wide range of scientific disciplines that are critical to the discovery and development of new drugs and treatments. " +
                    "The department teaches physical pharmacy, pharmaceutical compounding, pharmaceutical technology and industrial pharmacy. We also provide laboratory training and practical guidance to students through practical laboratory courses.\n" +
                    "\n" +
                    "The department also offers a number of elective courses that increase the knowledge of the students in focused are of pharmaceutical sciences.  The department also offers supplemental courses deal with biostatistics, pharmaceutical microbiology, immunology and serology, and pharmaceutical biotechnology.",
            headOfDepartment = "Dr. Ali Hmedat",
            locationInFaculty = "",
            contactEmail = "Email: Pharmacy.fac@yu.edu.jo",
            contactPhone = "Phone: 027211111 (2760)\n" +
                    "Fax: 3965 / 7211165"
        ))
        departmentDao.insert(Department(
            name = "Clinical Pharmacy and Pharmacy Practice",
            facultyOwnerId = 2,
            description = "Welcome to the Pharmacy Practice department. This department aims to promote the knowledge of pharmacy students in three main categories: Basic medical sciences, pharmacology and pharmacoeconomics.\n" +
                    "\n" +
                    "The department emphasizes the significance of developing the scientific, \u200Eprofessional and social aspects of pharmacy students, in order to qualify them to take an \u200Eactive role in the pharmaceutical care in hospital and community \u200Epharmacy setting.\u200E\n" +
                    "\n" +
                    "The department offers a number of obligatory and elective courses which include physiology, pathophysiology, pharmacology, therapeutics, principles of business of pharmacy and quality assurance, pharmacoeconomics, health policy and management, pharmaceutical care, toxicology ,over the counter medication, " +
                    "international pharmaceutical regulatory affairs, accounting and financial management in pharmacy and pharmaceutical promotion.",
            headOfDepartment = "Dr. Mariam ALameri",
            locationInFaculty = "",
            contactEmail = "Email: Pharmacy.fac@yu.edu.jo",
            contactPhone = "Phone: 027211111 (2760)\n" +
                    "Fax: 3965 / 7211165"
        ))
        departmentDao.insert(Department(
            name = "Medicinal Chemistry and Pharmacognosy",
            facultyOwnerId = 2,
            description = "The Department of Medicinal Chemistry and Pharmacognosy offers pharmacy students the foundational concepts of drug mechanisms of action, structure-activity relationships, acid-base/physicochemical properties, and absorption, distribution, metabolism, excretion, and toxicity profiles.\n" +
                    "\n" +
                    "Medicinal Chemistry is a discipline focused on organic synthetic chemistry with broad goals on drug discovery and optimization. Pharmacognosy emphasizes on drug discovery from natural products, their occurrence in nature, extraction and identification. In addition, Phytotherapy course is intended to introduce pharmacy students to the concept of medical herbalism and complementary & alternative medicine.\n" +
                    "\n" +
                    "The practical division provides the students with a solid foundation in the synthesis, characterization, extraction of drugs as well as natural products. The department enclosed five laboratories including Analytical Pharmaceutical Chemistry, Organic Pharmaceutical Chemistry, Pharmacognosy and Phytochemistry, Medicinal Chemistry, and Instrumental Analysis.\n" +
                    "\n" +
                    "Regarding the scientific research, the Department of Medicinal Chemistry and Pharmacognosy pursues interdisciplinary research such as design and chemical synthesis of drugs, drug analysis, natural products chemistry, biochemistry and drug targets, and computer-aided drug design and molecular modeling.",
            headOfDepartment = "Dr. Yazan Akkam",
            locationInFaculty = "",
            contactEmail = "Email: Pharmacy.fac@yu.edu.jo",
            contactPhone = "Phone: 027211111 (2760)\n" +
                    "Fax: 3965 / 7211165"
        ))

//        // أقسام كلية التمريض (اللي الـ ID بتاعها 3)
        departmentDao.insert(Department(
            name = "Basic Nursing",
            facultyOwnerId = 3,
            description = " The Department of Basic Nursing was established in line with the vision and mission of the Faculty of Nursing at Yarmouk University to graduate distinguished nurses with high and distinguished competencies to support the local and international labor markets.The Department of Basic Nursing looks forward to establishing the students of the College of Nursing and providing them with solid scientific knowledge and basic clinical skills in preparation for their transition to the stage of nursing practice in the specialized fields of nursing, and the department includes a group of faculty members who hold scientific certificates from the most prestigious international institutes and universities and are distinguished in nursing education, scientific research and community service.\n" +
                    "\n" +
                    "The department includes many theoretical and practical courses that aim to refine knowledge and develop nursing skills in the foundation stage in the first and second year of study, including these courses:\n" +
                    "\n" +
                    "Introduction to the Nursing Profession\n" +
                    "Fundamentals of Nursing – Theoretical\n" +
                    "Fundamentals of Nursing – Practical\n" +
                    "Clinical-Theoretical Evaluation\n" +
                    "Clinical-Practical Evaluation\n" +
                    "Adult Health Nursing 1 Theory\n" +
                    "Adult Health Nursing 1 Practical\n" +
                    "Adult Health Nursing 2 Theory\n" +
                    "Adult Health Nursing 2 Practical\n" +
                    "Critical Nursing Theoretical\n" +
                    "Critical Care Nursing Practical\n" +
                    "Clinical Nutrition\n" +
                    "Intensive Clinical Training\n" +
                    "The department adopts nursing students in the first and second academic years by teaching them the basic courses in the specialization, including theoretical training that focuses on increasing knowledge in addition to practical training in laboratories and hospitals, and the department is equipped with teaching halls equipped with the latest audio and video equipment to achieve high-quality nursing education, the role of the department comes mainly to equip students for the third and fourth years to delve into specialized nursing knowledge such as maternal and child health, community health, and mental health nursing to follow the Department of Clinical Nursing.\n" +
                    "\n" +
                    "The department contains the following teaching laboratories:\n" +
                    "\n" +
                    "Nursing Essentials\n" +
                    "Health Assessment\n" +
                    "Adult Health\n" +
                    "Intensive Care",
            headOfDepartment = "Dr. Anas Ababneh",
            locationInFaculty = "",
            contactEmail = "E-mail : Narcing.fac@yu.edu.jo",
            contactPhone = " Phone : 027211111 (...) Fax : 0096227211152"
        ))
        departmentDao.insert(Department(
            name = "Clinical Nursing",
            facultyOwnerId = 3,
            description = "The Department of Clinical Nursing is one of the two nursing departments at Yarmouk University, which works in harmony to achieve the college's vision of achieving leadership and excellence in nursing education and preparing nurses who are able to meet the needs of the local, regional, and international labor market.\n" +
                    "The Department of Clinical Nursing at Yarmouk University was established in 2024 by a decision of the Board of Deans at the university, where the Department of Clinical Nursing is responsible for teaching theoretical and clinical subjects during the third and fourth academic years of the Bachelor of Nursing program, including: Communication, Communication and Health Education, Maternal Health Nursing / Theoretical, Maternal Health Nursing / Practical, Child Health Nursing / Theoretical, Child Health Nursing / Practical, Clinical Nutrition, Mental Health Nursing / Theoretical, Mental Health Nursing / Practical, Community Health Nursing / Theoretical, Community Health Nursing / Theoretical / Practical, Occupational Health and Safety, Nursing Profession Laws and Ethics, Scientific Research Methods, Critical/Theoretical Nursing, Critical/Practical, Management in Nursing, and Intensive Clinical Training.\n" +
                    "The Department of Clinical Nursing includes a group of faculty members with different nursing specialties and from various scientific and academic ranks.\n",
            headOfDepartment = "Dr. Haitham Khattaba",
            locationInFaculty = "",
            contactEmail = "E-mail : Narcing.fac@yu.edu.jo",
            contactPhone = " Phone : 027211111 (...) Fax : 0096227211152"
        ))

        // أقسام كلية العلوم (اللي الـ ID بتاعها 4)
        departmentDao.insert(Department(
            name = "Physics",
            facultyOwnerId = 4,
            description = "The department of physics was established in 1976 with a B.Sc. program. At that time the department had three faculty members and forty students. The M.Sc. graduate program was established at the start of the academic year 1982/1983 and three students were admitted.\n" +
                    "\n" +
                    "Since the department has witnessed an enormous growth, now there are 28 faculty members (24 holding PhD and 4 holding M.Sc. degree), 6 teaching assistants holding M.Sc. degree, and 11 technicians. Today the department has around 343 undergraduate students and 80 graduate students. The number of the graduated students since the inception of the department is about 2647 students with a B.Sc. and around 268 students with M.Sc. degree.\n" +
                    " \n" +
                    "In addition to the effort made to raise the level of teaching and to supply the community at large with qualified personnel the department has established a number of specialized research laboratories in the following fields of physics Mössbauer Spectroscopy, Thin Films, X- ray Fluorescence Spectroscopy, Nuclear Techniques, (Gamma Ray Spectroscopy and Alpha Ray Spectroscopy), Environment Studies, Nano Biomedical, and Computational physics lab.\n" +
                    "The aim of the above laboratories is to train the graduate student in fundamental scientific research promote and enrich scientific knowledge and contribute to the transfer of technology to the local community. Moreover the department contain well-equipped mechanical workshop in addition to many modern and well- equipped teaching laboratories.",
            headOfDepartment = "Dr. QASSEM IBRAHIM MOHAIDAT",
            locationInFaculty = "",
            contactEmail = "E-mail: Science.fac@yu.edu.jo" +
                    "Email: q.muhaidat@yu.edu.jo " +
                    "Email: Physics.dept@yu.edu.jo ",
            contactPhone = "Phone : 027211111 (2411 / 2412)\n" +
                    "\n" +
                    "Fax : 0096227211117"
        ))
        departmentDao.insert(Department(
            name = "Chemistry",
            facultyOwnerId = 4,
            description = "The Chemistry Department was established in 1976, and the Master’s program was introduced in 1980. By the close of the Summer Semester 2014/2015, the number of Bachelor’s students within the Department had reached 437, with an additional 36 graduate students, 10 of whom were in the stage of preparing their Master’s thesis.\n" +
                    "\n" +
                    "Of the 24 members of the teaching staff within the Department, 17 are Full Professors. The Department also employs 6 lecturers and a teaching assistant who each hold a Master’s degree, in addition to 10 technicians, one secretary and a building attendant.\n" +
                    "\n" +
                    " Within the Department, there are 24 teaching and research laboratories geared to each of the traditional Chemistry fields (Organic, Non-organic, Physical and Analytical). The Department also possesses advanced equipment in the field of Organic Chemistry, such as a magnetic resonance machine (NMR 400 MHz), a mass spectrometer, and other equipment used in the field of photochemistry and lasers.\n" +
                    "\n" +
                    "The work area contained within the Chemistry Department building covers 4000 square meters, including the 9 teaching laboratories, 15 research laboratories, 4 lecture halls, and offices for the teaching staff and assistant staff. The building is considered comprehensive as, from its conception and design, it complies with all public safety and environmental regulations, as well as meeting all the day-to-day requirements of the Department. Here it is worth mentioning that the building houses several general equipment rooms and a glass-blowing workshop, as well as a large amount of advanced equipment. The glass-blowing workshop produces all of the glass instruments needed within the Department and by the University as a whole.\n" +
                    "\n" +
                    "The majority of the researchers in the Department have received support for their scientific projects in various disciplines of Chemistry from the Ministry of Scientific Research and Higher Education, as well as from scientific institutions such as the Scientific Research Support Fund, the Abdel-Hameed Shuman Foundation, the Higher Council for Science and Technology, the Ministry of Higher Education, the European Economic Community, the German Overseas Academic Support Service (DAAD) the German Humboldt Institute, and Carlton University in Canada.",
            headOfDepartment = "Dr. IBRAHIM ABDELRAHIM MHAIDAT",
            locationInFaculty = "",
            contactEmail = "E-mail : Science.fac@yu.edu.jo",
            contactPhone = "Phone : 027211111 (2411 / 2412)\n" +
                    "\n" +
                    "Fax : 0096227211117"
        ))
        departmentDao.insert(Department(
            name = "Mathematics",
            facultyOwnerId = 4,
            description = " The Department of Mathematics was established in the academic year 1976, and offers a B.Sc. degree program in mathematics as a single specialization or as a major/minor specialization. The program requires a basic knowledge in mathematics with emphasis on concepts and applications. A master program was initiated in the academic year 1981/1982.\n" +
                    "\n" +
                    " Currently, there are 30 Faculty members, 3 Full time lectural and 1 Teaching assistant.\n" +
                    "\n" +
                    " In addition the Department of Mathematics offers mathematics courses to the students of the Faculty of Science, Hajjawi Faculty and Faculty of Information Technology.\n" +
                    "\n" +
                    "The Department of Mathematics is a pivotal department as it prepares and equips national and Arab personnel with specialists and educators in mathematics.\n" +
                    "\n" +
                    "Faculty members of this department are committed to providing quality teaching and counselling services to its students. The department also maintains continuous contact with its students through its various counselling programs and through utilizing office hours for each faculty member. Offices of the faculty members of this department are constantly open to students for communication and consultations. This communication is the department's aim and aspiration, and it continues even after students' graduation.\n" +
                    "\n" +
                    "It’s worth saying with a high level of confidence and pride that all graduates of this department are able to find appropriate jobs immediately. Therefore, they provide their services to society soon after graduation. Some of our students pursue higher education towards PhD degrees. They proved to be good graduate students and they demonstrate remarkable scientific excellence.  Many of them are working at the department now.",
            headOfDepartment = "Prof. WATHIQ AHMED BANI DOMI",
            locationInFaculty = "",
            contactEmail = "E-mail : Science.fac@yu.edu.jo" +
                    "watheq@yu.edu.jo " +
                    "Mathematics.dept@yu.edu.jo",
            contactPhone = "Phone : 027211111 (2411 / 2412)\n" +
                    "\n" +
                    "Fax : 0096227211117"
        ))
        departmentDao.insert(Department(
            name = "Statistics",
            facultyOwnerId = 4,
            description = "The department of Statistics at Yarmouk University is the only statistics department nationwide. The department is a small cohesive unit that enjoys an energetic environment with a rich history of teaching, contributions in research, and consultations. The vision of the department is to produce quality graduates who are employable and capable of using statistics in many fields, and also are able to do research for the development of its own discipline as well as in other disciplines. The department’s graduates are in demand in the job market and have attained levels of recognition at many universities, research institutions, and corporations.\n" +
                    "\n" +
                    "The roots of the Department of statistics lie in the Department of Mathematics at Yarmouk University. 1977/1978 marks the establishment of the department of statistics and it started to offer service courses to students from departments of Mathematics, Economics and Administrative Sciences. In 1978/1979, department of statistics started the minor program in Statistics.\n" +
                    "\n" +
                    "As the department developed and expanded academically and resource wise, in 1980/1981 department of statistics split and it started a program offering a bachelor’s degree in Statistics major. In 1982/1983, a Master’s degree program was initiated with an emphasis on Applied Statistics, Mathematical Statistics, and Probability Theory. The department of Statistics also offers some statistical courses for other departments at Bachelor’s and Master Levels.\n" +
                    "\n" +
                    "The department maintains a permanent concern to include all new developments in both applied and theoretical statistical sciences. The department revised its study plans on two stages; the first milestone occurred in 1997/1998. While the second milestone occurred in 2007/2008 more emphasis was placed on statistical software packages besides developing the applied and theoretical aspects of the curriculum.\n" +
                    "\n" +
                    "The department has two modern, well equipped, computer labs with nearly 50 computers. The department pays attention to involving famous statistical packages as SPSS, R, MINITAB and SAS in various courses.\n" +
                    "\n" +
                    "The Department of Statistics in enriched with a well educated and experienced faculty members including (13) Ph.D. professors and (4) M.Sc. lecturers.\n" +
                    "\n" +
                    "Since the inception of the department, nearly (1500) students have graduated with Bachelor’s and Master’s degrees in Statistics. For this academic year (2017/2018), there are 200 undergraduate and 31 graduate students involved in the programs.",
            headOfDepartment = "Dr. AYMAN SULEIMAN BAKLEEZI",
            locationInFaculty = "",
            contactEmail = "E-mail : Science.fac@yu.edu.jo" +
                    "baklizi@yu.edu.jo",
            contactPhone = "Phone : 027211111 (2411 / 2412)\n" +
                    "\n" +
                    "Fax : 0096227211117"
        ))
        departmentDao.insert(Department(
            name = "Scientific Service Courses Department",
            facultyOwnerId = 4,
            description = "The Department of Scientific Service Courses was established in 2017, due to the need to provide an academic and administrative umbrella to offer a range of scientific service courses, known as the requirements of the University elective. The College of science embraces this department and does not grant any degree in any of the academic disciplines. However, the department teaches a number of elective courses, in line with the study plans for the various academic disciplines of the undergraduate level at Yarmouk University, in accordance with the standards of academic accreditation of universities in Jordan.",
            headOfDepartment = "Dr. TAREQ MOUSA ALI AL SHBOUL",
            locationInFaculty = "",
            contactEmail = "E-mail : Science.fac@yu.edu.jo",
            contactPhone = "Phone : 027211111 (2411 / 2412)\n" +
                    "talshboul@yu.edu.jo" +
                    "\n" +
                    "Fax : 0096227211117"
        ))
        departmentDao.insert(Department(
            name = "Earth and Environmental Science",
            facultyOwnerId = 4,
            description = "The department of Earth and Environmental Sciences was founded in 1981 in response to the growing demands for professional geologists and increasing environmental concern. Ever since, the department was committed to providing unique programs and high-quality education and research opportunities in geo- and environmental sciences, with our graduates becoming leaders in both academia and industry.\n" +
                    "\n" +
                    "The department facilitates interdisciplinary research and teaching in geosciences, GIS, environmental physics, environmental chemistry, geoarcheology. In addition to offering a bachelor degree in geology, the department also provides an opportunity for students majoring in other fields to combine their expertise with geology and environmental sciences, through two minor programs (in geology and in environmental sciences). Also, the department is currently running two graduate programs (M.Sc.), one in Geology and another in Environmental sciences. The department is keen to link theoretical knowledge with practical aspects by offering summer geology field course and applied research work.\n" +
                    "\n" +
                    "The department has a number of graduate and undergraduate courses designed not only for geology students but also for students from other faculties including: faculty of tourism (ecotourism: ENV 642), faculty of archeology and anthropology (GEO 107, ENV 103), faculty of arts (geography students: GEO107, GEO301, GEO 302, GEO348). In addition, the department offers elective course in environmental sciences 2 (ENV 101B; for students of the faculty of science) and environmental sciences 1 (ENV 101A) for all university students. In its future plan and in response to the growing environmental awareness, the department is planning to address the university administration to offer a compulsory course for university students from all majors in the field of global environmental issues and awareness.\n" +
                    "\n" +
                    "There are currently 23 faculty members (6 professors, 5 associate professors, 3 assistant professors, 2 visiting professors, 3 lecturers, 4 teaching assistants),  and 6 technicians. The number of students enrolled in the undergraduate program (bachelor's degree of Geology) is 402, 130 in the minor degree (Environmental Sciences 114 and Earth Sciences 16), and 18 are enrolled in the master's degree programs as well. The department’s faculty members, who graduated from well-renowned universities worldwide, have produced a large number of publications in peer-reviewed and international journals. In addition to offering advanced and interdisciplinary research opportunities, the department offers consultancies and services in related fields and has set a foundation for bi-and multilateral cooperation with other universities and organizations on the national and international levels.\n" +
                    "\n" +
                    "The department is equipped with laboratories and resources in the areas of teaching and research, enabling our students to conduct advanced research in a wide range of topics including: Sedimentary, Petroleum, Earth Surface Processes, Hydrogeology, Geophysics, Geochemistry, Paleoclimate, Structural Geology, Engineering Geology, Environmental Monitoring and Quality Assessment and Water Resources Management.",
            headOfDepartment = "Dr. MOHAMMAD AHMAD ALQUDAH",
            locationInFaculty = "",
            contactEmail = "E-mail : Science.fac@yu.edu.jo" +
                    "mohammad.alqudah@yu.edu.jo" +
                    "earth.dept@yu.edu.jo",
            contactPhone = "Phone : 027211111 (2411 / 2412)\n" +
                    "\n" +
                    "Fax : 0096227211117"
        ))

        // أقسام كلية الهندسة (اللي الـ ID بتاعها 5)
        departmentDao.insert(Department(
            name = "Civil Engineering",
            facultyOwnerId = 5,
            description = "Established in 2012, the Department of Civil Engineering at the Hijjawi Faculty for Engineering Technology, Yarmouk University, is committed to delivering high-quality education and research in civil and infrastructure engineering. The department offers three degree programs: a Bachelor in Civil Engineering, a Bachelor in Smart and Sustainable Cities Engineering, and a Master in Construction Engineering and Management. These programs are designed to equip students with the technical knowledge and practical skills necessary to meet the demands of the evolving construction and urban development sectors.\n" +
                    "\n" +
                    "The department is home to a diverse group of faculty members with expertise spanning major civil engineering disciplines, including structural engineering, transportation and pavement engineering, geotechnical engineering, water resources, environmental and wastewater treatment engineering, and construction project management.\n" +
                    "\n" +
                    "To support experiential learning, the department maintains a suite of specialized laboratories operated by skilled engineers and technicians. These facilities provide students with hands-on training in construction materials testing, soil mechanics, hydraulics, surveying, and environmental analysis—bridging the gap between theory and practice.\n" +
                    "\n" +
                    "The department plays a vital role in preparing future engineers to contribute meaningfully to sustainable infrastructure and smart urban development at both national and international levels.",
            headOfDepartment = "Dr. Mu'ath Abu Qamar\n" +
                    "Assistant Professor, Civil Engineering",
            locationInFaculty = "The Department of Civil Engineering is located on the Fourth Floor of the Extension Building at the Hijjawi Faculty for Engineering Technology (Building HN). The department is open during official working hours to assist students, prospective students, and faculty members.",
            contactEmail = "Email: civil.dept@yu.edu.jo\n" +
                    "AbuQamar.Muath@yu.edu.jo",
            contactPhone = "Phone: +962 2 721 1111 ext. 4523\n"
        ))
        departmentDao.insert(Department(
            name = "Electronic Engineering",
            facultyOwnerId = 5,
            description = "The Department of Electronics Engineering at the Hijjawi Faculty for Engineering Technology, Yarmouk University, was established in 1993 and has since been dedicated to excellence in education, research, and innovation.\n" +
                    "\n" +
                    "The department currently offers a dynamic Bachelor in Electronics and Robotics Engineering degree program, designed to provide students with a strong foundation in theory alongside practical, hands-on experience.\n" +
                    "\n" +
                    "Our academic staff includes highly qualified faculty members with expertise across various areas of electronics and robotics engineering. To support both learning and research, the department is equipped with specialized laboratories, operated and maintained by skilled engineers and technicians, ensuring students gain real-world, applied knowledge in a modern educational environment.",
            headOfDepartment = "\n" +
                    "Dr. Yusra M. Obeidat",
            locationInFaculty = "The Department of Electronics Engineering is located on the Third Floor of the Old Building at the Hijjawi Faculty for Engineering Technology (Building H). The department is open during official working hours to assist students, prospective students, and faculty members.",
            contactEmail = "Email: electronics.dept@yu.edu.jo\n" +
                    "yusra.obeidat@yu.edu.jo",
            contactPhone = "Phone: +962 2 721 1111 ext. 4339",
        ))
        departmentDao.insert(Department(
            name = "Communication Engineering",
            facultyOwnerId = 5,
            description = "Established in 1989, the Department of Communication Engineering at the Hijjawi Faculty for Engineering Technology, Yarmouk University, has been a cornerstone in advancing the communication industry in Jordan and beyond. Since its inception, the department has consistently produced highly qualified graduates who contribute significantly to both local and international markets.\n" +
                    "\n" +
                    "The department currently offers a Bachelor in Communication Engineering degree program, designed to equip students with a solid theoretical foundation complemented by practical, hands-on experience. In addition, it offers a Master in Wireless Communication Engineering degree program, preparing students for advanced roles in academia, research, and the telecommunications industry.\n" +
                    "\n" +
                    "Our academic staff comprises a team of experienced and highly qualified faculty members, each specializing in different areas of communication engineering. Their diverse expertise enriches the learning environment and supports a wide range of research activities.\n" +
                    "\n" +
                    "To ensure a comprehensive educational experience, the department is equipped with state-of-the-art laboratories tailored for various aspects of communication engineering. These facilities are maintained by skilled engineers and technicians, enabling students to gain applied knowledge and develop critical problem-solving skills in a real-world context.",
            headOfDepartment = "\n" +
                    "Dr. Hasan Aldiabat",
            locationInFaculty = "The Department of Communication Engineering is located on the Fifth Floor of the Old Building at the Hijjawi Faculty for Engineering Technology (Building H). The department is open during official working hours to assist students, prospective students, and faculty members.",
            contactEmail = "Email: communications.dept@yu.edu.jo\n" +
                    "hasan.aldiabat@yu.edu.jo",
            contactPhone = "Phone: +962 2 721 1111 ext. 4539",
        ))
        departmentDao.insert(Department(
            name = "Computer Engineering",
            facultyOwnerId = 5,
            description = "Established in 1993, the Department of Computer Engineering at the Hijjawi Faculty for Engineering Technology, Yarmouk University, has played a pivotal role in shaping the landscape of computer engineering education in Jordan. Over the years, the department has consistently produced highly skilled graduates who contribute to innovation and development in both the local and international tech industries.\n" +
                    "\n" +
                    "The department currently offers two Bachelor degree programs: Computer Engineering, and Computer Engineering – Internet of Things (IoT), each designed to address the growing demand for expertise in computing technologies and smart systems. In addition, the department offers a Master in Computer Engineering degree program, aimed at preparing students for advanced roles in research, development, and academia.\n" +
                    "\n" +
                    "Our faculty includes a distinguished group of professionals with expertise across a wide spectrum of computer engineering fields, such as embedded systems, IoT, artificial intelligence, cybersecurity, computer networks, and software systems. Their commitment to teaching and research enhances the academic experience and supports innovation.\n" +
                    "\n" +
                    "To support hands-on learning and applied research, the department is equipped with modern laboratories and computing facilities. These labs are maintained by qualified engineers and provide students with essential practical experience, allowing them to apply theoretical concepts to real-world challenges and emerging technologies.\n" +
                    "\n",
            headOfDepartment = "Dr. Mahmoud Masadeh\n" +
                    "Associate Professor, Computer Engineering",
            locationInFaculty = "The Department of Computer Engineering is located on the Fourth Floor of the Old Building at the Hijjawi Faculty for Engineering Technology (Building H). The department is open during official working hours to assist students, prospective students, and faculty members.",
            contactEmail = "Email: computer.dept@yu.edu.jo\n" +
                    "mahmoud.s@yu.edu.jo",
            contactPhone = "Phone: +962 2 721 1111 ext. 4439\n"

        ))
        departmentDao.insert(Department(
            name = "Electrical Power Engineering",
            facultyOwnerId = 5,
            description = "Established in 1993, the Department of Electrical Power Engineering at the Hijjawi Faculty for Engineering Technology, Yarmouk University, has played a key role in supporting the development of the energy sector in Jordan and the wider region. The department has been instrumental in producing skilled engineers who are actively contributing to power generation, transmission, distribution, and smart energy solutions both locally and internationally.\n" +
                    "\n" +
                    "The department offers a Bachelor in Electrical Power Engineering degree program, focused on delivering a strong foundation in power systems, electrical machines, renewable energy, and control systems. It also offers a Master in Electrical Power Engineering degree program, aimed at preparing students for advanced careers in industry, academia, and research.\n" +
                    "\n" +
                    "Our faculty is composed of highly qualified academics with specialized expertise across various areas of electrical power engineering. Their commitment to teaching and research creates a dynamic learning environment that supports student development and fosters innovation.\n" +
                    "\n" +
                    "To support hands-on learning and applied research, the department houses modern laboratories equipped for high-voltage testing, power electronics, and machine control. These facilities are managed by qualified engineers and technical staff, ensuring students gain practical experience and industry-relevant skills throughout their studies.",
            headOfDepartment = "Prof. Mohammad Al-Momani",
            locationInFaculty = "The Department of Electrical Power Engineering is located on the Second Floor of the Old Building at the Hijjawi Faculty for Engineering Technology (Building H). The department is open during official working hours to assist students, prospective students, and faculty members.",
            contactEmail = "Email: electric.dept@yu.edu.jo\n" +
                    "mohammadh@yu.edu.jo",
            contactPhone = "Phone: +962 2 721 1111 ext. 4239\n"
        ))
        departmentDao.insert(Department(
            name = "Biomedical Systems and informatics Engineering",
            facultyOwnerId = 5,
            description = "Established in 2007 with the support of the European Union / Tempus Program, the Department of Biomedical Systems and Informatics Engineering at the Hijjawi Faculty for Engineering Technology, Yarmouk University, is dedicated to advancing education and research in the interdisciplinary field of biomedical engineering.\n" +
                    "\n" +
                    "The department offers two Bachelor degree programs—Biomedical Systems Engineering and Biomedical Informatics Engineering—as well as a Master’s program in Biomedical Systems and Informatics Engineering. These programs are designed to equip students with the knowledge and practical skills required to address the complex challenges at the intersection of healthcare, biology, and engineering.\n" +
                    "\n" +
                    "Our faculty comprises a team of highly qualified academics and researchers specializing in diverse areas such as biomedical instrumentation, biomedical signal processing, transducers, medical imaging and image processing, biomechanics, biomaterials, tissue engineering, bioinformatics, medical informatics, parallel computing, and artificial intelligence. Their active involvement in scientific research contributes to both academic excellence and technological innovation.\n" +
                    "\n" +
                    "To foster a strong foundation in both theory and application, the department is equipped with state-of-the-art laboratories operated and maintained by skilled engineers. These facilities provide students with hands-on experience, encouraging innovation and practical problem-solving in real-world biomedical and healthcare contexts.",
            headOfDepartment = "\n" +
                    "Eng. Sami Almashaqbeh",
            locationInFaculty = "The Department of Biomedical Systems and Informatics Engineering is located on the Fifth Floor of the Extension Building at the Hijjawi Faculty for Engineering Technology (Building HN). The department is open during official working hours to assist students, prospective students, and faculty members.",
            contactEmail = "Email: medical.dept@yu.edu.jo\n" +
                    "sami.m@yu.edu.jo",
            contactPhone = "Phone: +962 2 721 1111 ext. 4551"
        ))
        departmentDao.insert(Department(
            name = "industrial Engineering",
            facultyOwnerId = 5,
            description = "Established in 2013, the Department of Industrial Engineering at the Hijjawi Faculty for Engineering Technology, Yarmouk University, is dedicated to producing highly competent engineers equipped to meet the demands of modern industry. The department offers a Bachelor in Industrial Engineering and a Master in Engineering Management, both designed to integrate engineering principles with management practices and decision-making tools.\n" +
                    "\n" +
                    "Led by a team of experienced and research-active faculty members, the department promotes a dynamic academic environment where teaching is continuously enriched by ongoing research and industry engagement. Faculty expertise spans a wide range of areas including operations research, quality engineering, production systems, supply chain management, and human factors engineering.\n" +
                    "\n" +
                    "To support practical and applied learning, the department features well-equipped laboratories operated by skilled engineers and technicians. These facilities enable students to gain hands-on experience and apply theoretical knowledge to solve real-world problems in industrial settings.\n" +
                    "\n" +
                    "Through its programs, research, and industry collaboration, the Department of Industrial Engineering plays a vital role in advancing the field and preparing graduates for leadership roles in manufacturing, logistics, service systems, and beyond.",
            headOfDepartment = "Dr. Ahmad Mumani",
            locationInFaculty = "The Department of Industrial Engineering is located on the Third Floor of the Extension Building at the Hijjawi Faculty for Engineering Technology (Building HN). The department is open during official working hours to assist students, prospective students, and faculty members.",
            contactEmail = "Email: ie.dept@yu.edu.jo\n" +
                    "ahmad.mumani@yu.edu.jo",
            contactPhone = "Phone: +962 2 721 1111 ext. 4291"
        ))
        departmentDao.insert(Department(
            name = "Architectural Engineering",
            facultyOwnerId = 5,
            description = "Established in 2013, the Department of Architectural Engineering at the Hijjawi Faculty for Engineering Technology, Yarmouk University, is committed to cultivating creative and forward-thinking architects equipped to address the evolving needs of contemporary society. The department offers a Bachelor in Architectural Engineering degree program, designed to balance architectural theory, design innovation, and technical proficiency.\n" +
                    "\n" +
                    "Our academic program emphasizes creativity, sustainability, and responsiveness to local and global architectural contexts. The curriculum is carefully tailored to align with the cultural, environmental, and societal demands of Jordan while incorporating international best practices and technological advancements in architecture and urban design.\n" +
                    "\n" +
                    "The department is supported by a dedicated team of faculty members with diverse academic backgrounds and professional expertise. Their active engagement in research, practice, and community-oriented projects enhances the learning experience and helps students build a strong foundation in both design and technical competencies.\n" +
                    "\n" +
                    "With access to specialized design studios, modeling labs, and digital tools, students are encouraged to explore, experiment, and realize their architectural visions through hands-on learning. The department also fosters connections with the architecture and construction industries, promoting internships, collaborative projects, and exposure to real-world challenges.\n" +
                    "\n" +
                    "Through its integrated approach to education, the Department of Architectural Engineering prepares graduates to become innovative professionals capable of shaping functional, sustainable, and aesthetically inspiring built environments in Jordan and beyond.",
            headOfDepartment = "Dr. Baraa Alkhatatbeh",
            locationInFaculty = "The Department of Architectural Engineering is located on the Third Floor of the New Building at the Hijjawi Faculty for Engineering Technology (Building HNN). The department is open during official working hours to assist students, prospective students, and faculty members.",
            contactEmail = "Email: arch@yu.edu.jo\n" +
                    "baraa.alkhatatbeh@yu.edu.jo",
            contactPhone = "Phone: +962 2 721 1111 ext. 2470\n"
        ))

        // أقسام كلية تكنولوجيا المعلومات (اللي الـ ID بتاعها 6)
        departmentDao.insert(Department(
            name = "Computer Science",
            facultyOwnerId = 6,
            description = "The Department of Computer Sciences was established in 1978 and started offering a B.Sc. degree in Computer Sciences in 1980. At the beginning of the academic year 2002/2003 the Faculty of Information Technology and Computer Sciences was established, " +
                    "and the Department of Computer Sciences was moved to this new faculty. The curriculum has been modified accordingly to keep pace with changes and developments taking place locally and internationally in order to raise the level of academic graduate and to provide " +
                    "him with the skills and techniques that qualify him to be competitive in the market. year 2000/2001 the Master’s program in Computer Sciences and Information Systems was established. The curriculum was modified in 2003 and the new curriculum was adopted at the beginning of the academic year 2003/2004. The name of the program becomes Master’s in Computer Sciences. ",
            headOfDepartment = "prof.Bilal Abed-Alguni",
            locationInFaculty = "",
            contactEmail = "Email:bilal.h@yu.edu.jo\n" +
                    "Computersci.dept@yu.edu.jo\n" +
                    " it.fac@yu.edu.jo",
            contactPhone = "phone:  027211111 (2632)\n" +
                    "0096227211128\n" +
                    " Phone : 00962-2-7211111     Ext. : 2561"
        ))
        departmentDao.insert(Department(
            name = "Information Systems",
            facultyOwnerId = 6,
            description = "The Department of  Information Systems (IS) was established in the academic year 2002/2003 as part of the Faculty of Information Technology and Computer Sciences. The department offers a bachelor degree in CIS which provides promising employment opportunities in business, industry and the area of Information Technology. Recently in 2008, the department has reviewed the curriculum for the bachelor degree and a new comprehensive and emergent curriculum has been approved.\n" +
                    "\n" +
                    "As for higher education, the department offers a Master degree in CIS (comprehensive Exam track) as well as a joint diploma degree in ICT with the University of InHolland, the first to be offered program in the Middle East. This Diploma integrates the usage of ICT technologies into education. In the 2008, the department established a new special Master track to suite employed students, where the lectures are held on Thursday evenings and Saturdays. \n" +
                    "\n" +
                    "Several well equipped labs are set up to serve students which include some specialized labs such as Multimedia labs, Software Engineering Labs, and Database labs.\n" +
                    "\n" +
                    "The department provides the academic requirements for the use of computer skills for various colleges and disciplines at the university.\n" +
                    "The main objective of the Department is to improve the quality of teaching by concentrating on the practical part of the classes that needs practical training in addition to the theoretical classes.",
            headOfDepartment = "Dr. Enas A. Alikhashashneh",
            locationInFaculty = "",
            contactEmail = " Email:enas.a@yu.edu.jo\n" +
                    "Department Email: computerinfo.dept@yu.edu.jo\n" +
                    " it.fac@yu.edu.jo",
            contactPhone = "Phone: 027211111 (2632)\n" +
                    " 0096227211128\n" +
                    "Phone : 0096227211111"
        ))
        departmentDao.insert(Department(
            name = "Information Technology",
            facultyOwnerId = 6,
            description = "The department of  Information Technology ( previously ) Management Information Systems (MIS)  was established along with the Faculty of Information Technology " +
                    "and Computer Sciences at the beginning of the 2002/2003 academic year. The department offers  a bachelor’s degree in Business " +
                    "Information Technology program and in Cybersecurity program. These programs was designed carefully to provide the graduates " +
                    "with the technical and managerial skills and knowledge needed to analyze, design, develop, put into practice, and manage " +
                    "information and information systems in organizations. The department has various advanced computer labs that being used in" +
                    " teaching programming languages, project management related to MIS, decision support systems, and electronic commerce. " +
                    "In addition, the department has a research lab dedicated to graduate student. At the beginning of 2007/2008," +
                    " the Master program was established and offers a Master degree in Management Information Systems, this program was recognized as the only of its kind in Jordanian universities.\n",
            headOfDepartment = "Dr.Aladeen Y. Hmoud",
            locationInFaculty = "",
            contactEmail = "Email: aladeen.hmoud@yu.edu.jo\n" +
                    " it.fac@yu.edu.jo\n" +
                    " managmentinfo.dept@yu.edu.jo",
            contactPhone = "Phone 3843   \n" +
                    "\n" +
                    "Phone : 0096227211111     Ext. : 2634\n" +
                    " 027211111 (2632)\n" +
                    " 0096227211128"
        ))

        // أقسام كلية القانون (اللي الـ ID بتاعها 7)
        departmentDao.insert(Department(
            name = "Public Law",
            facultyOwnerId = 7,
            description = "This department concerns teaching the following themes: Constitutional Law, Administrative Law, Public Finance & Tax Legislations," +
                    " Criminal Law, and Public International Law. Teaching these themes is conducted by means of theory and practice with particular focus upon Jordanian Laws that govern these themes. The department has around ten distinguished and dedicated academic staff. There of them are full professors, three are associate professors, two of them are assistant professors, and one of them is a teacher. The department is intended to establish Master Program in the administrative law which will be the first in its type in Jordan.\n" +
                    "\n",
            headOfDepartment = "Dr. WASEF AL-ZBOUN",
            locationInFaculty = "",
            contactEmail = "Publiclaw.dept@yu.edu.jo\n" +
                    "law.fac@yu.edu.jo",
            contactPhone = "Phone : 027211111     Ext. : 4212"
        ))
        departmentDao.insert(Department(
            name = "Private Law",
            facultyOwnerId = 7,
            description = "The Private Law Department offers an LL.B. program jointly with the Public Law Department. It also runs an LLM program in commercial law." +
                    " As with the undergraduate course, the language of instruction at the postgraduate level is Arabic, but certain modules are instructed in English. Postgraduate students are required to study 33 credited hours, including a research-based module. LLM students are also required to pass a comprehensive examination at the end of their course.",
            headOfDepartment = "Prof. NAEEM AL OTOUM",
            locationInFaculty = "",
            contactEmail = "Privatelaw.dept@yu.edu.jo\n" +
                    " law.fac@yu.edu.jo",
            contactPhone = "Phone : 027211111     Ext. : 4312",
        ))

        // أقسام كلية الآداب (اللي الـ ID بتاعها 8)
        departmentDao.insert(Department(
            name = "Arabic Language",
            facultyOwnerId = 8,
            description = "The Department of Arabic Language and Literature was established with the establishment of the university in 1976, within the Faculty of Arts, and the first batch of undergraduate students graduated in 1980, and in February 1981, the postgraduate program for a master's degree in two disciplines was opened: \"Literature and Criticism\" and \"Language and Grammar\", and hundreds of master's theses have been discussed in the department so far, the first of which was in February 1983. In 1991, the department opened a doctoral program in the field of literature and criticism, and the first doctoral thesis was discussed in August 1997. The Doctor of Language and Grammar and Doctoral Program in Applied Linguistics were approved in 1998. The department has established close relations with a number of similar departments in Arab and foreign universities, culminating in cooperation agreements between the university and higher institutes in Malaysia.\n" +
                    "\n" +
                    "Since 1987, the department has been holding a biennial literary criticism conference at the university. The first conference was held from 20-23 July 1987 and then this conference was held successively.\n" +
                    "\n" +
                    "The number of teachers working in the department is (26) faculty members, of which eighteen are at the rank of professor, seven at the rank of associate professor, and a faculty member at the rank of assistant professor.\n" +
                    "\n" +
                    "Most of the faculty members in the department actively participate in conferences, scientific meetings and seminars inside and outside Jordan, with research related to the themes of these conferences, meetings and seminars in all branches related to the specialization of Arabic language and literature.",
            headOfDepartment = "Dr. Alaeddin Al-Gharaibeh",
            locationInFaculty = "",
            contactEmail = " Art.fac@yu.edu.jo\n" +
                    " Arabic.dept@yu.edu.jo",
            contactPhone = "Telephone : 027211111 Ext. : 2731"
        ))
        departmentDao.insert(Department(
            name = "English Language & Literature",
            facultyOwnerId = 8,
            description = "Since its establishment in 1976, the Department of English Language and Literature has been providing students with courses in English, Linguistics, English Literature, American Literature, Comparative Literature, Translation and Writing, as well as preparing students for bachelor's and master's degrees.\n" +
                    "\n" +
                    "The department offers two postgraduate programs, the first in linguistics and the second in literature and criticism, in which the student obtains a master's degree after completing (33) credit hours and passing a comprehensive exam or writing a thesis. The department was offering a third program in the master's degree in translation since the early nineties until this specialization moved to the translation department from the beginning of the academic year 2.1./2.11.\n" +
                    "\n" +
                    "This department is one of the largest in the university, with about 850 students enrolled in the undergraduate program and about 185 students in the graduate program.\n" +
                    "\n" +
                    "The department is taught by an integrated academic staff consisting of (31) faculty members, the majority of whom are professors and associate professors, all of whom are graduates of British, American and Canadian universities, and there are two envoys of the department in the United States of America and Canada to obtain a doctorate degree in linguistics, literature and criticism, and to achieve the university's goals in community service, the department has contributed since its establishment in cooperation with the Center for Consulting and Community Service in the preparation, development and teaching of English language programs implemented by the center in Jordan These programs covered the needs of engineers, doctors, bank employees, corporate technicians, school students and those wishing to complete their education abroad.\n" +
                    "\n" +
                    "Among the activities of the department is a cultural season in which it receives a series of lectures that reflect the interests of faculty members and their research, and the department holds a number of seminars and films and videos of masterpieces of English literature, as well as the department used to hold an international conference once every two years to which researchers from Arab and Western universities in the fields of language, literature and translation are invited, and the conference has been stopped since 2010 due to lack of financial funding.\n" +
                    "\n" +
                    "As for the graduates of the department who hold bachelor's and master's degrees, they now constitute a large percentage of the faculty members (Ph.D. and master's holders) of various ranks in most Jordanian universities, especially science and technology, Philadelphia, Jadara and Mutah.",
            headOfDepartment = "Dr. Magdy Abu Dalbouh",
            locationInFaculty = "",
            contactEmail = "Art.fac@yu.edu.jo\n" +
                    " English.dept@yu.edu.jo",
            contactPhone = "Telephone : 0096227211111 ext. : 2631"
        ))
        departmentDao.insert(Department(
            name = "History & Civilization",
            facultyOwnerId = 8,
            description = "One of the academic departments in the Faculty of Arts, established in 1983/1984, and since its establishment, began granting a bachelor's degree in history, and then began granting a master's degree at the beginning of the academic year 1987/1988 in my specialization:\n" +
                    "\n" +
                    "Islamic History and Islamic Civilization.\n" +
                    "Modern and Contemporary History.\n" +
                    "\n" +
                    "Then the doctoral program was established in the department in the first semester of the academic year 2000/2001 and the doctorate degree in philosophy was awarded in my specialization:\n" +
                    "\n" +
                    "Islamic History and Islamic Civilization.\n" +
                    "Modern and Contemporary History.",
            headOfDepartment = "Dr. Muhannad Al-Dajah",
            locationInFaculty = "",
            contactEmail = "Art.fac@yu.edu.jo\n" +
                    "History.dept@yu.edu.jo",
            contactPhone = "Telephone : 027211111 Ext. : 2355\n"
        ))
        departmentDao.insert(Department(
            name = "Modern Languages",
            facultyOwnerId = 8,
            description = "The Department of Modern Languages was established in 1984/1985 to meet the needs of the Jordanian community of qualified students in the French language and in supporting specializations in Spanish, Italian, German and Russian languages in response to and meet the needs of students of other faculties at the university to study some foreign languages.\n" +
                    "\n" +
                    "Within the framework of its study plan, the department offers a major and a single major in the French language. Students of the department are also allowed to branch out in the following departments: Arabic Language, English Language, Translation and in the departments of the Faculty of Journalism and Mass Communication. Students from many other departments are also allowed to branch out in the Department of Modern Languages. The department also offers courses in Italian, Russian, German, Korean, and Chinese as university and college requirements to allow university students of all disciplines to learn about new languages and cultures.\n" +
                    "\n" +
                    "Three new tracks were introduced in the department and approved and implemented at the beginning of the second semester 2018/2019:\n" +
                    "\n" +
                    "1. Spanish - English\n" +
                    "\n" +
                    "2. German - English\n" +
                    "\n" +
                    "3. French Language - English Language The\n" +
                    "\n" +
                    "Master's program in Linguistics - French Language was opened starting from the second semester of the academic year 2010/2011 in cooperation with the French University of Nantes, and an agreement was signed with the Agence Universitaire de la Francophonie that aims to strengthen cooperation with Francophone universities in the Middle East.\n" +
                    "\n" +
                    "The number of faculty members in the department is (12) teachers who hold doctoral and master's degrees from Jordanian, French, Spanish and Italian nationalities, according to the following distribution:\n" +
                    "\n" +
                    "French language teachers: (1) professor, (2) associate professor, (3) assistant professor (2) teacher (4), and full-time lecturer who works on account of the agreement between the university and the French embassy.\n" +
                    "\n" +
                    "German Language Teachers: (1) Russian Language Teachers Professor\n" +
                    "\n" +
                    ": (1) Italian Language\n" +
                    "Teachers\n" +
                    ": A full-time lecturer who works at the expense of the agreement between the University and the Italian Embassy.\n" +
                    "\n" +
                    "In addition to (1) a\n" +
                    "\n" +
                    "laboratory technician, the number of students in the department is (286) students. The department also organizes many extracurricular cultural activities in cooperation with a number of foreign embassies in Jordan, especially the French Embassy in Amman, which organizes the Francophone Week in March of every year, which is full of a number of diverse linguistic and cultural activities.",
            headOfDepartment = "Dr. Nabil Al-Awawdeh",
            locationInFaculty = "",
            contactEmail = "Art.fac@yu.edu.jo\n" +
                    "Mlanguages.dept@yu.edu.jo\n",
            contactPhone = "Telephone : 027211111 ext. : 3360\n"
        ))
        departmentDao.insert(Department(
            name = "Politics & International Studies",
            facultyOwnerId = 8,
            description = "The Department of Political and International Studies is one of the leading academic departments in the College of Arts, and is concerned with the study of politics and international relations from a critical perspective. The department has a group of distinguished professors and researchers in various fields, including international relations, political theory, and comparative politics.\n" +
                    "\n" +
                    " Establishment and Development\n" +
                    "\n" +
                    " Established in 1991 as the \"Department of Political Science\", the department quickly became a leader in its field. Today, the department offers a variety of study programs, ranging from a bachelor's degree in political science to a master's degree in international political economy. The department also offers a minor for many students from other colleges and departments.\n" +
                    "\n" +
                    "The Department of Political and International Studies has a capacity of 400 students, with a distinguished faculty of 12 members from various academic ranks.\n" +
                    "\n" +
                    "In October 2023, the Department of Political Science underwent an important transformation, as its name was changed to the Department of Political and International Studies, a change that reflects the department's dedication to keeping pace with global developments and addressing contemporary international issues. It also reflects a commitment to laying the foundations for new academic programs, while eagerly looking forward to the new opportunities and contributions that this transformation will bring.",
            headOfDepartment = "Dr. Aref Bani Hamad\n",
            locationInFaculty = "",
            contactEmail = "Art.fac@yu.edu.jo\n" +
                    "Political.dept@yu.edu.jo\n",
            contactPhone = "Telephone : 0096227211111 ext. : 2351\n"
        ))
        departmentDao.insert(Department(
            name = "Sociology & Social Services",
            facultyOwnerId = 8,
            description = "The Department of Sociology was established at the beginning of the 1991/1992 academic year to grant a bachelor's degree in sociology. The department aims to prepare social researchers, counselors, and social workers by providing students with theoretical and practical knowledge, which is needed by various social institutions and the local community in general, and in the academic year 2.1/2..2, the master's program in sociology was started, where many Jordanian and Arab students graduated from the department who studied the issues and problems of our societies.\n" +
                    "\n" +
                    "In order to keep pace with the community's need for qualified people in social work, in the academic year 2006/2007, the name of the department was amended and its plan was updated to grant a bachelor's degree in sociology and social work, and a minor in sociology or social work.\n" +
                    "\n" +
                    "The members of the department contribute to scientific research by studying many social phenomena and problems, and their participation in community service by holding seminars and lectures, systematic and extracurricular lectures, participating in community committees, providing consultations that contribute to solving the problems faced by the Jordanian society today, and predicting future problems to avoid and solve them.\n" +
                    "\n" +
                    "The number of faculty members in the department is ten members, and the number of students in the bachelor's program is 414 students, and the master's program is 20 students.",
            headOfDepartment = "Dr. Mohammed Al-Harahasheh\n" +
                    "\n",
            locationInFaculty = "",
            contactEmail = "Art.fac@yu.edu.jo\n" +
                    "Sociology.dept@yu.edu.jo\n",
            contactPhone = "Telephone : 027211111 ext. : 3663\n"
        ))
        departmentDao.insert(Department(
            name = "Semitic & Oriental Languages",
            facultyOwnerId = 8,
            description = "The Department of Semitic and Oriental Languages at the Faculty of Arts was established in 2000, and currently offers a bachelor's degree in Hebrew and Turkish as a major. It also offers a minor in Turkish, Hebrew and Persian language with an average of twenty-one 21 credit hours for the departments of the Faculty of Arts, in addition to three hours in the mentioned languages as an optional requirement for the faculty.\n" +
                    "\n" +
                    "The number of professors of this department is eleven (11) members who hold doctoral and master's degrees (9 hold doctoral degrees and 2 hold master's degrees), including two faculty members who hold a doctorate degree of Turkish nationality who work under the agreement of the Turkology project concluded between Yarmouk University and the Turkish Cultural Institute Yunus Emra. This is according to the following distribution:\n" +
                    "\n" +
                    "The faculty members of the Turkish Language Program: There are five (5) Ph.D. members, including two faculty members of Turkish nationality who work under the Turkology Project Agreement between Yarmouk University and the Turkish Cultural Institute Yunus Emre.\n" +
                    "\n" +
                    "Faculty members in the Hebrew Language Program: There are six (6) members, four (4) of whom are Ph.D. holders and two (2) are M.A. holders.\n" +
                    "\n" +
                    "One of the strengths of the department is the link of the Turkish language program to the agreement of the Turkish Science Project signed with the Turkish Cultural Center, in addition to its association with a number of Turkish universities with academic exchange agreements within the Erasmus+ program funded by the European Union, where these agreements provide the opportunity for a number of distinguished students to spend one semester in the Turkish universities with which this agreement was signed, with the equivalence of the courses that are passed upon return from the scholarship, and one of these universities is Sakarya University. Wildz Tech, Istanbul Medinit, Sivas University, Cancre University, and Anatolian University.Some Turkish entities also provide scholarships for distinguished students who graduated from the program to study master's and doctorates, and the number of students who have received postgraduate scholarships from the program so far is ten students.\n" +
                    "\n" +
                    "Number of Students:\n" +
                    "\n" +
                    "The number of students in the Hebrew language program is 135 students, including twelve Emirati students, while the number of students in the Turkish language program is 190 students, with a total of (325) students.",
            headOfDepartment = "Dr. Rabaa Rababa\n",
            locationInFaculty = "",
            contactEmail = "Art.fac@yu.edu.jo\n" +
                    "Semitic.dept@yu.edu.jo\n",
            contactPhone = " Telephone : 0096227211111 ext. : 3360\n" +
                    "\n"
        ))
        departmentDao.insert(Department(
            name = "Geography",
            facultyOwnerId = 8,
            description = "The establishment of the Department of Geography at the beginning of the academic year 2000/2001 came due to the urgent need for holders of a bachelor's degree in geography, both in the public and private sectors. This is evidenced by the unexpected demand of students to register in this specialization, the specialization is unique in the following tracks: Geography/General Geography, Geography/Geographic Information Systems, and Geography/Spatial Planning, which allows graduates to compete and more easily in order to obtain job opportunities available in various sectors, whether in the local or foreign market.\n" +
                    "\n" +
                    "This demand is due to their sense of the importance of this specialization and the need of the local and foreign market, in addition to the possibility of completing postgraduate studies within the path that the student wants. The geography student studies (54) compulsory credit hours, to which the student who chooses the tourism planning or spatial planning track adds (21) compulsory credit hours, in addition to (12) optional credit hours of subjects, i.e. the graduation requirements for the Bachelor of Geography are (132) credit hours in any of the three tracks. The department's study plan is characterized by a scientific, practical, modern technical character, and training in the use of computers in geography, geographic information systems and their applications, and remote sensing.\n" +
                    "\n" +
                    "To achieve this goal, a geography laboratory and studio was established, which was equipped with computers, software, maps, and aerial image analyzers, all of which were needed by the applied courses.",
            headOfDepartment = "Dr. Mohamed Zeitoun\n",
            locationInFaculty = "",
            contactEmail = "Art.fac@yu.edu.jo\n" +
                    "Geography.dept@yu.edu.jo\n",
            contactPhone = "Telephone : 00962 27211111 Ext. : 3451"
        ))
        departmentDao.insert(Department(
            name = "Translation",
            facultyOwnerId = 8,
            description = "The Department of Translation was established at the beginning of the academic year 2008/2009, " +
                    "and it is the first of its kind in Jordanian public universities. The establishment of the department" +
                    " came due to the urgent need to provide qualified translators in all fields such as translation, i" +
                    "nterpretation, and translation of conferences and seminars. The Department of Translation is dynamic and sophisticated " +
                    "as the department offers two degrees: Bachelor's and Master's degrees in Translation as the latter moved from the Department " +
                    "of English in the academic year 2010/2011, and the department is currently planning to award master's degrees in interpretation and " +
                    "a doctorate degree in translation.\n" +
                    "The program includes the theoretical and practical aspect, where the department prepares graduates to work in the translation" +
                    " profession who have been trained in translating various types of texts such as translation, interpretive, specialized, simultaneous, " +
                    "sequential, and other theoretical and applied studies. The program includes several courses in language skills in Arabic and English," +
                    " as well as courses including comparative and analytical linguistics, discourse analysis, semantics, and the use of computer translation (CAT)" +
                    " application tools. The program aims to develop students' skills in translation and interpretation in order to meet the labor market requirements " +
                    "of translators inside and outside Jordan, especially in this era of great development in information and communication technology," +
                    " as there is an urgent need for translators in various fields and sectors such as the media, governmental and non-governmental institutions" +
                    ", as well as in local, regional and international institutions. The department holds annual discussion talks and seminars on translation and " +
                    "interpretation studies in order to keep professors and students up to date. A good number of students who are graduates of the department are" +
                    " pursuing their postgraduate studies (master's and doctorate) at prestigious Jordanian, British and American universities. " +
                    "The teaching is based on a group of faculty members who are graduates of American, British, Australian and Arab universities.",
            headOfDepartment = "Dr. Raafat Al-Roussan\n" +
                    "\n",
            locationInFaculty = "",
            contactEmail = "Art.fac@yu.edu.jo\n" +
                    " Email:Trans_dept@yu.edu.jo ",
            contactPhone = "Telephone : 0096227211111 Ext. : 2391"
        ))
        departmentDao.insert(Department(
            name = "Humanitarian Service Courses",
            facultyOwnerId = 8,
            description = "The Department of Humanitarian Service Courses was established in 2017, due to the need to provide an academic and administrative umbrella " +
                    "concerned with offering a set of humanitarian service courses, which are known as the university's elective requirements, " +
                    "and the department was located at the time of its establishment in the Faculty of Archaeology and Anthropology, and at the beginning " +
                    "of the academic year 2021/2022, this department became part of the Faculty of Arts, and this department does not grant any degree in any of " +
                    "the academic disciplines, but it offers and teaches a number of elective courses at the university, in addition to elective and compulsory " +
                    "courses in the Faculty of Arts in line with the study plans for the various academic majors for the bachelor's level at Yarmouk University," +
                    "and in line with the academic accreditation standards of universities in Jordan.",
            headOfDepartment = "Dr. Bader Aliwa",
            locationInFaculty = "",
            contactEmail = "Art.fac@yu.edu.jo\n" +
                    "\n" +
                    "Email: hsc.dept@yu.edu.jo",
            contactPhone = "Phone: 27211111, ext:"
        ))

        // أقسام كلية الأعمال (اللي الـ ID بتاعها 9)
        departmentDao.insert(Department(
            name = "Economics",
            facultyOwnerId = 9,
            description = "The department was established in 1976 and has been offering a bachelor's program in economics since its inception. In 1986, the department offered a master's program in economics. In 2002, he began to introduce a new track in the field of finance and business economics at the bachelor's degree level.\n" +
                    "\n" +
                    "The department qualifies its students with the necessary knowledge and skills in the fields of theoretical and applied economics to meet the needs of the labor market locally and internationally.",
            headOfDepartment = "Mr. Atef Mohamed Khalil Bani Atta\n" +
                    "\n",
            locationInFaculty = "",
            contactEmail = "Economic.dept@yu.edu.jo\n" +
                    " economics.fac@yu.edu.jo",
            contactPhone = "  027211111 (6800)\n" +
                    "  0096227211147\n" +
                    "Telephone : 027211111 ext. : 6706"
        ))
        departmentDao.insert(Department(
            name = "Business Administration",
            facultyOwnerId = 9,
            description = "The department was established in 1982 and has been offering a bachelor's program in business administration since its inception, and in 1993 the department introduced a Master of Business Administration (MBA) program.\n" +
                    "\n" +
                    "The department qualifies its students with theoretical and applied knowledge in business administration and management skills to keep pace with changes and developments locally and internationally.\n" +
                    "\n" +
                    "The department also provides qualified cadres to provide training and consulting services in various fields of business administration to the public and private sectors locally and internationally.",
            headOfDepartment = "Dr. Hassan Al-Issa",
            locationInFaculty = "",
            contactEmail = "  Business.dept@yu.edu.jo\n" +
                    " economics.fac@yu.edu.jo",
            contactPhone = "  027211111 (6800)\n" +
                    "  0096227211147\n" +
                    "Telephone : 027211111 ext. : 6605"
        ))
        departmentDao.insert(Department(
            name = "Public Administration",
            facultyOwnerId = 9,
            description = "The Department of Public Administration was established in 1982, and began to offer a Bachelor's program in Public Administration" +
                    " since its inception, and in 1993, the Department introduced a Master's Program in Public Administration. The department qualifies its " +
                    "students with theoretical knowledge and applied skills in the fields of public administration by focusing on the topics of public policy " +
                    "analysis, human resources development, administrative decision-making, organizational behavior, project management, government performance" +
                    " management, public finance and budgeting, and refining students' skills in the fields of scientific research at the bachelor's and master" +
                    "'s levels. The department has qualified and trained human cadres and graduates of the most prestigious American and European universities," +
                    " in addition to their qualitative expertise in the fields of management consulting and training provided to public and private sector " +
                    "organizations inside and outside the country.",
            headOfDepartment = "Dr. Anan Abu Hammour",
            locationInFaculty = "",
            contactEmail = " economics.fac@yu.edu.jo\n" +
                    "  Administration.dept@yu.edu.jo\n",
            contactPhone = "  027211111 (6800)\n" +
                    "  0096227211147\n" +
                    "\n" +
                    "Telephone : 027211111 ext. : 6846"
        ))
        departmentDao.insert(Department(
            name = "Finance & Banking Science",
            facultyOwnerId = 9,
            description = "The department was established in 1982, and started offering a bachelor's program in finance and banking since its establishment, and in 1999 the department offered a master's program in finance and banking.\n" +
                    "The department aims to qualify students theoretically and practically in various fields of knowledge that have to do with the field of financial and banking sciences, and the department contributes to providing consulting" +
                    " services to all sectors in the Jordanian society, and the department focuses on teaching and scientific research in the fields of financial and banking sciences, " +
                    "as well as developing study plans in line with the requirements of the labor market and keeping pace with global changes locally and internationally. " +
                    "The department also regularly holds scientific conferences and seminars to follow up on the latest issues and challenges facing the financial sector" +
                    " and the banking sector locally, regionally and globally, and the department operates a simulation room for the Amman Stock Exchange, in cooperation " +
                    "with the EGX management, in addition to a virtual currency exchange market (Forex), for the purposes of training and scientific research in the financial " +
                    "markets. and the United Nations Development Program (UNDP), and the department was ranked first in the Kingdom.",
            headOfDepartment = "Dr. Lara Mohamed Al-Haddad",
            locationInFaculty = "",
            contactEmail = " economics.fac@yu.edu.jo\n" +
                    "  Finance.dept@yu.edu.jo",
            contactPhone = "  027211111 (6800)\n" +
                    "  0096227211147\n" +
                    "Phone: 027211111 Ext: 6868"
        ))
        departmentDao.insert(Department(
            name = "Marketing",
            facultyOwnerId = 9,
            description = "\n" +
                    "The marketing department was established in 1997. The department has faculty members specialized in various fields of marketing such as: consumer behavior, marketing research, international marketing, and e-marketing.\n" +
                    "\n" +
                    "The department's teaching plan provides students with the basic concepts of marketing science and the role of marketing in the success of organizations in a globally competitive environment that acquires students analytical and communication skills that qualify them to be creative in the fields of product management, marketing research, and advertising.\n" +
                    "\n" +
                    "The mission of the department is to prepare and graduate students who have the ability to benefit the organizations in which they work by developing marketing problem-solving skills. The department works to adopt a modern teaching style that keeps pace with contemporary technological developments.\n" +
                    "\n" +
                    "The department currently serves more than 300 students in the Bachelor of Marketing program, and the department is looking forward to introducing a master's program in the near future.",
            headOfDepartment = "Dr. Hadeel Haddad",
            locationInFaculty = "",
            contactEmail = " economics.fac@yu.edu.jo\n" +
                    " Marketing.dept@yu.edu.jo",
            contactPhone = "  027211111 (6800)\n" +
                    "  0096227211147\n" +
                    "Telephone : 027211111 Ext. : 6745"
        ))
        departmentDao.insert(Department(
            name = "Accounting",
            facultyOwnerId = 9,
            description = "The Department of Accounting was established in 1982 and has been offering the Bachelor of Accounting program since its inception. In 1999, the department offered the Master of Accounting program within the thesis and comprehensive examination tracks.\n" +
                    "\n" +
                    "The department employs a group of faculty members who hold doctoral and master's degrees from prestigious and distinguished universities in various accounting disciplines. The department has a number of scholarships to obtain doctoral degrees in British and Australian universities.\n" +
                    "\n" +
                    "The department periodically reviews the study plans for the bachelor's and master's programs in order to prepare advanced study plans that meet the needs of the community and keep pace with the requirements of the dynamic labor market on the one hand, and enhance the competitiveness of the department's graduates in obtaining suitable job opportunities on the other hand.\n" +
                    "\n" +
                    "The department also holds many scientific conferences and actively participates in local, regional and international conferences.",
            headOfDepartment = "Dr. Salah Al-Sharman",
            locationInFaculty = "",
            contactEmail = " economics.fac@yu.edu.jo\n" +
                    "  Accounting.dept@yu.edu.jo",
            contactPhone = "  027211111 (6800)\n" +
                    "  0096227211147\n" +
                    "Telephone : 027211111 ext. : 6723"
        ))

        // أقسام كلية الشريعة (اللي الـ ID بتاعها 10)
        departmentDao.insert(Department(
            name = "Fiqh",
            facultyOwnerId = 10,
            description = "\n" +
                    "The department was established at the beginning of the academic year 1992/1993 under the name of Fiqh and Islamic Studies and its name was amended to the Department of Jurisprudence and its Principles by virtue of the decision of the Council of Deans No. (1/2001) dated 8/1/2001.\n" +
                    "\n" +
                    "The department currently offers a bachelor's degree in jurisprudence and its principles and a master's degree in jurisprudence, and the department is looking forward to establishing a master's and doctoral program in the principles of jurisprudence and comparative jurisprudence.\n" +
                    "\n" +
                    "He also conducts a scientific trip to the Holy Land during the Hajj season, applying the Fiqh of Worship course (2) of the compulsory courses in the department, in addition to the Umrah trip.\n" +
                    "\n" +
                    "The department, like the rest of the college's departments, contributes to the general activities of the college, the university and the local community, such as the revival of religious events in mosques, schools and clubs, Friday sermons and the scientific day of the college," +
                    " and participation in specialized seminars and courses, as well as is linked to cooperative academic relations with the corresponding departments in other universities, such as the exchange of visiting professors and the supervision and discussion of the scientific theses of graduate students," +
                    " which contributes to building bridges of cooperation and integration with the local and university community.",
            headOfDepartment = "Dr. Nepal Al-Otoum\n" +
                    "\n",
            locationInFaculty = "",
            contactEmail = "Fiqh.dept@yu.edu.jo",
            contactPhone = "Telephone : 00962 Ext. 27211111 : 5332\n"
        ))
        departmentDao.insert(Department(
            name = "Usul Addin ",
            facultyOwnerId = 10,
            description = "The department was established at the beginning of the academic year 1992/1993 by a decision of the Council of Deans to establish two academic departments in the college, thus the department received its old and new students who were admitted after 1992.\n" +
                    "\n" +
                    "The department grants a bachelor's degree in the fundamentals of religion, a master's degree in the fundamentals of religion, a comprehensive exam track, and a doctorate degree in philosophy in interpretation, Quranic sciences, and the noble hadith and its sciences.\n" +
                    "\n" +
                    "The department, like the rest of the college's departments, contributes to the general activities of the college, the university and the local community, such as reviving religious events in mosques, schools and clubs, Friday sermons and the scientific day of the college," +
                    " and participating in specialized seminars and courses, as well as cooperative academic relations with the corresponding departments in other universities, such as exchanging visiting professors and supervising and discussing the dissertations of graduate students," +
                    " which contributes to building bridges of cooperation and integration with the local and university community.\n" +
                    "\n" +
                    "The department includes under its wing the Holy Quran program, which supervises the process of teaching recitation, memorization and intonation, followed by recitation laboratories, and is currently planning to make the Holy Quran program the nucleus of the Quranic Readings Department in the future, hopefully Almighty.",
            headOfDepartment = "Prof. Dr. Abdulrazzaq Rajab\n" +
                    "\n",
            locationInFaculty = "",
            contactEmail = "Usul.dept@yu.edu.jo",
            contactPhone = " Telephone : 00962 27211111 Ext. : 5452\n" +
                    "\n"
        ))
        departmentDao.insert(Department(
            name = "Islamic Economics & Banking",
            facultyOwnerId = 10,
            description = "The Department of Economics and Islamic Banking was established by the Council of Deans' Resolution No. (1/2001) dated 8/1/2001." +
                    " To meet the need for specialists in Islamic economics and Islamic banks who combine knowledge in economics and Sharia sciences, " +
                    "especially after the growth of this science and the emergence of applied models of some of its issues and rulings," +
                    " and the increasing interest in it at the local, Islamic and global levels.\n" +
                    "\n" +
                    "As for postgraduate studies, the Department of Jurisprudence and Islamic Studies, and before it the Center for Islamic Studies, " +
                    "have been granting master's degrees in Islamic economics for more than ten years, but the current department has been granting master's degrees " +
                    "in economics and Islamic banking, and a doctorate degree in economics and Islamic banking, where the decision of the Board of Deans No. " +
                    "(31/2001) dated 27/8/2001 was issued to establish a doctoral program in Islamic economics and banking.\n" +
                    "\n" +
                    "It remains to be noted that the Department of Economics and Islamic Banking hosts the Sheikh Saleh Abdullah Kamel Chair for Islamic Economics." +
                    " The department aspires to attract a distinguished group of economists and Islamic banking experts in the coming years.",
            headOfDepartment = "Dr. Amjad Lataifa",
            locationInFaculty = "",
            contactEmail = "Islamiceco.dept@yu.edu.jo",
            contactPhone = "Telephone : 00962 Ext. 27211111 : 5512\n"
        ))
        departmentDao.insert(Department(
            name = "Islamic Studies",
            facultyOwnerId = 10,
            description = "The Department of Islamic Studies was established by the decision of the Council of Deans in its session No. 1/2000 on 8/1/2001 to include under its wings three specializations:\n" +
                    "\n" +
                    "First: Islamic Education Specialization.\n" +
                    "\n" +
                    "Second: Specialization in Da'wah and Islamic Media.\n" +
                    "\n" +
                    "Third: Family Studies Major.\n" +
                    "\n" +
                    "The opening of these new specializations came in response to the urgent need for them locally, Arably, and internationally, and in application of this, the department grants a bachelor's degree in Islamic studies in three tracks: Islamic Education, Family Studies, Da'wah and Islamic Media. He also awards master's and doctoral degrees in Islamic education.\n" +
                    "\n" +
                    "The department offers two courses within the university's elective requirements, namely the Family System in Islam course and the Basic Islamic Concepts course.",
            headOfDepartment = "Dr. Tasneem Al-Muhaidat",
            locationInFaculty = "",
            contactEmail = "Islamicstudies.dept@yu.edu.jo",
            contactPhone = "Telephone : 00962 27211111 Ext. : 5264"
        ))

        // أقسام كلية العلوم التربوية (اللي الـ ID بتاعها 11)
        departmentDao.insert((Department(
            name = "Curriculum and Instruction",
            facultyOwnerId = 11,
            description = "The Curriculum and Methods of Instruction Department began its work as one of the departments within the Faculty of Education at the start of the second semester of the 1991/1992 academic year. The department strives to achieve the following objectives:\n" +
                    "\n" +
                    "Preparing teachers for various educational stages.\n" +
                    "Conducting scientific research to enhance and advance the educational process.\n" +
                    "Serving the community by delivering lectures, holding seminars, and organizing workshops for the local community.\n" +
                    "Participating in the design and development of curricula for the Ministry of Education.\n" +
                    "The department, which comprises 51 faculty members, offers the following academic degrees:\n" +
                    "\n" +
                    "·       Bachelor’s degree in:\n" +
                    "\n" +
                    "Degree in Education/ Early Childhood Education.\n" +
                    "Degree in Education/Classroom teacher\n" +
                    "·       Diploma in:\n" +
                    "\n" +
                    "Teaching Methods of Arabic Language\n" +
                    "Teaching Methods of English Language\n" +
                    "Teaching Methods of Mathematics\n" +
                    "Teaching Methods of Science\n" +
                    "Teaching Methods of Social Studies\n" +
                    "·       Master’s degree in:\n" +
                    "\n" +
                    "Arabic Language Curricula and Teaching Methods\n" +
                    "English Language Curricula and Teaching Methods\n" +
                    "Mathematics Curricula and Teaching Methods\n" +
                    "Science Curricula and Teaching Methods\n" +
                    "Vocational Education Curricula and Teaching Methods\n" +
                    "Social Studies Curricula and Teaching Methods\n" +
                    "Educational Technology\n" +
                    "·       Ph.D. in:\n" +
                    "\n" +
                    "Social Studies Curricula and Teaching Methods\n" +
                    "Arabic Language Curricula and Teaching Methods\n" +
                    "English Language Curricula and Teaching Methods\n" +
                    "Science Curricula and Teaching Methods\n" +
                    "Mathematics Curricula and Teaching Methods",
            headOfDepartment = "Dr. Ali Al-Omari",
            locationInFaculty = "",
            contactEmail = "",
            contactPhone = "Phone: 0096227211111\n" +
                    "Extension: 3740"
        )))
        departmentDao.insert((Department(
            name = "Counseling and Ed.Psychology",
            facultyOwnerId = 11,
            description = "The department was established in the academic year 1991/1992 under the name of Educational Psychology.  In September 2006 the department name was changed to Counseling & Educational Psychology.\n" +
                    "\n" +
                    "The department has 35 faculty members, representing various academic ranks and majors, and (1035) undergraduate students. It houses a Counseling Laboratory where services for students and faculty members are available.\n" +
                    "\n" +
                    "The department offers the following academic programs:\n" +
                    "\n" +
                    "Bachelor degree in Counseling Psychology.\n" +
                    "Master degree in the fields of Educational Psychology, Counseling Psychology, Special Education, and Measurement and Evaluation.\n" +
                    "Ph.D. degree in the fields of Educational Psychology, Counseling Psychology, and Measurement and Evaluation.",
            headOfDepartment = "Dr. Aladdin Obeidat",
            locationInFaculty = "",
            contactEmail = "Psychology.dept@yu.edu.jo",
            contactPhone = "Phone : 0096227211111     Ext. : 3411"
        )))
        departmentDao.insert((Department(
            name = "Administration and Foundations",
            facultyOwnerId = 11,
            description = "The department was established in the academic year 1991/1992 with the aim of enhancing the qualifications of professionals in the educational field, including teachers, school principals, and educational supervisors at the Ministry of Education. The department encourages faculty members and students to conduct educational research related to administration, supervision, training, leadership, and quality assurance.\n" +
                    "\n" +
                    "The department provides services to the local community, including schools, educational institutes, and training centers, by offering administrative and supervisory consultations, particularly in school administration and educational supervision.\n" +
                    "\n" +
                    "The department’s 15 faculty members actively participate in various committees within the Directorates of Education in the Northern Region, focusing on teacher promotions and the professional development of supervisors and educators. They also conduct lectures, workshops, and seminars on the latest educational and technological advancements, particularly in educational, school, and classroom administration, as well as educational supervision.\n" +
                    "\n" +
                    "The department currently serves 555 students across the following programs:\n" +
                    "\n" +
                    "Diploma in School Administration, and a Professional Diploma in Modern School Administration in collaboration with INHOLLAND University of Applied Sciences in the Netherlands.\n" +
                    "Master’s degree in Foundations of Education, Educational Administration, and Educational Supervision.\n" +
                    "Doctor of Philosophy (PhD) in Foundations of Education and Educational Administration.",
            headOfDepartment = "Professor Omar Khassawneh",
            locationInFaculty = "",
            contactEmail = "",
            contactPhone = "Phone: +962 2 7211111 Ext.: 3714"
        )))


        // أقسام كلية التربية الرياضية (اللي الـ ID بتاعها 12)
        departmentDao.insert(Department(
            name = "Physical Education",
            facultyOwnerId = 12,
            description = "The department was established with the restructuring of the college's departments in the academic year 1995/1996, and on 10/7/2024," +
                    " it was approved to change the name of the Department of Physical Education to become the Department of Applied Physical Education and" +
                    " the introduction of the Bachelor of Applied Physical Education\n" +
                    "\n" +
                    "The Department of Applied Physical Education at Yarmouk University aims through a Bachelor's program in Applied Physical Education," +
                    " which includes theoretical and applied scientific courses that meet the needs of the labor market and keep pace with the scientific" +
                    " development in the world in this field, and this program consists of (69) practical hours that focus on the graduate's ability to work " +
                    "in clubs and gyms and covers all individual and team sports such as physical preparation, physical exercise, football, hand, basketball," +
                    " volleyball, swimming, gymnastics, athletics, racquet games, and field training It also consists of (66) theoretical hours focusing " +
                    "on sports training, psychology, sports sociology, teaching curricula and methods, learning, motor development, anatomy, physiology" +
                    " of physical activity, kinesiology, mechanics, management, measurement and evaluation in physical education and modified physical education.\n" +
                    "\n" +
                    "The number of teachers working in the department is (13) with the rank of professor, (4) with the rank of associate professor, " +
                    "(4) with the rank of assistant professor, (3) with the rank of teacher, and (1) with the rank of teaching assistant. " +
                    "The department offers a master's program in physical education with thesis and comprehensive tracks.",
            headOfDepartment = "Prof. Dr. Ahmed Salem Batayneh\n" +
                    ", Dean of the Faculty",
            locationInFaculty = "",
            contactEmail = "physicaledu.dept@yu.edu.jo",
            contactPhone = "\n" +
                    "Telephone : 027211111 Ext. : 2645"
        ))
        departmentDao.insert(Department(
            name = "Sport Science",
            facultyOwnerId = 12,
            description = "Theestablishment of the department with the restructuring of the college's departments in the academic year 1995/1996, and on 10/7/2024, it was approved to introduce a bachelor's degree in sports sciences.\n" +
                    "\n" +
                    "The Department of Sport Sciences at Yarmouk University, through a Bachelor of Science in Sport program that includes theoretical" +
                    " and practical scientific courses, seeks to meet the needs of the labor market and keep pace with the scientific development in the world" +
                    " in this field. This program consists of (93) theoretical hours covering all sciences related to and supporting sports sciences such as kinesiology," +
                    " biomechanics, physiology of physical exertion, athlete nutrition, sports rehabilitation, and sports marketing, and (42) practical hours focusing" +
                    " on the ability of the program graduate to work in gyms and sports clubs such as resistance training, aerobics, racquet games, and swimming.\n" +
                    "\n" +
                    "The number of teachers working in the department is (9) with the rank of professor, (4) with the rank of associate professor, (1) with the rank of assistant professor, (2) with the rank of teacher and (2) with the rank of teaching assistant. The department offers a master's program in sports sciences / specialization in movement sciences with thesis tracks and comprehensive exam.",
            headOfDepartment = "Prof. Dr. Ahmed Salem Batayneh\n" +
                    ", Dean of the Faculty",
            locationInFaculty = "",
            contactEmail = " Physicaledu.fac@yu.edu.jo",
            contactPhone = "Telephone : 027211111 ext. : 2656"
        ))


        // أقسام كلية الفنون الجميلة (اللي الـ ID بتاعها 13)
        departmentDao.insert(Department(
            name = "Visual Arts",
            facultyOwnerId = 13,
            description = "The Department of Fine Arts was established at Yarmouk University in 1981. The department awards a bachelor’s degree in plastic arts (BA) " +
                    "with its practical specializations such as painting and illustrations, plastic arts technology, and art education. " +
                    "The postgraduate program consists of (33) credit hours. The Department of Plastic Arts offers a master's degree (MA)" +
                    " in theoretical plastic arts, such as art criticism, art history, aesthetics, educational technology, media, art education, " +
                    "and contemporary issues in modern arts.\n" +
                    "\n" +
                    "\n" +
                    "The department includes about (13) faculty members of various academic ranks, and more than (200) students are enrolled in it.\n" +
                    "\n" +
                    "\n" +
                    "The department aims to teach art a fundamental technical and scientific approach to building a more beautiful, " +
                    "more refined, and optimal society. It also aims to qualify specialized and professional graduates in plastic arts who" +
                    " can take responsibility for spreading the message of plastic arts. The department establishment came as an urgent need to " +
                    "meet the needs of public and private professional and educational institutions to teach Fine arts with its artistic fields " +
                    "and as a way of life that contributes to society's development like other sciences and knowledge. The Plastic Arts Department at" +
                    " Yarmouk University looks forward to occupying the most appropriate and prominent place at the national and global levels in all" +
                    " its artistic specializations through continuous updating of its educational policies, programs, and curriculums to keep pace with the" +
                    " requirements of the modern artistic and technical era with awareness and comprehensiveness.",
            headOfDepartment = "Dr.Mohammed Musa",
            locationInFaculty = "",
            contactEmail = " Plastic.dept@yu.edu.jo\n" +
                    "E-mail : Finarts.fac@yu.edu.jo",
            contactPhone = "Phone : 0096227211111     Ext. : 3409"
        ))
        departmentDao.insert(Department(
            name = "Drama",
            facultyOwnerId = 13,
            description = "The Drama Department has contributed to the artistic movement's annual provision with distinguished staff and qualified graduates." +
                    " In addition to the faculty members' contributions with their artistic works in the fields of theater arts and the arts of cinema and " +
                    "television at various official and private institutions in Jordan and abroad through various festivals, seminars, and conferences." +
                    " The Department of Fine Arts at Yarmouk University was founded in 1981, and in 1994, this specialty was expanded to include the" +
                    " following subspecialties: theater acting and directing, film and television, criticism and theater literature, and theater" +
                    " craftsmanship. In 2001, the Drama Department was created as one of four departments affiliated with the College of Fine" +
                    " Arts and still includes the majors mentioned above with a new specialization, which is drama education. The department awards " +
                    "a bachelor's degree in drama, and it includes ten faculty members who hold academic and practical qualifications in drama " +
                    "disciplines. The number of students in the department for the academic year 2011/2012 is 162 students.\n" +
                    "\n" +
                    "With its various specializations, the department seeks to raise the level of academic and technical performance" +
                    " in line with modern intellectual aspects and technological progress to keep pace with the global level in these areas.",
            headOfDepartment = "Mr. Muhammad Al-Affan",
            locationInFaculty = "",
            contactEmail = " Drama.dept@yu.edu.jo\n" +
                    "E-mail : Finarts.fac@yu.edu.jo",
            contactPhone = "Phone : 0096227211111     Ext. : 3412"
        ))
        departmentDao.insert(Department(
            name = "Design",
            facultyOwnerId = 13,
            description = "Design education at the Yarmouk University goes back to the year 1980 when it was a new field in Jordan, where the major of the design" +
                    " was subsidiary of the Department of Fine Arts. Since its inception as the first Department of Fine Arts in Jordan, " +
                    "design disciplines attracted students from all over the Kingdom, with faculty members from Jordan and the Arab and foreign countries." +
                    " On the 17th of September 2001, design specialty became independent as its department, " +
                    "after its promotion to the level of a stand-alone academic department in the Faculty of Fine " +
                    "Arts named \"the Department of Design and Applied Arts\" and in 2011, the name was changed to " +
                    "become \"the Department of Design\" and a new plan of study was adopted to include four specialties i" +
                    "ncluding interior design, graphic design, industrial design, and fashion and textiles design." +
                    " The Department of Design grants a bachelor's degree in each of the four fields of design. Currently," +
                    " the Department of Design includes (13) faculty members of various academic ranks joined by around (380) students. " +
                    "The department aims to become recognized as a center of design in the region in teaching and research, and an effort " +
                    "continuously rises to the level of creativity and consulting compared to centers and institutes in the area of design " +
                    "and human creativity worldwide.",
            headOfDepartment = "Dr.Asem Obeidat",
            locationInFaculty = "",
            contactEmail = "E-mail : Finarts.fac@yu.edu.jo\n" +
                    "Design.dept@yu.edu.jo\n",
            contactPhone = "Phone : 0096227211111     Ext. : 3410"
        ))
        departmentDao.insert(Department(
            name = "Music",
            facultyOwnerId = 13,
            description = "Music education in Jordan developed accordingly to suit the modern revival in all aspects of modern life in Jordan society. The late few decades from the last century mark a turning point for Jordan society's attitude toward arts in general. Therefore, Yarmouk University was distinguished by being the pioneer that had Music among many Arts majors in the Fine Arts College since 1981. In the beginning, The Bachelor of Arts Degree was awarded as part of the Education and Arts Faculty. By the time of the Yarmouk University Jubilee celebration, in 2001-2002, the College of Fine Arts was constructed from four majors faculties: Music, Drama, Plastic Arts, and Design. The Music Department crowned their efforts by offering a Graduate Degree by the academic year 2004-2005.\n" +
                    "\n" +
                    "Music Department offers a Bachelor's Degree level and an MA Graduate level. In the BA program, the students required " +
                    "to accomplish (132 Credit Hours) qualified to play one orchestral instrument and or one traditional Arabic instrument" +
                    " as major and another instrument as minor, In addition to some theoretical and practical requirements. The average student's" +
                    " number in the Bachelor's program is about one hundred students and the graduate program about fifteen students." +
                    " The full-time faculty members are thirteen in the rank of Full, Associate, Assistant Professors, and instructors," +
                    " in addition to several full-timers are distinguished musicians from local and national, and international " +
                    "expertise in teaching musical instruments. The Music Department endeavors to promote music appreciation in Jordan Society" +
                    " by qualified academic graduates; more than four hundred so far, from our graduate, have been deployed onboard government schools, " +
                    "local or national bands. After all, the music department plays a significant role in representing Jordan in most local, national," +
                    " and international festivals, in addition to several musical activities held by our students and faculty members. ",
            headOfDepartment = "Dr.Yara Al Nemri",
            locationInFaculty = "",
            contactEmail = " Music.dept@yu.edu.jo\n" +
                    "E-mail : Finarts.fac@yu.edu.jo",
            contactPhone = "Phone : 0096227211111     Ext. : 3411\n"
        ))
        departmentDao.insert(Department(
            name = "Digital Arts",
            facultyOwnerId = 13,
            description = "The College of Fine Arts seeks to continue leadership and achieve quality and excellence through its academic programs" +
                    " to serve teaching, learning, and sustainable development of society. The College plays a pioneering " +
                    "role in confronting the challenges facing contemporary education, by creating new methods that suit students’ " +
                    "ambitions, labor market requirements, and community needs. The College seeks to To adapt and develop its programs" +
                    " in line with contemporary developments.\n" +
                    "\n" +
                    "Among the steps it has taken in this context is the proposal to create a digital arts program that includes " +
                    "two tracks (digital film and digital audio), which is considered the first of its kind in Jordan, " +
                    "and is considered unique in the Arab world.",
            headOfDepartment = "Dr.Amer AL Gharaibeh",
            locationInFaculty = "",
            contactEmail = "E-mail :  DigitalArts.dept@yu.edu.jo \n" +
                    "\n",
            contactPhone = "Phone : 0096227211111      Ext :2721"
        ))
        departmentDao.insert(Department(
            name = "Art Education",
            facultyOwnerId = 13,
            description = "The Department of Art Education at the Faculty of Fine Arts at Yarmouk University is one of the leading departments" +
                    " in the field of art education in Jordan. It aims to prepare and qualify specialized cadres in art education, " +
                    "possessing the academic and technical skills necessary to contribute to the development of art education and artistic culture in society." +
                    " The department offers an integrated study program that combines theoretical and applied aspects. Students are " +
                    "introduced to the foundations of art education and pedagogical theories, along with practical skills in various " +
                    "fields such as painting, sculpture, design, crafts, drama, music, and others. The department also seeks to develop " +
                    "students' creative and critical thinking and equip them with the skills that qualify them to teach in educational " +
                    "institutions or work in various art fields. The Department of Art Education works to achieve integration between " +
                    "academic education and practical practice by providing specialized laboratories and studios, in addition to" +
                    " workshops and art galleries that display student works. The department actively participates in local and " +
                    "international art activities, enhancing students' experiences and enabling them to interact with the wider art community.\n",
            headOfDepartment = "Mr.Abdel-Salam Al-Haddad",
            locationInFaculty = "",
            contactEmail = "E-mail : Finarts.fac@yu.edu.jo",
            contactPhone = "Phone : 027211111(2581)\n" +
                    "Fax : 027211112"
        ))

        // أقسام كلية الآثار (اللي الـ ID بتاعها 14)
        departmentDao.insert(Department(
            name = "Archaeology",
            facultyOwnerId = 14,
            description = "The department of Archaeology at the Faculty of Archeology and Anthropology was established in 1984." +
                    " It awards bachelor and master's degrees in archaeology. Archaeology is the study of the human past, in all " +
                    "its social and cultural diversity. The taught courses at the department deal with clarifying the development " +
                    "and principles of archaeology and its importance in the study of the region's history and ancient civilizations" +
                    " through material remains. Students learn to identify the ancient civilizations in the region, " +
                    "the characteristics of their archaeological remains, and the way these remains are dated, analyzed and studied." +
                    " Our teaching combines lectures, seminars, practical work, language classes, and lab experience. " +
                    "Fieldwork experience, for which departmental subsidies are available, is a vital element of the Archaeology course," +
                    " and there are many opportunities for students to join department-based research projects. The faculty members " +
                    "at the department conduct excavations and field projects in archaeological sites, which usually carried" +
                    " out in collaboration with foreign universities and institutions.",
            headOfDepartment = "Dr. Maher M. Tarboush / Head of Dept.",
            locationInFaculty = "",
            contactEmail = " Archaeology.dept@yu.edu.jo\n" +
                    "E-mail : archaeology.fac@yu.edu.jo",
            contactPhone = "Phone : 027211111     Ext. : 2931"
        ))
        departmentDao.insert(Department(
            name = "Anthropology",
            facultyOwnerId = 14,
            description = "The Department of Anthropology was established in 1984. The Department awards bachelor and master's degrees in anthropology." +
                    " The courses taught at the department are designed to provide students with theoretical and practical experience in the archaeological," +
                    " biological and social aspects of the discipline, which is concerned with the study of human and his culture. " +
                    "The department has specialized laboratories for the study and treatment of skeletal remains. It has conducted many" +
                    " studies related to the Jordanian society and its culture and participated in many research projects with national and international institutions.",
            headOfDepartment = "Dr. Ali Khawileh / chair of Dept.",
            locationInFaculty = "",
            contactEmail = "Anthropology.dept@yu.edu.jo\n" +
                    "E-mail : archaeology.fac@yu.edu.jo",
            contactPhone = "Phone : 027211111     Ext. : 4288"
        ))
        departmentDao.insert(Department(
            name = " Conservation and Management of Cultural Resources",
            facultyOwnerId = 14,
            description = "The Department of Conservation and Management of Cultural Resources at the Faculty of Archaeology and Anthropology was" +
                    " established in 1999, aiming at keeping pace with the ongoing development in the field of conservation of cultural heritage. " +
                    "The department offers a bachelor's program in Conservation and Management of Cultural Resources, and three master's programs:" +
                    " the Management of Cultural Resources, the Conservation of Cultural Heritage and Archaeometry." +
                    " In addition, the department organizes training programs that combine theoretical and practical aspects in these fields. " +
                    "The Department of Conservation and Management of Cultural Resources has managed to establish an extensive network " +
                    "of cooperation relationships with national and international institutions that share similar research and teaching interests",
            headOfDepartment = "Dr Hussein Sababha / Head of Dept.",
            locationInFaculty = "",
            contactEmail = "Cmcr.dept@yu.edu.jo\n" +
                    "E-mail : archaeology.fac@yu.edu.jo",
            contactPhone = "Phone : 027211111     Ext. : 4270"
        ))

        // أقسام كلية السياحة والفنادق (اللي الـ ID بتاعها 15)
        departmentDao.insert(Department(
            name = "Hotel Management",
            facultyOwnerId = 15,
            description = "Established in 2012 as an integral part of the Faculty of Tourism and Hotel Management,the Department of Hotel Management provides education and training for students who would like to work full-time in the hospitality business after graduation or continue their studies to earn a higher degree, providing many opportunities for students interested in working in this fastest growing business sector in the world.\n" +
                    "\n" +
                    "Our cutting-edge, innovative four- year curriculum offers a fine balance between academic knowledge  and practical application. It provides a broad coverage of multi-dimensional hospitality education including hospitality and restaurant management,  food production and service,  event management, catering , marketing and financial decision making in hospitality, just to name a few. \n" +
                    "The Department provides students with technology-rich computer laboratories and classrooms; state-of-the-art food production and service laboratory which gives students both front-of-the-house and back-of-the-house experience.\n" +
                    "\n" +
                    "We offer students a variety of opportunities to get involved in department activities and events building a sense of pride among them. These opportunities allow our students to practice while learning. Students may choose to study away at one of our exchange partner institutions. We will continue to develop more exciting industry and international opportunities for our students.\n" +
                    "We take pride in serving the educational needs of our students and fulfilling the industry needs through a solid network of relations with esteemed educational institutions and industry professionals. We are dedicated to furthering our pride with our vision and mission to develop leaders of next generation.",
            headOfDepartment = "Dr. Omar Mahmoud Hasoni Taha",
            locationInFaculty = "",
            contactEmail = "O.taha@yu.edu.jo\n" +
                    "hotel.dept@yu.edu.jo\n" +
                    "tourism.fac@yu.edu.jo",
            contactPhone = "027211111  (2863 / 2862)\n" +
                    "0096227211153 / 3953\n" +
                    "Phone : 027211111     Ext. : 3076"
        ))
        departmentDao.insert(Department(
            name = "Travel & Tourism",
            facultyOwnerId = 15,
            description = "The department of Travel & Tourism has been established in the academic year 2011-2012 within the faculty of Tourism and Hotel Management.  The department offers two academic programs. Bachelor in Tourism Management and Masters in Tourism. \n" +
                    "\n" +
                    "In accordance with the new vision and mission of the faculty of Tourism and Hotel Management; the Department of Tourism and Travel is fully" +
                    " aware of the fast development around us; therefore it works to revise and design its plans to meet the tourism labor market demands" +
                    " for skills and professionals.\n",
            headOfDepartment = "",
            locationInFaculty = "",
            contactEmail = "tourism.fac@yu.edu.jo\n" +
                    "sawsan.k@yu.edu.jo ",
            contactPhone = "027211111  (2863 / 2862)\n" +
                    "0096227211153 / 3953\n" +
                    "Phone : 027211111     Ext. : 3038"
        ))

        // أقسام كلية الإعلام (اللي الـ ID بتاعها 16)
        departmentDao.insert(Department(
            name = "Journalism and Digital Media",
            facultyOwnerId = 16,
            description = "Department of journalism and Digital Media was established in the first semester of the academic year 2008/2009. It was one of three departments forming the faculty of Mass Communication. The faculty was officially announced by His Majesty King Abdullah II in April 2008 during a Royal visit to Yarmouk University. The care and attention given by his majesty to the newborn faculty reflect the importance of Journalism and Media education in building Jordanian society. \n" +
                    "\n" +
                    "The department’s curriculum which was recently prepared is well-designed, intellectually demanding and relevant. The components of the new curriculum focused on the needs of the local and regional market. It is well aware of the importance of practical training and experience which was reflected in the curriculum. \n" +
                    "The school continues to issue its own newspaper “Sahfat Al Yarmouk”, which was originally designed for practical and training purposes. It will be issued weekly and would function as a laboratory for students to gain their writing and professional experience. \n" +
                    "The department has an editing and production laboratory which contains 30 computers supported by the most up to date software related to students work.\n" +
                    "The faculty of information cooperates through different agreements with Jordanian media institutions. Our school implement such agreements in the best interest of our graduates and other institutions.\n" +
                    "Our staffs have a wide range of qualifications and special interests. Many have very extensive academic and professional experience. They have national and regional status as experts in their fields.",
            headOfDepartment = "Dr. Ismat Haddad",
            locationInFaculty = "",
            contactEmail = "Journal.dept@yu.edu.j\n" +
                    "E-mail : mass.fac@yu.edu.jo",
            contactPhone = "Phone : 027211111     Ext. : 6943\n" +
                    "Phone : 027211111 (6900)\n" +
                    "\n" +
                    "Fax : 0096227211148"
        ))
        departmentDao.insert(Department(
            name = "Radio and Television",
            facultyOwnerId = 16,
            description = "The Department of R & TV started as an independent entity since the establishment" +
                    " of the Faculty of Mass communication in August 2008. However, the faculty was created as an expansion to the already existing Department of Journalism and Mass Communication which was originally established in 1980.\n" +
                    "The department aims to prepare its students to occupy major and available positions in audio-visual " +
                    "professions to enable them to convey media massages with high ethical standards. It also aims to equip students with practical skills.\n" +
                    "Since 1980 and to this day the department provides a hands-on skill oriented education. From the first " +
                    "graduation class in 1984, it was apparent that the concept would be successful as, one by one; graduates" +
                    " became employed as on-air radio announcers locally and at the regional level. It was also evident that " +
                    "there was an urgent need for trained personnel.\n" +
                    "To meet this demand, a new curriculum was approved and would be implemented from the beginning of the" +
                    " first semester of 2008. Through the years, the department has refined and improved its program to be" +
                    " consistent with current trends, but the basic philosophy of small class size, individual attention " +
                    "and a caring professional staff remains a major priority and, as with our first graduate in 1984, graduates of" +
                    " today are continuing to find success in the field of Radio and Television broadcasting.\n" +
                    "The department employs a number of well-qualified lecturers from different backgrounds. Amongst the department’s" +
                    " facilities, where students carry out their training, are the following:\n" +
                    "\n" +
                    "Studio Production, which includes digital camera operations, editing, script writing, performance and Electronic News Production.\n" +
                    "Field Production, which involves Electronic Field Production and Electronic News Production.\n" +
                    "Radio, which involves learning skills of radio production, reporting, editing, script writing, recording, producing ROSRs and wraparounds.\n" +
                    "\n" +
                    "Radio and Television students are trained in the studios of the department which consist of a modern studio provided with " +
                    "lighting systems and a radio studio. There is also a digital studio supported by 3 cameras and 5 digital montage units and " +
                    "all other resources needed to support the television studio. These studios and resources enable students to produce TV programs" +
                    " and broadcast through the closed TV circuit.",
            headOfDepartment = "Dr. Mohammed Habes",
            locationInFaculty = "",
            contactEmail = "E-mail : mass.fac@yu.edu.jo\n" +
                    "Radiotv.dept@yu.edu.jo\n",
            contactPhone = "Phone : 027211111 (6900)\n" +
                    "\n" +
                    "Fax : 0096227211148\n" +
                    "Phone : 027211111     Ext. : 6939\n"
        ))
        departmentDao.insert(Department(
            name = "Public Relations and Advertising",
            facultyOwnerId = 16,
            description = "The field of public relations and advertising has been taught at Yarmouk University since 1980 as one of the three majors" +
                    " offered by the Department of Journalism and Mass Communication. Responding to the growing need and recognition of the important" +
                    " role of mass communication in Jordan and worldwide, the Department has become faculty of Mass communication in 2008. Therefore," +
                    " the three majors have become three departments. One of them is the Department of Public Relations and Adverting. \n" +
                    "\n" +
                    "The Department aims to prepare its students for entry into workplace with a thorough background in public relations: " +
                    "its objectives, functions, process, implementation, and the factors affecting its evolution. The department is also " +
                    "committed itself to providing professional experiences and well-designed training courses in advertising and on how to " +
                    "apply it in both marketing and promotion. \n" +
                    "To achieve such objectives, the Department has developed an ambitious curriculum benefited from others' experiences in " +
                    "this field. This curriculum is well-designed and planned to providing students with an educational environment equipped " +
                    "with systematic training courses in both public relations and advertising.",
            headOfDepartment = " Dr. Dr. Farhan  Al olaimat",
            locationInFaculty = "",
            contactEmail = "E-mail : mass.fac@yu.edu.jo\n" +
                    " Relation.dept@yu.edu.jo",
            contactPhone = "Phone : 027211111 (6900)\n" +
                    "\n" +
                    "Fax : 0096227211148\n" +
                    "Phone : 027211111     Ext. : 6940\n"
        ))


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

//        courseDao.insertAll(listOf(
//            Course(name = "Physics I", code = "PHY101", creditHours = 3, departmentOwnerId = 1),
//            Course(name = "Modern Physics", code = "PHY202", creditHours = 3, departmentOwnerId = 1)
//        ))
//
//        // دكاترة قسم الفيزياء
//        professorDao.insertAll(listOf(
//            Professor(name = "Dr. Ahmed Ali", title = "Professor", departmentOwnerId = 1),
//            Professor(name = "Dr. Fatima Saleh", title = "Assistant Professor", departmentOwnerId = 1)
//        ))
//
//        // مواد قسم الهندسة المدنية (اللي الـ departmentOwnerId بتاعه ممكن يكون 4 مثلاً)
//        courseDao.insertAll(listOf(
//            Course(name = "Statics", code = "CE201", creditHours = 3, departmentOwnerId = 4),
//            Course(name = "Fluid Mechanics", code = "CE305", creditHours = 3, departmentOwnerId = 4)
//        ))
    }
}