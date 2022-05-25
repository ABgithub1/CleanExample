package com.example.githubclient.data.di

import com.example.githubclient.data.repository.UserRepositoryImpl
import com.example.githubclient.domain.repository.UserRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val repositoryModule = module {
    singleOf(::UserRepositoryImpl) { bind<UserRepository>() }
}