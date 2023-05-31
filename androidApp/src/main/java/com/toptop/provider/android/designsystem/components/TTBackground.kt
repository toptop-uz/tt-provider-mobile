package com.toptop.provider.android.designsystem.components

import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.toptop.provider.android.designsystem.theme.LocalBackgroundTheme

@Composable
fun TTBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val color = LocalBackgroundTheme.current.color
    val tonalElevation = LocalBackgroundTheme.current.tonalElevation

    Surface(
        color = if (color == Color.Unspecified) Color.Transparent else color,
        tonalElevation = if (tonalElevation == Dp.Unspecified) 0.dp else tonalElevation,
        modifier = modifier
            .fillMaxSize()
            .displayCutoutPadding()
            .statusBarsPadding()
            .navigationBarsPadding()
            .imePadding()
    ) {
        CompositionLocalProvider(LocalAbsoluteTonalElevation provides 0.dp) {
            content()
        }
    }
}