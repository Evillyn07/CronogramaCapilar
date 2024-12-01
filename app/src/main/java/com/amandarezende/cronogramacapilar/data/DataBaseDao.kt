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
    @Insert(onConflict = OnConflictStrategy.IGNORE)
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
    @Insert(onConflict = OnConflictStrategy.IGNORE)
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
    @Insert(onConflict = OnConflictStrategy.IGNORE)
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
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCronograma(cronograma: Cronograma)
    @Update
    fun updateCronograma(vararg cronograma: Cronograma)
    @Delete
    fun deleteCronograma(vararg cronograma: Cronograma)
    @Query("SELECT * FROM Cronograma")
    fun loadCronograma(): List<Cronograma>
    @Query("SELECT * FROM Cronograma WHERE id = :id")
    fun loadCronogramaById(id: Int): Cronograma


    /***
     * Cabelo
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
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
    @Insert(onConflict = OnConflictStrategy.IGNORE)
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
    @Insert(onConflict = OnConflictStrategy.IGNORE)
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

}