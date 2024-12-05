package com.amandarezende.cronogramacapilar.presentation.viewmodel

import com.amandarezende.cronogramacapilar.data.Cabelo
import com.amandarezende.cronogramacapilar.data.DataBaseDao
import com.amandarezende.cronogramacapilar.data.Perfil
import com.amandarezende.cronogramacapilar.presentation.viewmodel.HomeViewModel.TipoCabelo.MUITO_DANIFICADO
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {

    private val dao: DataBaseDao = mockk(relaxed = true)
    private val tipoCabelo: (HomeViewModel.TipoCabelo) -> Unit = mockk(relaxed = true)

    lateinit var viewModel: HomeViewModel

    @Before
    fun setup() {
        viewModel = HomeViewModel(dao)
    }

    private suspend fun setupObserver() {
        viewModel.tipoCabelo.collect { tipoCabelo(it) }
    }

    @Test
    fun dadoCabeloSecoFragilComQuimica_retornaMuitoDanificado() =
        runTest(UnconfinedTestDispatcher()) {
            setupObserver()
            coEvery { dao.loadPerfil() } returns
                    listOf(Perfil(1, "", "", "", "", 1))

            coEvery { dao.loadCabeloById(1) } returns
                    Cabelo(1, "Seco", "Fragil", "Sim")

            viewModel.setup()
            advanceUntilIdle()

            assertEquals(viewModel.tipoCabelo.value, MUITO_DANIFICADO)
        }

    @Test
    fun dadoCabeloSecoFragilComQuimica_retornaPoucoDanificado() = runTest {

    }
}