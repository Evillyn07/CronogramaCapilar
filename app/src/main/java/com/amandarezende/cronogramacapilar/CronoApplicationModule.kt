package com.amandarezende.cronogramacapilar

import android.content.Context
import androidx.room.Room
import com.amandarezende.cronogramacapilar.data.CronoAppDatabase
import com.amandarezende.cronogramacapilar.data.DataBaseDao
import com.amandarezende.cronogramacapilar.data.MIGRATION_1_2
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

object CronoApplicationModule {
    @Module
    @InstallIn(SingletonComponent::class)
    object CronoModule {
        @Provides
        @Singleton
        fun cronoProvideAppDatabase(@ApplicationContext appContext: Context): CronoAppDatabase {
            return Room
                .databaseBuilder(appContext, CronoAppDatabase::class.java, "my-db")
                .addMigrations(MIGRATION_1_2)
                .allowMainThreadQueries()
                .build()
        }

        @Provides
        @Singleton
        fun CronoProvideDao(appDatabase: CronoAppDatabase): DataBaseDao {
            return appDatabase.cronoDao()
        }
    }
}
