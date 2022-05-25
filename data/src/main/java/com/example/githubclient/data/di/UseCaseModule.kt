package com.example.githubclient.data.di

import com.example.githubclient.domain.usecase.GetUserDetailsUseCase
import com.example.githubclient.domain.usecase.GetUsersUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal val useCaseModule = module {
    factoryOf(::GetUsersUseCase)
    factoryOf(::GetUserDetailsUseCase)
}