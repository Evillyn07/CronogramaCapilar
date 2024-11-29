package com.amandarezende.cronogramacapilar.presentation.telas

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
import com.amandarezende.cronogramacapilar.presentation.viewmodel.PerfilViewModel
import com.amandarezende.cronogramacapilar.presentation.viewmodel.ProdutoViewModel

@Composable
fun PerfilScreen(navController: NavController,
                 viewModel: PerfilViewModel
) {
    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var cabelo by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var alterarSenha by remember { mutableStateOf("") }

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
            TextField(value = nome, onValueChange = { nome = it }, label = { Text("Nome") })
            Spacer(modifier = modifier)
            TextField(value = email, onValueChange = { email = it }, label = { Text("E-mail") })
            Spacer(modifier = modifier)
            TextField(value = cabelo, onValueChange = { cabelo = it }, label = { Text("Cabelo") })
            Spacer(modifier = modifier)
            TextField(value = peso, onValueChange = { peso = it }, label = { Text("Peso") })
            Spacer(modifier = modifier)
            TextField(
                value = alterarSenha,
                onValueChange = { alterarSenha = it },
                label = { Text("Alterar Senhar") })
        }

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Sair")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PerfilPreview() {
    PerfilScreen(NavController(LocalContext.current),
        PerfilViewModel()
    )
}