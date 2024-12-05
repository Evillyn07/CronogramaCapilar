package com.amandarezende.cronogramacapilar.presentation.telas

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.navigation.NavController
import com.amandarezende.cronogramacapilar.data.Ativos
import com.amandarezende.cronogramacapilar.data.DataBaseDao.Companion.DAOTESTE
import com.amandarezende.cronogramacapilar.presentation.viewmodel.AtivosViewModel

@Composable
fun AtivosScreen(
    navController: NavController,
    viewModel: AtivosViewModel
) {
    val recomendacaoAtivos = viewModel.recomendacaoAtivos.collectAsState()
    LaunchedEffect(key1 = Unit) {
        viewModel.setup()
    }
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        item {
            Text(
                text = "ATIVOS",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier
                    .padding(vertical = 16.dp, horizontal = 8.dp)
            )
        }

        items(recomendacaoAtivos.value.keys.toTypedArray()) { recomendacao ->
            Ativo(recomendacao, recomendacaoAtivos.value.getValue(recomendacao))
        }
    }
}

@Composable
fun Ativo(recomendacao: String, ativos: List<Ativos?>?) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ), modifier = Modifier
            .padding(vertical = 2.dp, horizontal = 2.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .animateContentSize()
        )
        {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp)
            )
            {
                Text(
                    text = recomendacao,
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
                )
                if (expanded) {
                    ativos?.forEach {
                        Text(text = (it?.nome.orEmpty()))
                    }
                }
            }

            IconButton(onClick = { expanded = !expanded }) {
                Icon(
                    imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription =
                    if (expanded) "show less" else "show more"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AtivosPreview() {
    AtivosScreen(
        NavController(LocalContext.current),
        AtivosViewModel(DAOTESTE)
    )
}