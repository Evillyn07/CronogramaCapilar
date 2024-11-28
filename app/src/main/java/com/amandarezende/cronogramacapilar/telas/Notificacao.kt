package com.amandarezende.cronogramacapilar.telas

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import java.util.Calendar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Notificacao(
    modifier: Modifier = Modifier,
    onConfirm: () -> Unit = {},
    onDismiss: () -> Unit = {},
) {
    val currentTime = Calendar.getInstance()

    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = true,
    )

    Column(modifier = modifier) {
        TimePicker(
            state = timePickerState,
        )
        Button(onClick = onConfirm) {
            Text("Confirmar Horário")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Notificacao()
}