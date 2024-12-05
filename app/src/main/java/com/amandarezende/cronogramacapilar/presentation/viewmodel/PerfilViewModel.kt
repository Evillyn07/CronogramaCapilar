package com.amandarezende.cronogramacapilar.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amandarezende.cronogramacapilar.data.DataBaseDao
import com.amandarezende.cronogramacapilar.data.Etapa
import com.amandarezende.cronogramacapilar.data.Perfil
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PerfilViewModel @Inject constructor(
    @ApplicationContext  context: Context,
    private val dao: DataBaseDao
) : AndroidViewModel(context as Application) {
    private var meuPerfil: Perfil? = null
    val nome = MutableStateFlow("")
    val email = MutableStateFlow("")
    val peso = MutableStateFlow("")

    fun setup() = viewModelScope.launch {
        meuPerfil = dao.loadPerfil().first()
        nome.value = meuPerfil?.nome.orEmpty()
        email.value = meuPerfil?.email.orEmpty()
        peso.value = meuPerfil?.peso.orEmpty()
    }

    fun inserirPerfil() {
        val perfilAtualizado = meuPerfil?.copy(
            nome = nome.value,
            email = email.value,
            peso = peso.value
        ) ?: Perfil(
            id = 1,
            nome = nome.value,
            email = email.value,
            peso = peso.value,
            senha = "",
            idCabelo = null
        )

        viewModelScope.launch {
            dao.insertPerfil(perfilAtualizado)
            Toast.makeText(getApplication(), "Salvo com sucesso", Toast.LENGTH_SHORT).show()
        }
    }
}