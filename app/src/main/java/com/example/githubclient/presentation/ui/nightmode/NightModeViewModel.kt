package com.example.githubclient.presentation.ui.nightmode

import androidx.lifecycle.ViewModel
import com.example.githubclient.domain.service.NightModeService

class NightModeViewModel(private val prefsService: NightModeService) : ViewModel() {

    var selectedNightMode by prefsService::nightMode
}