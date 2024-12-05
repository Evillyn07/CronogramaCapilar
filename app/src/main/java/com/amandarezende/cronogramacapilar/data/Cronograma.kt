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
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val idPerfil: Int,
    var objetivos: String,
    var domingo: Boolean = false,
    var segunda: Boolean = false,
    var terca: Boolean = false,
    var quarta: Boolean = false,
    var quinta: Boolean = false,
    var sexta: Boolean = false,
    var sabado: Boolean = false,

    var maciez: Boolean = false,
    var brilho: Boolean = false,
    var reduzirFrizz: Boolean = false,
    var reporMassa: Boolean = false,
    var crescimento: Boolean = false,
    var reduzirOleosidade: Boolean = false,
    var manterHidratacao: Boolean = false,
) {
    fun getValorDiaPorIndice(indice: Int): Boolean = when (indice) {
        0 -> domingo
        1 -> segunda
        2 -> terca
        3 -> quarta
        4 -> quinta
        5 -> sexta
        6 -> sabado
        else -> false
    }

    fun getValorObjetivoPorIndice(indice: Int) = when (indice) {
        0 -> maciez
        1 -> brilho
        2 -> reduzirFrizz
        3 -> reporMassa
        4 -> crescimento
        5 -> reduzirOleosidade
        6 -> manterHidratacao
        else -> false
    }

    fun atualizarDiaPorIndice(indice: Int, valor: Boolean) {
        if (indice < 0 || indice > 6) return

        when (indice) {
            0 -> domingo = valor
            1 -> segunda = valor
            2 -> terca = valor
            3 -> quarta = valor
            4 -> quinta = valor
            5 -> sexta = valor
            6 -> sabado = valor
            else -> Unit
        }
    }

    fun atualizarObjetivoPorIndice(indice: Int, valor: Boolean) {
        if (indice < 0 || indice > 6) return

        when (indice) {
            0 -> maciez = valor
            1 -> brilho = valor
            2 -> reduzirFrizz = valor
            3 -> reporMassa = valor
            4 -> crescimento = valor
            5 -> reduzirOleosidade = valor
            6 -> manterHidratacao = valor
            else -> Unit
        }
    }
}
