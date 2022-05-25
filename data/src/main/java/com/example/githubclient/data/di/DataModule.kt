package com.example.githubclient.data.di

import org.koin.dsl.module

val dataModule = module {
    includes(
        networkModule,
        databaseModule,
        repositoryModule,
        serviceModule,
        useCaseModule
    )
}