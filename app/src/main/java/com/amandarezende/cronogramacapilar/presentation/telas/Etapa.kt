package com.amandarezende.cronogramacapilar.presentation.telas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.amandarezende.cronogramacapilar.data.DataBaseDao
import com.amandarezende.cronogramacapilar.presentation.viewmodel.EtapaViewModel
import com.amandarezende.cronogramacapilar.presentation.viewmodel.HomeViewModel
import com.amandarezende.cronogramacapilar.presentation.viewmodel.NotificacaoViewModel

@Composable
fun EtapaScreen(navController: NavController,
                viewModel: EtapaViewModel

) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Etapa Atual",
            style = TextStyle(fontSize = 36.sp),
            modifier = Modifier.padding(bottom = 20.dp)
        )

        Button(onClick = {
            navController.navigate("cronocapilar/ativos")
        }) {
            Text(text = "Ativos")
        }

        Button(onClick = {
            navController.navigate("cronocapilar/produtos")
        }) {
            Text(text = "Produtos")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EtapaPreview() {
    EtapaScreen(NavController(LocalContext.current),
        EtapaViewModel(DataBaseDao.DAOTESTE)
    )
}