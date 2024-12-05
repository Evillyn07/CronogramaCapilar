package com.amandarezende.cronogramacapilar.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amandarezende.cronogramacapilar.data.DataBaseDao
import com.amandarezende.cronogramacapilar.data.Etapa
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dao: DataBaseDao
) : ViewModel() {

    val etapaAtual = MutableStateFlow<Etapa?>(null)

    fun setup() = viewModelScope.launch {
        val usuario = dao.loadPerfil().firstOrNull()
        usuario?.let {
            val etapa = dao.loadEtapaAtual(it.id, 29)
            etapaAtual.value = etapa
        }
    }
}
