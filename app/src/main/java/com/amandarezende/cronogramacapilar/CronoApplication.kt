package com.amandarezende.cronogramacapilar

import android.app.Application
import com.amandarezende.cronogramacapilar.data.Cronograma
import com.amandarezende.cronogramacapilar.data.DataBaseDao
import com.amandarezende.cronogramacapilar.data.Etapa
import com.amandarezende.cronogramacapilar.data.Perfil
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class CronoApplication : Application() {
    @Inject lateinit var dao: DataBaseDao

    override fun onCreate() {
        super.onCreate()
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertPerfil(Perfil(
                id = 1,
                nome = "Ana",
                email = "ana@gmail.com",
                senha = "aninha92",
                peso = "54kg",
                idCabelo = null
            ))
//            dao.insertCronograma(Cronograma(
//                id = 1,
//                idPerfil = 1,
//                dias = "segunda",
//                objetivos = "hidratar",
//                segunda = true,
//                terca = false,
//                quarta = false,
//                quinta = false,
//                sexta = false,
//                sabado = false,
//                domingo = false
//
//            ))
//            dao.insertEtapa(Etapa(
//                id = 1,
//                nome = "hidratacao",
//                diaMes = 29,
//                idCronograma = 1
//            ))
        }

    }
}