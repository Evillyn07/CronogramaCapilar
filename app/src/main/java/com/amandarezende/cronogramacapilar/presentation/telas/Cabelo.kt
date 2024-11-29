package com.amandarezende.cronogramacapilar.presentation.telas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.amandarezende.cronogramacapilar.presentation.viewmodel.CronogramaViewModel


@Composable
fun CabeloScreen(navController: NavController,
                 viewModel: CronogramaViewModel) {
    val childCheckedStates = remember { mutableStateListOf(false, false, false) }
    val parentState = when {
        childCheckedStates.all { it } -> ToggleableState.On
        childCheckedStates.none { it } -> ToggleableState.Off
        else -> ToggleableState.Indeterminate
    }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        (
                Column {
                    Text(text = "Tipo de Cabelo")
                    Row(verticalAlignment = Alignment.CenterVertically,) {
                        Text("Normal")
                        TriStateCheckbox(
                            state = parentState,
                            onClick = {
                                val newState = parentState != ToggleableState.On
                                childCheckedStates.forEachIndexed { index, _ ->
                                    childCheckedStates[index] = newState
                                }
                            }
                        )
                        Text(text = "Secos")
                        TriStateCheckbox(
                            state = parentState,
                            onClick = {
                                val newState = parentState != ToggleableState.On
                                childCheckedStates.forEachIndexed { index, _ ->
                                    childCheckedStates[index] = newState
                                }
                            }
                        )
                        Text(text = "Oleosos")
                        TriStateCheckbox(
                            state = parentState,
                            onClick = {
                                val newState = parentState != ToggleableState.On
                                childCheckedStates.forEachIndexed { index, _ ->
                                    childCheckedStates[index] = newState
                                }
                            }
                        )
                        Text(text = "Mistos")
                        TriStateCheckbox(
                            state = parentState,
                            onClick = {
                                val newState = parentState != ToggleableState.On
                                childCheckedStates.forEachIndexed { index, _ ->
                                    childCheckedStates[index] = newState
                                }
                            }
                        )
                    }
                    Text(text = "Tipo de Fio")
                    Row(

                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text("Finos")
                        TriStateCheckbox(
                            state = parentState,
                            onClick = {
                                val newState = parentState != ToggleableState.On
                                childCheckedStates.forEachIndexed { index, _ ->
                                    childCheckedStates[index] = newState
                                }
                            }
                        )
                        Text(text = "Frágeis")
                        TriStateCheckbox(
                            state = parentState,
                            onClick = {
                                val newState = parentState != ToggleableState.On
                                childCheckedStates.forEachIndexed { index, _ ->
                                    childCheckedStates[index] = newState
                                }
                            }
                        )
                        Text(text = "Grossos")
                        TriStateCheckbox(
                            state = parentState,
                            onClick = {
                                val newState = parentState != ToggleableState.On
                                childCheckedStates.forEachIndexed { index, _ ->
                                    childCheckedStates[index] = newState
                                }
                            }
                        )
                        Text(text = "Porosos")
                        TriStateCheckbox(
                            state = parentState,
                            onClick = {
                                val newState = parentState != ToggleableState.On
                                childCheckedStates.forEachIndexed { index, _ ->
                                    childCheckedStates[index] = newState
                                }
                            }
                        )
                    }
                    Text(text = "Cabelo com Quimica?")
                    Row (
                        verticalAlignment = Alignment.CenterVertically,

                        ){

                        Text(text = "Sim")
                        TriStateCheckbox(
                            state = parentState,
                            onClick = {
                                val newState = parentState != ToggleableState.On
                                childCheckedStates.forEachIndexed { index, _ ->
                                    childCheckedStates[index] = newState
                                }
                            }
                        )
                        Text(text = "Não")
                        TriStateCheckbox(
                            state = parentState,
                            onClick = {
                                val newState = parentState != ToggleableState.On
                                childCheckedStates.forEachIndexed { index, _ ->
                                    childCheckedStates[index] = newState
                                }
                            }
                        )
                    }


                }


                )

    }
}


@Preview(showBackground = true)
@Composable
fun CabeloPreview() {
    CabeloScreen(NavController(LocalContext.current),
        CronogramaViewModel()
    )
}