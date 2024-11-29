package com.amandarezende.cronogramacapilar.telas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun CronogramaScreen(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item { SelecionarDias() }
        item { SelecionarObjetivos() }
        item {
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                Text("Limpar Informações")
            }
        }
    }
}

@Composable
fun SelecionarDias() {
    val daysOfWeek = listOf("Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo")
    val selectedDays =
        remember { mutableStateListOf<Boolean>(false, false, false, false, false, false, false) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Selecione os dias", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        daysOfWeek.forEachIndexed { index, day ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = selectedDays[index],
                    onCheckedChange = { selectedDays[index] = it },
                    colors = CheckboxDefaults.colors(checkmarkColor = Color.White)
                )
                Text(text = day)
            }
        }
    }
}

@Composable
fun SelecionarObjetivos() {
    val objetivos = listOf(
        "Maciez",
        "Brilho",
        "Reduzir Frizz",
        "Repor Massa",
        "Crescimento",
        "Reduzir Oleosidade",
        "Manter hidratação"
    )
    val selecioarObjetivos = remember {
        mutableStateListOf(false, false, false, false, false, false, false)
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Selecione Objetivos", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        objetivos.forEachIndexed { index, day ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = selecioarObjetivos[index],
                    onCheckedChange = { selecioarObjetivos[index] = it },
                    colors = CheckboxDefaults.colors(checkmarkColor = Color.White)
                )
                Text(text = day)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CronogramaPreview() {
    CronogramaScreen(NavHostController(LocalContext.current))
}

@Preview(showBackground = true)
@Composable
fun SelecionarDiasPreview() {
    SelecionarDias()
}

@Preview(showBackground = true)
@Composable
fun SelecionarObjetivosPreview() {
    SelecionarObjetivos()
}