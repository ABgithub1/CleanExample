package com.example.githubclient.presentation.extension

import android.view.View
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.doOnAttach
import androidx.core.view.updatePadding
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout

fun View.doOnApplyWindowInsets(
    initialOffset: Offset = Offset(),
    action: (View, WindowInsetsCompat, Offset) -> WindowInsetsCompat
) {
    ViewCompat.setOnApplyWindowInsetsListener(this) { v, insets ->
        action(v, insets, initialOffset)
    }

    doOnAttach {
        it.requestApplyInsets()
    }
}

data class Offset(
    val left: Int = 0,
    val top: Int = 0,
    val right: Int = 0,
    val bottom: Int = 0
)

fun AppBarLayout.applyWindowInsets() {
    doOnApplyWindowInsets { view, insets, _ ->
        val systemBarInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        view.updatePadding(
            top = systemBarInsets.top,
            left = systemBarInsets.left,
            right = systemBarInsets.right
        )
        WindowInsetsCompat.Builder(insets)
            .setInsets(WindowInsetsCompat.Type.systemBars(), Insets.NONE)
            .build()
    }
}

fun RecyclerView.applyHorizontalWindowInsets() {
    doOnApplyWindowInsets(
        initialOffset = Offset(
            left = paddingLeft,
            right = paddingRight
        )
    ) { view, insets, offset ->
        val systemBarInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars())
        view.updatePadding(
            left = systemBarInsets.left + offset.left,
            right = systemBarInsets.right + offset.right
        )
        insets
    }
}