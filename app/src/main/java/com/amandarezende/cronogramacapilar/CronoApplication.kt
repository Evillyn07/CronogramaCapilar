package com.amandarezende.cronogramacapilar

import android.app.Application
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.amandarezende.cronogramacapilar.data.AppDataBase

class CronoApplication : Application() {
    companion object {
        var database: AppDataBase? = null
    }

    override fun onCreate() {
        super.onCreate()
        database =
            Room
                .databaseBuilder(this, AppDataBase::class.java, "my-db")
                .addMigrations(MIGRATION_1_2)
                .allowMainThreadQueries()
                .build()
    }
}

val MIGRATION_1_2 = object : Migration(1, 2) {
    override  fun  migrate (db: SupportSQLiteDatabase) {
        db.execSQL( "INSERT INTO Ativos (id, nome, recomendacao) VALUES(1, 'Glicerina', ''Hidratação)" )
//        db.execSQL( "" )
//        db.execSQL( "" )
//        db.execSQL( "" )
//        db.execSQL( "" )
//        db.execSQL( "" )
//        db.execSQL( "" )
//        db.execSQL( "" )
    }
}