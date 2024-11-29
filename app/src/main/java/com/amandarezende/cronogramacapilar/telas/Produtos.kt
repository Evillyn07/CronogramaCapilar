package com.amandarezende.cronogramacapilar.telas

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun ProdutosScreen(
    navController: NavController
) {
    val produtos = listOf("Hidratação", "Nutrição", "Reconstrução")
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        item {
            Text(
                text = "Dicas de Produtos",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier
                    .padding(vertical = 16.dp, horizontal = 8.dp)
            )
        }
        items(produtos) { name ->
            OpcoesProdutos(name = name)
        }
    }

}

@Composable
fun OpcoesProdutos(name: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ), modifier = Modifier.padding(vertical = 2.dp, horizontal = 2.dp)
    ) {
        DescricaoProdutos(name = name)
    }
}

@Composable
fun DescricaoProdutos(name: String) {
    var expanded by remember {
        mutableStateOf(false)
    }
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
            Text(text = "")
            Text(
                text = name,
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
            )

            if (expanded) {
                Text(text = ("").repeat(4))
            }
        }
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription =
                if (expanded) {
                    "show less"
                } else {
                    "show more"
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProdutosPreview() {
    ProdutosScreen(NavController(LocalContext.current))
}