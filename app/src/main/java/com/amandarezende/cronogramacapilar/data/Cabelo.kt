package com.amandarezende.cronogramacapilar.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cabelo")
data class Cabelo(
    @PrimaryKey val id: Int,
    var tipoCabelo: String,
    var tipoFio: String,
    var quimica: Boolean
)
