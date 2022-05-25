package com.example.githubclient.presentation.di

import com.example.githubclient.presentation.ui.details.UserDetailsViewModel
import com.example.githubclient.presentation.ui.language.LanguageViewModel
import com.example.githubclient.presentation.ui.nightmode.NightModeViewModel
import com.example.githubclient.presentation.ui.users.UsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::UsersViewModel)
    viewModelOf(::UserDetailsViewModel)
    viewModelOf(::NightModeViewModel)
    viewModelOf(::LanguageViewModel)
}