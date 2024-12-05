package com.amandarezende.cronogramacapilar.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amandarezende.cronogramacapilar.data.DataBaseDao
import com.amandarezende.cronogramacapilar.presentation.viewmodel.HomeViewModel.TipoCabelo.INDEFINIDO
import com.amandarezende.cronogramacapilar.presentation.viewmodel.HomeViewModel.TipoCabelo.MUITO_DANIFICADO
import com.amandarezende.cronogramacapilar.presentation.viewmodel.HomeViewModel.TipoCabelo.POUCO_DANIFICADO
import com.amandarezende.cronogramacapilar.presentation.viewmodel.HomeViewModel.TipoCabelo.SAUDAVEL
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dao: DataBaseDao
) : ViewModel() {

    val tipoCabelo = MutableStateFlow(INDEFINIDO)

    fun setup() = viewModelScope.launch {
        val usuario = dao.loadPerfil().firstOrNull()
        usuario?.let {
            val cabelo = dao.loadCabeloById(it.idCabelo ?: 1)
            val tipoCronograma = when {
                cabelo == null -> INDEFINIDO
                cabelo.tipoCabelo == "Secos"
                        && cabelo.tipoFio == "Frágeis"
                        && cabelo.quimica == "SIM" -> MUITO_DANIFICADO

                cabelo.tipoFio == "Porosos" || cabelo.tipoFio == "Frágeis" -> POUCO_DANIFICADO


                else -> SAUDAVEL
            }
            tipoCabelo.value = tipoCronograma
        }
    }

    enum class TipoCabelo {
        MUITO_DANIFICADO, POUCO_DANIFICADO, SAUDAVEL, INDEFINIDO
    }
}
