package com.example.githubclient.data.di

import com.example.githubclient.domain.service.LanguageService
import com.example.githubclient.domain.service.NightModeService
import com.example.githubclient.data.service.preferences.PreferencesServiceImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val serviceModule = module {
    singleOf(::PreferencesServiceImpl) {
        bind<NightModeService>()
        bind<LanguageService>()
    }
}