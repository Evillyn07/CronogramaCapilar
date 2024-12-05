package com.amandarezende.cronogramacapilar.presentation.telas

import android.app.Application
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.amandarezende.cronogramacapilar.data.DataBaseDao
import com.amandarezende.cronogramacapilar.presentation.viewmodel.CabeloViewModel


@Composable
fun CabeloScreen(
    navController: NavController,
    viewModel: CabeloViewModel
) {
    LaunchedEffect(key1 = viewModel) { viewModel.setup() }

    val tipoCabelo by viewModel.tipoCabelo.collectAsState()
    val tipoFio by viewModel.tipoFio.collectAsState()
    val quimica by viewModel.quimica.collectAsState()

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)

    ) {

        Text(text = "Tipo de Cabelo")
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Normal")
            RadioButton(
                selected = tipoCabelo == "Normal",
                onClick = { viewModel.tipoCabelo.value = "Normal" }
            )

            Text("Secos")
            RadioButton(
                selected = tipoCabelo == "Secos",
                onClick = { viewModel.tipoCabelo.value = "Secos" }
            )
            Text("Oleosos")
            RadioButton(
                selected = tipoCabelo == "Oleosos",
                onClick = { viewModel.tipoCabelo.value = "Oleosos" }
            )
            Text("Misto")
            RadioButton(
                selected = tipoCabelo == "Misto",
                onClick = { viewModel.tipoCabelo.value = "Misto" }
            )
        }

        Text(text = "Tipo de Fio")
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Finos")
            RadioButton(
                selected = tipoFio == "Finos",
                onClick = { viewModel.tipoFio.value = "Finos" }
            )
            Text("Frágeis")
            RadioButton(
                selected = tipoFio == "Frágeis",
                onClick = { viewModel.tipoFio.value = "Frágeis" }
            )
            Text("Grossos")
            RadioButton(
                selected = tipoFio == "Grossos",
                onClick = { viewModel.tipoFio.value = "Grossos" }
            )
            Text("Porosos")
            RadioButton(
                selected = tipoFio == "Porosos",
                onClick = { viewModel.tipoFio.value = "Porosos" }
            )
        }

        Text(text = "Cabelo com Química?")
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("SIM")
            RadioButton(
                selected = quimica == "SIM",
                onClick = { viewModel.quimica.value = "SIM" }
            )
            Text("NÃO")
            RadioButton(
                selected = quimica == "NÃO",
                onClick = { viewModel.quimica.value = "NÃO" }
            )
        }

        Button(
            onClick = { viewModel.inserirCabelo() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Salvar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CabeloPreview() {
    val contexto = LocalContext.current
    CabeloScreen(
        navController = NavHostController(contexto),
        viewModel = CabeloViewModel(
            Application(),
            DataBaseDao.DAOTESTE
        )
    )
}

