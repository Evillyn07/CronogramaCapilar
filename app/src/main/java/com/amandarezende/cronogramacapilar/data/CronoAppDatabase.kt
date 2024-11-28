package com.amandarezende.cronogramacapilar.data

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    version = 2,
    entities = [Ativos::class, Cabelo::class, Cronograma::class, Etapa::class, Notificacao::class, Perfil::class, Produto::class],
    exportSchema = true,
)
abstract class CronoAppDatabase : RoomDatabase() {
    abstract fun cronoDao(): DataBaseDao
}

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("INSERT INTO Ativos (id, nome, recomendacao) VALUES(1, 'Glicerina', ''Hidratação)")
//        db.execSQL( "" )
//        db.execSQL( "" )
//        db.execSQL( "" )
//        db.execSQL( "" )
//        db.execSQL( "" )
//        db.execSQL( "" )
//        db.execSQL( "" )
    }
}