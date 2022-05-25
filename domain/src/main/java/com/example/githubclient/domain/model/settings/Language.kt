package com.example.githubclient.domain.model.settings

import java.util.*

enum class Language(
    val locale: Locale
) {
    EN(Locale.ENGLISH),
    RU(Locale("ru"))
}