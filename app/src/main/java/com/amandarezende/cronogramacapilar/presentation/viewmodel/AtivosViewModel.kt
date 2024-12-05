package com.amandarezende.cronogramacapilar.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amandarezende.cronogramacapilar.data.Ativos
import com.amandarezende.cronogramacapilar.data.DataBaseDao
import com.amandarezende.cronogramacapilar.data.Etapa
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AtivosViewModel @Inject constructor(
private val dao: DataBaseDao
): ViewModel() {
    val recomendacaoAtivos = MutableStateFlow<Map<String, List<Ativos?>>>(mapOf())

    fun setup() = viewModelScope.launch {
        val ativos = dao.loadAtivos().groupBy { it.recomendacao }
        recomendacaoAtivos.value = ativos
    }
}

//[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
//
//        list.groupBy{ it > 4 }
//
//map {
//    (nutricao, [1, 2, 3, 4],)
//    (hidratacao, [5, 6, 7, 8, 9, 10])
//}