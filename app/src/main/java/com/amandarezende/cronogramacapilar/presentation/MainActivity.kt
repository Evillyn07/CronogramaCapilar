package com.amandarezende.cronogramacapilar.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.amandarezende.cronogramacapilar.data.DataBaseDao
import com.amandarezende.cronogramacapilar.telas.AtivosScreen
import com.amandarezende.cronogramacapilar.telas.CabeloScreen
import com.amandarezende.cronogramacapilar.telas.CronogramaScreen
import com.amandarezende.cronogramacapilar.telas.EtapaScreen
import com.amandarezende.cronogramacapilar.telas.HomeScreen
import com.amandarezende.cronogramacapilar.telas.NotificacaoScreen
import com.amandarezende.cronogramacapilar.telas.PerfilScreen
import com.amandarezende.cronogramacapilar.telas.ProdutosScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var dao: DataBaseDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "profile") {
                composable("home") {
                    HomeScreen(navController = navController)
                }
                composable("perfil") {
                    PerfilScreen(navController = navController)
                }
                composable("etapa") {
                    EtapaScreen(navController = navController)
                }
                composable("cabelo") {
                    CabeloScreen(navController = navController)
                }
                composable("cronograma") {
                    CronogramaScreen(navController = navController)
                }
                composable("notificacao") {
                    NotificacaoScreen(navController = navController)
                }
                composable("ativos") {
                    AtivosScreen(navController = navController)
                }
                composable("produtos") {
                    ProdutosScreen(navController = navController)
                }
            }
        }
    }
}