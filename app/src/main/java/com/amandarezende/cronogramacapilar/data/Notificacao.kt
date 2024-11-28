package com.amandarezende.cronogramacapilar.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "Notificacao",
    foreignKeys = [
        ForeignKey(
            entity = Perfil::class,
            parentColumns = ["id"],
            childColumns = ["idPerfil"]
        ),
        ForeignKey(
            entity = Etapa::class,
            parentColumns = ["id"],
            childColumns = ["idEtapa"]
        )
    ]
)
data class Notificacao(
    @PrimaryKey val id: Int,
    var dia: String,
    var hora: String,
    var mensagem: String,
    val idPerfil: Int,
    val idEtapa: Int
)
