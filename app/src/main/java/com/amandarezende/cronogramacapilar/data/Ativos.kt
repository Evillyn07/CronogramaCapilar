package com.amandarezende.cronogramacapilar.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Ativos")
data class Ativos(
    @PrimaryKey val id: Int,
    var nome: String,
    var recomendacao: String
)
