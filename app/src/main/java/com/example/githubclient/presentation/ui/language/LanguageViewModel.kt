package com.example.githubclient.presentation.ui.language

import androidx.lifecycle.ViewModel
import com.example.githubclient.domain.model.settings.Language
import com.example.githubclient.domain.service.LanguageService

class LanguageViewModel(private val languageService: LanguageService) : ViewModel() {

    var selectedLanguage: Language by languageService::language
}