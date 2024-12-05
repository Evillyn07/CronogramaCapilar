package com.amandarezende.cronogramacapilar.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface DataBaseDao {
    /***
     * Ativo
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAtivo(ativos: Ativos)
    @Update
    fun updateAtivos(vararg ativos: Ativos)
    @Delete
    fun deleteAtivos(vararg ativos: Ativos)
    @Query("SELECT * FROM Ativos")
    fun loadAtivos(): List<Ativos>
    @Query("SELECT * FROM Ativos WHERE id = :id")
    fun loadAtivosById(id: Int): Ativos

    /***
     * Produto
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduto(produto: Produto)
    @Update
    suspend fun updateProduto(vararg produto: Produto)
    @Delete
    suspend fun deletePoduto(vararg produto: Produto)
    @Query("SELECT * FROM Produto")
    suspend fun loadProduto(): List<Produto>
    @Query("SELECT * FROM Produto WHERE id = :id")
    suspend fun loadProdutoById(id: Int): Produto

    /***
     * Etapa
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEtapa(etapa: Etapa)
    @Update
    suspend fun updateEtapa(vararg etapa: Etapa)
    @Delete
    suspend fun deleteEtapa(vararg etapa: Etapa)
    @Query("SELECT * FROM Etapa")
    suspend fun loadPEtapa(): List<Etapa>
    @Query("SELECT * FROM Etapa WHERE id = :id")
    suspend fun loadNEtapaById(id: Int): Etapa

    @Query(
        "SELECT * FROM ETAPA INNER JOIN (" +
                "SELECT CRONOGRAMA.ID FROM CRONOGRAMA INNER JOIN PERFIL " +
                "ON CRONOGRAMA.IDPERFIL = PERFIL.ID WHERE PERFIL.ID = :usuarioId)" +
                " AS CRONOGRAMA_USUARIO " +
                "ON ETAPA.IDCRONOGRAMA = CRONOGRAMA_USUARIO.ID WHERE ETAPA.diaMes =:diaMes"
    )
    suspend fun loadEtapaAtual(usuarioId: Int, diaMes: Int): Etapa

    /***
     * Cronograma
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCronograma(cronograma: Cronograma)
    @Update
    fun updateCronograma(vararg cronograma: Cronograma)
    @Delete
    fun deleteCronograma(vararg cronograma: Cronograma)
    @Query("SELECT * FROM Cronograma LIMIT 1")
    fun loadCronograma(): List<Cronograma>
    @Query("SELECT * FROM Cronograma WHERE id = :id")
    fun loadCronogramaById(id: Int): Cronograma


    /***
     * Cabelo
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCabelo(cabelo: Cabelo)
    @Update
    fun updateCabelo(vararg cabelo: Cabelo)
    @Delete
    fun deleteCabelo(vararg cabelo: Cabelo)
    @Query("SELECT * FROM Cabelo")
    fun loadCabelo(): List<Cabelo>
    @Query("SELECT * FROM Cabelo WHERE id = :id")
    fun loadCabeloById(id: Int): Cabelo


    /***
     * Notificacao
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotificacao(notificacao: Notificacao)
    @Update
    fun updateNotificacao(vararg notificacao: Notificacao)
    @Delete
    fun deleteNotificacao(vararg notificacao: Notificacao)
    @Query("SELECT * FROM Notificacao")
    fun loadNotificacao(): List<Notificacao>
    @Query("SELECT * FROM Notificacao WHERE id = :id")
    fun loadNotificacaoById(id: Int): Notificacao

    /***
     * Perfil
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPerfil(perfil: Perfil)
    @Update
    fun updatePerfil(vararg perfil: Perfil)
    @Delete
    fun deletePerfil(vararg perfil: Perfil)
    @Query("SELECT * FROM Perfil")
    fun loadPerfil(): List<Perfil>
    @Query("SELECT * FROM Perfil WHERE id = :id")
    fun loadPerfilById(id: Int): Perfil
    @Query("SELECT * FROM Perfil WHERE nome = :nome")
    fun loadPerfilByNome(nome: String): Perfil
    @Query("SELECT * FROM Perfil WHERE email = :email")
    fun loadPerfilByEmail(email: String): Perfil
    @Query("SELECT * FROM Perfil WHERE senha = :senha")
    fun loadPerfilBySenha(senha: String): Perfil
    @Query("SELECT * FROM Perfil WHERE peso = :peso")
    fun loadPerfilByPeso(peso: String): Perfil

    companion object {
        val DAOTESTE = object : DataBaseDao {
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

        }
    }
}