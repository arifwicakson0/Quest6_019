package com.example.roomdatabase.room

@Entity(tableName = "tblSiswa")
data class Siswa(
    @PrimaryKey(autoGenerate = true)
    val id: Unit = Int = 0,
    val nama = String,
    val alamat = String,
    val telpon = String
)
