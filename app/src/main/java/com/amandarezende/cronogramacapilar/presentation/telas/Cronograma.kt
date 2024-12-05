package com.amandarezende.cronogramacapilar.presentation.telas

import android.app.Application
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
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
import com.amandarezende.cronogramacapilar.CronoApplication
import com.amandarezende.cronogramacapilar.data.DataBaseDao
import com.amandarezende.cronogramacapilar.presentation.viewmodel.CronogramaViewModel
import com.amandarezende.cronogramacapilar.presentation.viewmodel.CronogramaViewModel.TipoCabelo


@Composable
fun CronogramaScreen(
    navController: NavHostController,
    viewModel: CronogramaViewModel
) {
    LaunchedEffect(key1 = Unit) { viewModel.setup() }

    val tipoCabelo = viewModel.tipoCabelo.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {

        if (tipoCabelo.value == TipoCabelo.MUITO_DANIFICADO) {
            item {
                Text(
                    text = "Cabelo Muito Danificado",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                CardMuitoDanificado(viewModel)
            }
        }

        if (tipoCabelo.value == TipoCabelo.POUCO_DANIFICADO) {
            item {
                Text(
                    text = "Cabelo Pouco Danificado",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                CardPoucoDanificado(viewModel)
            }
        }

        if (tipoCabelo.value == TipoCabelo.SAUDAVEL) {
            item {
                Text(
                    text = "Cabelo Saudável",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                CardCabeloSaudavel(viewModel)
            }
        }

        item { SelecionarDias(viewModel) }
        item { SelecionarObjetivos(viewModel) }
        item {
            Button(
                onClick = {
                    viewModel.inserirCronograma()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 4.dp)
            ) {
                Text("Salvar")
            }
        }
        item {
            Button(
                onClick = {
                    viewModel.resetarValores()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Text("Limpar Informações")
            }
        }
    }
}

@Composable
fun SelecionarDias(viewModel: CronogramaViewModel) {
    val daysOfWeek = listOf("Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado")
    val domingo = viewModel.domingo.collectAsState()
    val segunda = viewModel.segunda.collectAsState()
    val terca = viewModel.terca.collectAsState()
    val quarta = viewModel.quarta.collectAsState()
    val quinta = viewModel.quinta.collectAsState()
    val sexta = viewModel.sexta.collectAsState()
    val sabado = viewModel.sabado.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Selecione os dias", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        daysOfWeek.forEachIndexed { index, day ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = when (index) {
                        0 -> domingo.value
                        1 -> segunda.value
                        2 -> terca.value
                        3 -> quarta.value
                        4 -> quinta.value
                        5 -> sexta.value
                        6 -> sabado.value
                        else -> false
                    },
                    onCheckedChange = { checked ->
                        when (index) {
                            0 -> viewModel.domingo.value = checked
                            1 -> viewModel.segunda.value = checked
                            2 -> viewModel.terca.value = checked
                            3 -> viewModel.quarta.value = checked
                            4 -> viewModel.quinta.value = checked
                            5 -> viewModel.sexta.value = checked
                            6 -> viewModel.sabado.value = checked
                            else -> Unit
                        }
                    },
                    colors = CheckboxDefaults.colors(checkmarkColor = Color.White)
                )
                Text(text = day)
            }
        }
    }
}

@Composable
fun SelecionarObjetivos(viewModel: CronogramaViewModel) {
    val seusObjetivos = listOf(
        "Maciez", "Brilho", "Reduzir Frizz", "Repor Massa", "Crescimento",
        "Reduzir Oleosidade", "Manter Hidratação"
    )
    val maciez = viewModel.maciez.collectAsState()
    val brilho = viewModel.brilho.collectAsState()
    val reduzirFrizz = viewModel.reduzirFrizz.collectAsState()
    val reporMassa = viewModel.reporMassa.collectAsState()
    val crescimento = viewModel.crescimento.collectAsState()
    val reduzirOleosidade = viewModel.reduzirOleosidade.collectAsState()
    val manterHidratacao = viewModel.manterHidratacao.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Selecione os objetivos", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        seusObjetivos.forEachIndexed { index, day ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = when (index) {
                        0 -> maciez.value
                        1 -> brilho.value
                        2 -> reduzirFrizz.value
                        3 -> reporMassa.value
                        4 -> crescimento.value
                        5 -> reduzirOleosidade.value
                        6 -> manterHidratacao.value
                        else -> false
                    },
                    onCheckedChange = { checked ->
                        when (index) {
                            0 -> viewModel.maciez.value = checked
                            1 -> viewModel.brilho.value = checked
                            2 -> viewModel.reduzirFrizz.value = checked
                            3 -> viewModel.reporMassa.value = checked
                            4 -> viewModel.crescimento.value = checked
                            5 -> viewModel.reduzirOleosidade.value = checked
                            6 -> viewModel.manterHidratacao.value = checked
                            else -> Unit
                        }
                    },
                    colors = CheckboxDefaults.colors(checkmarkColor = Color.White)
                )
                Text(text = day)
            }
        }
    }
}

@Composable
fun CardMuitoDanificado(viewModel: CronogramaViewModel) {
    val esconderCard1 = remember {
        mutableStateOf(true)
    }
    Column(modifier = Modifier.padding(8.dp)) {
        if (esconderCard1.value) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier
                    .padding(vertical = 2.dp, horizontal = 2.dp)
                    .fillMaxWidth()
            ) {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ), modifier = Modifier
                        .padding(vertical = 2.dp, horizontal = 2.dp)
                        .fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "1º Semana",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        Text(
                            text = "- Hidratação",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 16.dp)
                        )

                        Text(
                            text = "- Hidratação",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 16.dp)
                        )

                        Text(
                            text = "- Nutrição",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }
                }

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ), modifier = Modifier
                        .padding(vertical = 2.dp, horizontal = 2.dp)
                        .fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "2º Semana",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        Text(
                            text = "- Hidratação",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 16.dp)
                        )

                        Text(
                            text = "- Hidratação",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 16.dp)
                        )

                        Text(
                            text = "- Reconstrução",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }
                }

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ), modifier = Modifier
                        .padding(vertical = 2.dp, horizontal = 2.dp)
                        .fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "3º Semana",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        Text(
                            text = "- Hidratação",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 16.dp)
                        )

                        Text(
                            text = "- Hidratação",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 16.dp)
                        )

                        Text(
                            text = "- Nutrição",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }
                }

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ), modifier = Modifier
                        .padding(vertical = 2.dp, horizontal = 2.dp)
                        .fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "4º Semana",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        Text(
                            text = "- Hidratação",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 16.dp)
                        )

                        Text(
                            text = "- Hidratação",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 16.dp)
                        )

                        Text(
                            text = "- Reconstrução",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CardPoucoDanificado(viewModel: CronogramaViewModel) {
    val esconderCard2 = remember {
        mutableStateOf(true)
    }
    Column(modifier = Modifier.padding(8.dp)) {
        if (esconderCard2.value) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier
                    .padding(vertical = 2.dp, horizontal = 2.dp)
                    .fillMaxWidth()
            ) {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ), modifier = Modifier
                        .padding(vertical = 2.dp, horizontal = 2.dp)
                        .fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "1º Semana",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        Text(
                            text = "- Hidratação",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 16.dp)
                        )

                        Text(
                            text = "- Hidratação",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 16.dp)
                        )

                        Text(
                            text = "- Nutrição",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }
                }
            }

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ), modifier = Modifier
                    .padding(vertical = 2.dp, horizontal = 2.dp)
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "2º Semana",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Text(
                        text = "- Hidratação",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(start = 16.dp)
                    )

                    Text(
                        text = "- Hidratação",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(start = 16.dp)
                    )

                    Text(
                        text = "- Nutrição",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ), modifier = Modifier
                    .padding(vertical = 2.dp, horizontal = 2.dp)
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "3º Semana",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Text(
                        text = "- Hidratação",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(start = 16.dp)
                    )

                    Text(
                        text = "- Hidratação",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(start = 16.dp)
                    )

                    Text(
                        text = "- Nutrição",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ), modifier = Modifier
                    .padding(vertical = 2.dp, horizontal = 2.dp)
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "4º Semana",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Text(
                        text = "- Hidratação",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(start = 16.dp)
                    )

                    Text(
                        text = "- Hidratação",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(start = 16.dp)
                    )

                    Text(
                        text = "- Reconstrução",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun CardCabeloSaudavel(viewModel: CronogramaViewModel) {
    val esconderCard3 = remember {
        mutableStateOf(true)
    }
    Column(modifier = Modifier.padding(8.dp)) {
        if (esconderCard3.value) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier
                    .padding(vertical = 2.dp, horizontal = 2.dp)
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "1º Semana",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Text(
                        text = "- Hidratação",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(start = 16.dp)
                    )

                    Text(
                        text = "- Hidratação",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(start = 16.dp)
                    )

                    Text(
                        text = "- Nutrição",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ), modifier = Modifier
                    .padding(vertical = 2.dp, horizontal = 2.dp)
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "2º Semana",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Text(
                        text = "- Hidratação",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(start = 16.dp)
                    )

                    Text(
                        text = "- Nutrição",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(start = 16.dp)
                    )

                    Text(
                        text = "- Hidratação",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }

        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ), modifier = Modifier
                .padding(vertical = 2.dp, horizontal = 2.dp)
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "3º Semana",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Text(
                    text = "- Hidratação",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(start = 16.dp)
                )

                Text(
                    text = "- Hidratação",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(start = 16.dp)
                )

                Text(
                    text = "- Nutrição",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }

        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ), modifier = Modifier
                .padding(vertical = 2.dp, horizontal = 2.dp)
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "4º Semana",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Text(
                    text = "- Hidratação",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(start = 16.dp)
                )

                Text(
                    text = "- Nutrição",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(start = 16.dp)
                )

                Text(
                    text = "- Reconstrução",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, heightDp = 900)
@Composable
fun CronogramaPreview() {
    CronogramaScreen(
        navController = NavHostController(LocalContext.current),
        viewModel = CronogramaViewModel(
            Application(),
            DataBaseDao.DAOTESTE
        )
    )
}

@Preview(showBackground = true)
@Composable
fun SelecionarDiasPreview() {
    SelecionarDias(
        CronogramaViewModel(
            Application(),
            DataBaseDao.DAOTESTE
        )
    )
}

@Preview(showBackground = true)
@Composable
fun SelecionarObjetivosPreview() {
    SelecionarObjetivos(
        CronogramaViewModel(
            Application(),
            DataBaseDao.DAOTESTE
        )
    )
}

@Preview(showBackground = true)
@Composable
fun CardCabeloMuitoDanificadoPreview() {
    CardMuitoDanificado(
        CronogramaViewModel(
            Application(),
            DataBaseDao.DAOTESTE
        )
    )
}

@Preview(showBackground = true)
@Composable
fun CardCabeloPoucoDanificadoPreview() {
    CardPoucoDanificado(
        CronogramaViewModel(
            Application(),
            DataBaseDao.DAOTESTE
        )
    )
}

@Preview(showBackground = true)
@Composable
fun CardCabeloSaudavelPreview() {
    CardPoucoDanificado(
        CronogramaViewModel(
            Application(),
            DataBaseDao.DAOTESTE
        )
    )
}




