package com.amandarezende.cronogramacapilar.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Perfil",
    foreignKeys = [
        ForeignKey(
            entity = Cabelo::class,
            parentColumns = ["id"],
            childColumns = ["idCabelo"]
        )
    ]
)
data class Perfil(
    @PrimaryKey val id: Int,
    var nome: String,
    var email: String,
    var senha: String,
    var peso: String,
    var idCabelo: Int
)
