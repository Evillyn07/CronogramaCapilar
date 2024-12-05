package com.amandarezende.cronogramacapilar.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    version = 1,
    entities = [Ativos::class, Cabelo::class, Cronograma::class, Etapa::class, Notificacao::class, Perfil::class, Produto::class],
    exportSchema = true,
)
abstract class CronoAppDatabase : RoomDatabase() {
    abstract fun cronoDao(): DataBaseDao
}