package com.amandarezende.cronogramacapilar.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cronograma")
data class Cronograma(
    @PrimaryKey val id: Int,
    var dias: String,
    var objetivos: String,
    var segunda: Boolean,
    var terca: Boolean,
    var quarta: Boolean,
    var quinta: Boolean,
    var sexta: Boolean,
    var sabado: Boolean,
    var domingo: Boolean
)
