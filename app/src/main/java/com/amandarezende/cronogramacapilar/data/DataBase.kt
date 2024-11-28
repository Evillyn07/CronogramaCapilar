package com.amandarezende.cronogramacapilar.data

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    version = 2,
    entities = [Ativos::class, Cabelo::class, Cronograma::class, Etapa::class, Notificacao::class, Perfil::class, Produto::class],
    autoMigrations = [AutoMigration (from = 1, to = 2)]
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun userDao(): DataBaseDao
}