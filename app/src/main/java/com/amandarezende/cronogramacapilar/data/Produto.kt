package com.amandarezende.cronogramacapilar.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Produto")
data class Produto(
    @PrimaryKey val id: Int,
    var nome: String,
    var marca: String,
    var etapa: String
)
