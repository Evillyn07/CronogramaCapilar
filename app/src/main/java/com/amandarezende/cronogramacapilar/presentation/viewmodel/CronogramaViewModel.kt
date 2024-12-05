package com.amandarezende.cronogramacapilar.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.amandarezende.cronogramacapilar.data.Cronograma
import com.amandarezende.cronogramacapilar.data.DataBaseDao
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CronogramaViewModel @Inject constructor(
    @ApplicationContext  context: Context,
    private val dao: DataBaseDao
) : AndroidViewModel(context as Application) {

    private lateinit var cronograma: Cronograma

    val objetivos = MutableStateFlow("")
    var domingo = MutableStateFlow(false)
    var segunda = MutableStateFlow(false)
    var terca = MutableStateFlow(false)
    var quarta = MutableStateFlow(false)
    var quinta = MutableStateFlow(false)
    var sexta = MutableStateFlow(false)
    var sabado = MutableStateFlow(false)

    var maciez = MutableStateFlow(false)
    var brilho = MutableStateFlow(false)
    var reduzirFrizz = MutableStateFlow(false)
    var reporMassa = MutableStateFlow(false)
    var crescimento = MutableStateFlow(false)
    var reduzirOleosidade = MutableStateFlow(false)
    var manterHidratacao = MutableStateFlow(false)


    fun setup() = viewModelScope.launch {
        cronograma = dao.loadCronograma().firstOrNull() ?: Cronograma(
            idPerfil = 1,
            objetivos = ""
        )

        domingo.value = cronograma.domingo
        segunda.value = cronograma.segunda
        terca.value = cronograma.terca
        quarta.value = cronograma.quarta
        quinta.value = cronograma.quinta
        sexta.value = cronograma.sexta
        sabado.value = cronograma.sabado

        maciez.value = cronograma.maciez
        brilho.value = cronograma.brilho
        reduzirFrizz.value = cronograma.reduzirFrizz
        reporMassa.value = cronograma.reporMassa
        crescimento.value = cronograma.crescimento
        reduzirOleosidade.value = cronograma.reduzirOleosidade
        manterHidratacao.value = cronograma.manterHidratacao
    }

    fun inserirCronograma() {
        cronograma.let {
            it.domingo = domingo.value
            it.segunda = segunda.value
            it.terca = terca.value
            it.quarta = quarta.value
            it.quinta = quinta.value
            it.sexta = sexta.value
            it.sabado = sabado.value

            it.maciez = maciez.value
            it.brilho = brilho.value
            it.reduzirFrizz = reduzirFrizz.value
            it.reporMassa = reporMassa.value
            it.crescimento = crescimento.value
            it.reduzirOleosidade = reduzirOleosidade.value
            it.manterHidratacao = manterHidratacao.value
        }

        viewModelScope.launch {
            dao.insertCronograma(cronograma)
            Toast.makeText(getApplication(), "Salvo com sucesso", Toast.LENGTH_SHORT).show()
        }
    }

    fun resetarValores() {
        domingo.value = false
        segunda.value = false
        terca.value = false
        quarta.value = false
        quinta.value = false
        sexta.value = false
        sabado.value = false

        maciez.value = false
        brilho.value = false
        reduzirFrizz.value = false
        reporMassa.value = false
        crescimento.value = false
        reduzirOleosidade.value = false
        manterHidratacao.value = false

        inserirCronograma()
    }
}
