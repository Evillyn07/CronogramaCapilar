package com.amandarezende.cronogramacapilar.presentation.telas

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.amandarezende.cronogramacapilar.presentation.viewmodel.NotificacaoViewModel
import com.amandarezende.cronogramacapilar.presentation.viewmodel.PerfilViewModel
import java.util.Calendar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificacaoScreen(
    navController: NavController,
    viewModel: NotificacaoViewModel
) {
    val currentTime = Calendar.getInstance()

    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = true,
    )

    Column {
        TimePicker(
            state = timePickerState,
        )
        Button(onClick = {}) {
            Text("Confirmar Horário")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NotificacaoScreen(NavController(LocalContext.current),
        NotificacaoViewModel()
    )
}