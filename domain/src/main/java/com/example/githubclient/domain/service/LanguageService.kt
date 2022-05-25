package com.example.githubclient.domain.service

import com.example.githubclient.domain.model.settings.Language
import kotlinx.coroutines.flow.Flow

interface LanguageService {

    var language: Language
    val languageFlow: Flow<Language>
}