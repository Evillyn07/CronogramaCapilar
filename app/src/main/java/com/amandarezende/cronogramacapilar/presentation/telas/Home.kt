package com.amandarezende.cronogramacapilar.presentation.telas

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.amandarezende.cronogramacapilar.data.DataBaseDao.Companion.DAOTESTE
import com.amandarezende.cronogramacapilar.presentation.viewmodel.HomeViewModel
import com.amandarezende.cronogramacapilar.presentation.viewmodel.HomeViewModel.TipoCabelo


@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel
) {
    val tipoCabelo = viewModel.tipoCabelo.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.setup()
    }

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            item {
                Text(
                    text = "Cronograma atual",
                    style = TextStyle(fontSize = 36.sp),
                    modifier = Modifier.padding(bottom = 20.dp)
                )
            }

            if (tipoCabelo.value == TipoCabelo.MUITO_DANIFICADO) {
                item {
                    Text(
                        text = "Cabelo Muito Danificado",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    CardMuitoDanificado()
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
                    CardPoucoDanificado()
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
                    CardCabeloSaudavel()
                }
            }

            item {
                Button(onClick = {
                    navController.navigate("cronocapilar/perfil")
                }) {
                    Text(text = "Perfil")
                }
            }
            item {
                Button(onClick = {
                    navController.navigate("cronocapilar/cronograma")
                }, modifier = Modifier.padding(top = 8.dp)) {
                    Text(text = "Cronograma")
                }
            }
            item {
                Button(onClick = {
                    navController.navigate("cronocapilar/etapa")
                }, modifier = Modifier.padding(top = 8.dp)) {
                    Text(text = "Sugestões")
                }
            }
            item {
                Button(onClick = {
                    navController.navigate("cronocapilar/notificacao")
                }, modifier = Modifier.padding(top = 8.dp)) {
                    Text(text = "Notificação")
                }
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

@Preview(showBackground = true)
@Composable
fun CardCabeloMuitoDanificadoPreview() {
    CardMuitoDanificado()
}

@Preview(showBackground = true)
@Composable
fun CardCabeloPoucoDanificadoPreview() {
    CardPoucoDanificado()
}

@Preview(showBackground = true)
@Composable
fun CardCabeloSaudavelPreview() {
    CardPoucoDanificado()
}