package com.example.githubclient.presentation

import android.app.Application
import android.content.Context
import com.example.githubclient.data.di.dataModule
import com.example.githubclient.domain.service.LanguageService
import com.example.githubclient.presentation.di.viewModelModule
import com.example.githubclient.presentation.service.language.LanguageAwareContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GithubClientApp : Application() {

    private val languageService by inject<LanguageService>()

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(LanguageAwareContext(base, application = this))
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@GithubClientApp)
            modules(
                dataModule,
                viewModelModule
            )
        }

        languageService
            .languageFlow
            .onEach {
                (baseContext as LanguageAwareContext).appLanguage = it
            }
            .launchIn(CoroutineScope(Dispatchers.Main))
    }
}