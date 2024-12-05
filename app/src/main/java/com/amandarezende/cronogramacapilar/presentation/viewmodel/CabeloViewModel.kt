package com.amandarezende.cronogramacapilar.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amandarezende.cronogramacapilar.data.Cabelo
import com.amandarezende.cronogramacapilar.data.DataBaseDao
import com.amandarezende.cronogramacapilar.data.Perfil
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CabeloViewModel @Inject constructor(
    @ApplicationContext context: Context,
    private val dao: DataBaseDao
) : AndroidViewModel(context as Application) {

    private lateinit var meuCabelo: Cabelo
    var tipoCabelo = MutableStateFlow("")
    var tipoFio = MutableStateFlow("")
    var quimica = MutableStateFlow("")

    fun setup() = viewModelScope.launch {
        meuCabelo = dao.loadCabelo().firstOrNull() ?: Cabelo(id = 1)
        tipoCabelo.value = meuCabelo.tipoCabelo
        tipoFio.value = meuCabelo.tipoFio
        quimica.value = meuCabelo.quimica
    }

    fun inserirCabelo() {
        meuCabelo = meuCabelo.copy(
            id = 1,
            tipoCabelo = tipoCabelo.value,
            tipoFio = tipoFio.value,
            quimica = quimica.value
        )

        viewModelScope.launch {
            dao.insertCabelo(meuCabelo)
            val perfil = dao.loadPerfil().firstOrNull()
            perfil?.idCabelo = meuCabelo.id
            perfil?.let { dao.updatePerfil(it) }

            Toast.makeText(getApplication(), "Salvo com sucesso", Toast.LENGTH_SHORT).show()
        }
    }
}
