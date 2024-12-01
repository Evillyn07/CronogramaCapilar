package com.amandarezende.cronogramacapilar.presentation.telas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.amandarezende.cronogramacapilar.data.Ativos
import com.amandarezende.cronogramacapilar.data.Cabelo
import com.amandarezende.cronogramacapilar.data.Cronograma
import com.amandarezende.cronogramacapilar.data.DataBaseDao
import com.amandarezende.cronogramacapilar.data.Etapa
import com.amandarezende.cronogramacapilar.data.Notificacao
import com.amandarezende.cronogramacapilar.data.Perfil
import com.amandarezende.cronogramacapilar.data.Produto
import com.amandarezende.cronogramacapilar.presentation.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.asStateFlow


@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel
) {
    val etapaAtual = viewModel.etapaAtual.collectAsState()
    LaunchedEffect(key1 = Unit) {
        viewModel.setup()
    }

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

            Text(
                text = etapaAtual.value?.nome.orEmpty(),
                style = TextStyle(fontSize = 28.sp),
                modifier = Modifier.padding(bottom = 20.dp)
            )

            Button(onClick = {
                navController.navigate("cronocapilar/perfil")
            }) {
                Text(text = "Perfil")
            }
            Button(onClick = {
                navController.navigate("cronocapilar/cronograma")
            }, modifier = Modifier.padding(top = 8.dp)) {
                Text(text = "Cronograma")
            }
            Button(onClick = {
                navController.navigate("cronocapilar/etapa")
            }, modifier = Modifier.padding(top = 8.dp)) {
                Text(text = "Etapa")
            }
            Button(onClick = {
                navController.navigate("cronocapilar/notificacao")
            }, modifier = Modifier.padding(top = 8.dp)) {
                Text(text = "Notificação")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeScreen(
        NavController(LocalContext.current),
        HomeViewModel(object : DataBaseDao {
            override suspend fun insertAtivo(ativos: Ativos) {
                TODO("Not yet implemented")
            }

            override fun updateAtivos(vararg ativos: Ativos) {
                TODO("Not yet implemented")
            }

            override fun deleteAtivos(vararg ativos: Ativos) {
                TODO("Not yet implemented")
            }

            override fun loadAtivos(): List<Ativos> {
                TODO("Not yet implemented")
            }

            override fun loadAtivosById(id: Int): Ativos {
                TODO("Not yet implemented")
            }

            override suspend fun insertProduto(produto: Produto) {
                TODO("Not yet implemented")
            }

            override suspend fun updateProduto(vararg produto: Produto) {
                TODO("Not yet implemented")
            }

            override suspend fun deletePoduto(vararg produto: Produto) {
                TODO("Not yet implemented")
            }

            override suspend fun loadProduto(): List<Produto> {
                TODO("Not yet implemented")
            }

            override suspend fun loadProdutoById(id: Int): Produto {
                TODO("Not yet implemented")
            }

            override suspend fun insertEtapa(etapa: Etapa) {
                TODO("Not yet implemented")
            }

            override suspend fun updateEtapa(vararg etapa: Etapa) {
                TODO("Not yet implemented")
            }

            override suspend fun deleteEtapa(vararg etapa: Etapa) {
                TODO("Not yet implemented")
            }

            override suspend fun loadPEtapa(): List<Etapa> {
                TODO("Not yet implemented")
            }

            override suspend fun loadNEtapaById(id: Int): Etapa {
                TODO("Not yet implemented")
            }

            override suspend fun loadEtapaAtual(usuarioId: Int, diaMes: Int): Etapa {
                TODO("Not yet implemented")
            }

            override suspend fun insertCronograma(cronograma: Cronograma) {
                TODO("Not yet implemented")
            }

            override fun updateCronograma(vararg cronograma: Cronograma) {
                TODO("Not yet implemented")
            }

            override fun deleteCronograma(vararg cronograma: Cronograma) {
                TODO("Not yet implemented")
            }

            override fun loadCronograma(): List<Cronograma> {
                TODO("Not yet implemented")
            }

            override fun loadCronogramaById(id: Int): Cronograma {
                TODO("Not yet implemented")
            }

            override suspend fun insertCabelo(cabelo: Cabelo) {
                TODO("Not yet implemented")
            }

            override fun updateCabelo(vararg cabelo: Cabelo) {
                TODO("Not yet implemented")
            }

            override fun deleteCabelo(vararg cabelo: Cabelo) {
                TODO("Not yet implemented")
            }

            override fun loadCabelo(): List<Cabelo> {
                TODO("Not yet implemented")
            }

            override fun loadCabeloById(id: Int): Cabelo {
                TODO("Not yet implemented")
            }

            override suspend fun insertNotificacao(notificacao: Notificacao) {
                TODO("Not yet implemented")
            }

            override fun updateNotificacao(vararg notificacao: Notificacao) {
                TODO("Not yet implemented")
            }

            override fun deleteNotificacao(vararg notificacao: Notificacao) {
                TODO("Not yet implemented")
            }

            override fun loadNotificacao(): List<Notificacao> {
                TODO("Not yet implemented")
            }

            override fun loadNotificacaoById(id: Int): Notificacao {
                TODO("Not yet implemented")
            }

            override suspend fun insertPerfil(perfil: Perfil) {
                TODO("Not yet implemented")
            }

            override fun updatePerfil(vararg perfil: Perfil) {
                TODO("Not yet implemented")
            }

            override fun deletePerfil(vararg perfil: Perfil) {
                TODO("Not yet implemented")
            }

            override fun loadPerfil(): List<Perfil> {
                TODO("Not yet implemented")
            }

            override fun loadPerfilById(id: Int): Perfil {
                TODO("Not yet implemented")
            }

            override fun loadPerfilByNome(nome: String): Perfil {
                TODO("Not yet implemented")
            }

            override fun loadPerfilByEmail(email: String): Perfil {
                TODO("Not yet implemented")
            }

            override fun loadPerfilBySenha(senha: String): Perfil {
                TODO("Not yet implemented")
            }

            override fun loadPerfilByPeso(peso: String): Perfil {
                TODO("Not yet implemented")
            }

        })
    )
}