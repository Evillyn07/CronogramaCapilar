package com.amandarezende.cronogramacapilar.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amandarezende.cronogramacapilar.data.Ativos
import com.amandarezende.cronogramacapilar.data.DataBaseDao
import com.amandarezende.cronogramacapilar.data.Produto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProdutoViewModel @Inject constructor(
    private val dao: DataBaseDao
): ViewModel(){
    val recomendacaoEtapa = MutableStateFlow<Map<String, List<Produto?>>>(mapOf())

    fun setup() = viewModelScope.launch {
        val produto = dao.loadProduto().groupBy { it.etapa }
        recomendacaoEtapa.value = produto
    }
}
