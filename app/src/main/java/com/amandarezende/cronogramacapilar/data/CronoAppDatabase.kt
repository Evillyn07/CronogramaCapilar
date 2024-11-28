package com.amandarezende.cronogramacapilar.data

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    version = 2,
    entities = [Ativos::class, Cabelo::class, Cronograma::class, Etapa::class, Notificacao::class, Perfil::class, Produto::class],
    autoMigrations = [AutoMigration (from = 1, to = 2)],
    exportSchema = true
)
abstract class CronoAppDatabase : RoomDatabase() {
    abstract fun userDao(): DataBaseDao

    companion object {
        @Volatile
        private var INSTANCE: CronoAppDatabase? = null

        fun getDatabase(context: Context): CronoAppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CronoAppDatabase::class.java,
                    "app_database"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}