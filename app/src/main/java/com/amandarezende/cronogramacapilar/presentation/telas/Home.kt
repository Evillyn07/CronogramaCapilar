package com.amandarezende.cronogramacapilar.presentation.telas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.amandarezende.cronogramacapilar.data.DataBaseDao.Companion.DAOTESTE
import com.amandarezende.cronogramacapilar.presentation.viewmodel.HomeViewModel


@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel
) {
    val etapaAtual = viewModel.etapaAtual.collectAsState()
    LaunchedEffect(key1 = Unit) {
        viewModel.setup()
    }

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "ETAPA ATUAL",
                style = TextStyle(fontSize = 36.sp),
                modifier = Modifier.padding(bottom = 20.dp)
            )

            Text(
                text = etapaAtual.value?.nome.orEmpty(),
                style = TextStyle(fontSize = 28.sp),
                modifier = Modifier.padding(bottom = 20.dp)
            )

            Button(onClick = {
                navController.navigate("cronocapilar/perfil")
            }) {
                Text(text = "Perfil")
            }
            Button(onClick = {
                navController.navigate("cronocapilar/cronograma")
            }, modifier = Modifier.padding(top = 8.dp)) {
                Text(text = "Cronograma")
            }
            Button(onClick = {
                navController.navigate("cronocapilar/etapa")
            }, modifier = Modifier.padding(top = 8.dp)) {
                Text(text = "Etapa")
            }
            Button(onClick = {
                navController.navigate("cronocapilar/notificacao")
            }, modifier = Modifier.padding(top = 8.dp)) {
                Text(text = "Notificação")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeScreen(
        NavController(LocalContext.current),
        HomeViewModel(DAOTESTE)
    )
}