package com.amandarezende.cronogramacapilar.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cabelo")
data class Cabelo(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var tipoCabelo: String = "",
    var tipoFio: String = "",
    var quimica: String = ""
)

