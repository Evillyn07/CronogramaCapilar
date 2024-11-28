package com.amandarezende.cronogramacapilar.telas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HomeScreen() {
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

            Button(onClick = {}) {
                Text(text = "Perfil")
            }
            Button(onClick = {}, modifier = Modifier.padding(top = 8.dp)) {
                Text(text = "Cronograma")
            }
            Button(onClick = {}, modifier = Modifier.padding(top = 8.dp)) {
                Text(text = "Etapa")
            }
            Button(onClick = {}, modifier = Modifier.padding(top = 8.dp)) {
                Text(text = "Notificação")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeScreen()
}