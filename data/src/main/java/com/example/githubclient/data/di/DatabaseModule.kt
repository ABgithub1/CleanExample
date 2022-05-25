package com.example.githubclient.data.di

import androidx.room.Room
import com.example.githubclient.data.database.AppDatabase
import org.koin.dsl.module

internal val databaseModule = module {
    single {
        Room
            .databaseBuilder(
                get(),
                AppDatabase::class.java,
                "app_database.db"
            )
            .build()
    }

    single { get<AppDatabase>().userDao() }
}