package com.amandarezende.cronogramacapilar.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Etapa",
        foreignKeys = [
    androidx.room.ForeignKey(
        entity = com.amandarezende.cronogramacapilar.data.Cronograma::class,
        parentColumns = ["id"],
        childColumns = ["idCronograma"]
    )
]
)
data class Etapa(
    @PrimaryKey val id: Int,
    var nome: String,
    var diaMes: String,
    val idCronograma: Int

)
