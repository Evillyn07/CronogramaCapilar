package com.amandarezende.cronogramacapilar.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Cronograma",
    foreignKeys = [
        ForeignKey(
            entity = Perfil::class,
            parentColumns = ["id"],
            childColumns = ["idPerfil"]
        )
    ]
)
data class Cronograma(
    @PrimaryKey val id: Int,
    val idPerfil: Int,
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
