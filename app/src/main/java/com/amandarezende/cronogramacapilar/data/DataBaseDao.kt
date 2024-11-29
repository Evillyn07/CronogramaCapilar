package com.amandarezende.cronogramacapilar.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DataBaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAtivos(ativos: Ativos)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEtapa(etapa: Etapa)

    @Query("")
    fun buscarEtapa()
}