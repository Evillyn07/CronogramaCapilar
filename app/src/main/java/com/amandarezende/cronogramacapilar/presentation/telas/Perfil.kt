package com.amandarezende.cronogramacapilar.presentation.telas

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.amandarezende.cronogramacapilar.CronoApplication
import com.amandarezende.cronogramacapilar.data.DataBaseDao
import com.amandarezende.cronogramacapilar.presentation.MainActivity
import com.amandarezende.cronogramacapilar.presentation.viewmodel.CronogramaViewModel
import com.amandarezende.cronogramacapilar.presentation.viewmodel.PerfilViewModel

@Composable
fun PerfilScreen(
    navController: NavController,
    viewModel: PerfilViewModel
)
{
    val nome = viewModel.nome.collectAsState()
    val email = viewModel.email.collectAsState()
    val peso = viewModel.peso.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.setup()
    }

    val modifier = Modifier.height(8.dp)

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(align = Alignment.Top),
            verticalArrangement = Arrangement.Top
        ) {
            TextField(
                value = nome.value,
                onValueChange = { viewModel.nome.value = it },
                label = { Text("Nome") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = modifier)
            TextField(
                value = email.value,
                onValueChange = { viewModel.email.value = it },
                label = { Text("E-mail") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = modifier)
            TextField(
                value = peso.value,
                onValueChange = { viewModel.peso.value = it },
                label = { Text("Peso") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = modifier)
            Button(onClick = {
                navController.navigate("cronocapilar/cabelo")
            }) {
                Text(text = "Cadastrar Cabelo")
            }
        }

        Column {
            Button(
                onClick = { viewModel.inserirPerfil() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Text("Salvar")
            }

            Button(
                onClick = {
//                activity.onBackPressed()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 2.dp)
            ) {
                Text("Sair")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PerfilPreview() {
    val contexto = LocalContext.current
    PerfilScreen(
        navController = NavHostController(contexto),
        viewModel = PerfilViewModel(
            contexto.applicationContext as CronoApplication,
            DataBaseDao.DAOTESTE
        )
    )
}