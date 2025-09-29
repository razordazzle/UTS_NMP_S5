package com.example.uts_nmp

data class Student(
    val nrp: String,
    val nama: String,
    val jurusan: String,
    val deskripsi: String,
    val foto: String,
)

private val students = listOf(
        Student(
            nrp = "160422001",
            nama = "Aditya Pratama",
            jurusan = "Teknik Informatika",
            deskripsi = "Memiliki minat pada pengembangan AI dan machine learning.",
            foto = "adityapratama.jpg"

        ),
        Student(
            nrp = "160422015",
            nama = "Citra Kirana",
            jurusan = "Sistem Informasi",
            deskripsi = "",
            foto = "citrakirana.jpg"
        ),
        Student(
            nrp = "160422032",
            nama = "Bagus Santoso",
            jurusan = "Desain Komunikasi Visual",
            deskripsi = "Ketua UKM Fotografi 'Lensa Kreatif'.",
            foto = "bagussantoso.jpg"
        ),
        Student(
            nrp = "160422045",
            nama = "Rina Maulina",
            jurusan = "Manajemen Bisnis",
            deskripsi = "Pernah magang di bagian marketing digital.",
            foto = "rinamaulina.jpg"
        )
    )

    fun getStudents(): List<Student> {
        return students
    }
