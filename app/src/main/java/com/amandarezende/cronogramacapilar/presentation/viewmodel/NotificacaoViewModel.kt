package com.amandarezende.cronogramacapilar.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.amandarezende.cronogramacapilar.data.DataBaseDao
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotificacaoViewModel @Inject constructor(
    private val dao: DataBaseDao
): ViewModel() {

}