package com.amandarezende.cronogramacapilar.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.amandarezende.cronogramacapilar.data.DataBaseDao
import com.amandarezende.cronogramacapilar.presentation.telas.AtivosScreen
import com.amandarezende.cronogramacapilar.presentation.telas.CabeloScreen
import com.amandarezende.cronogramacapilar.presentation.telas.CronogramaScreen
import com.amandarezende.cronogramacapilar.presentation.telas.EtapaScreen
import com.amandarezende.cronogramacapilar.presentation.telas.HomeScreen
import com.amandarezende.cronogramacapilar.presentation.telas.NotificacaoScreen
import com.amandarezende.cronogramacapilar.presentation.telas.PerfilScreen
import com.amandarezende.cronogramacapilar.presentation.telas.ProdutosScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                route = "cronocapilar",
                startDestination = "cronocapilar/home"
            ) {
                composable("cronocapilar/home") {
                    HomeScreen(
                        navController = navController,
                        viewModel = hiltViewModel()
                    )
                }
                composable("cronocapilar/perfil") {
                    PerfilScreen(
                        navController = navController,
                        viewModel = hiltViewModel()
                    )
                }
                composable("cronocapilar/etapa") {
                    EtapaScreen(navController = navController,
                        viewModel = hiltViewModel()
                    )
                }
                composable("cronocapilar/cabelo") {
                    CabeloScreen(navController = navController,
                        viewModel = hiltViewModel()
                    )
                }
                composable("cronocapilar/cronograma") {
                    CronogramaScreen(navController = navController,
                        viewModel = hiltViewModel()
                    )
                }
                composable("cronocapilar/notificacao") {
                    NotificacaoScreen(navController = navController,
                        viewModel = hiltViewModel()
                    )
                }
                composable("cronocapilar/ativos") {
                    AtivosScreen(
                        navController = navController,
                        viewModel = hiltViewModel()
                    )
                }
                composable("cronocapilar/produtos") {
                    ProdutosScreen(
                        navController = navController,
                        viewModel = hiltViewModel()
                    )
                }
            }
        }
    }
}