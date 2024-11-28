package com.amandarezende.cronogramacapilar

import android.content.Context
import androidx.room.Room
import com.amandarezende.cronogramacapilar.data.CronoAppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

object CronoApplicationModule {
    @Module
    @InstallIn(SingletonComponent::class)
    objeto AppModule {
        @Provides
        @Singleton
        fun  provideAppDatabase ( @ApplicationContext appContext: Context) : CronoAppDatabase {
            return Room.databaseBuilder(
                appContext,
                CronoAppDatabase:: class .java,
                "room_database"
            ).build()
        }
        @Provides
        @Singleton
        fun  provideDao (appDatabase: CronoAppDatabase) : kao{
            return appDatabase.taskDao()
        }
        @Provides
        @Singleton
        fun  provideTaskRepository (taskDao: TaskDao ) : TaskRepository {
            return TaskRepository(taskDao)
        }
    }

}
