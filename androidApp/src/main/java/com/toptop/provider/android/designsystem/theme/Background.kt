package com.toptop.provider.android.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@Immutable
data class BackgroundTheme(
    val color: Color = Color.Unspecified,
    val tonalElevation: Dp = Dp.Unspecified
)

val LocalBackgroundTheme = staticCompositionLocalOf { BackgroundTheme() }

val LightBackgroundTheme = BackgroundTheme(color = md_theme_light_background)
val DarkBackgroundTheme = BackgroundTheme(color = md_theme_dark_background)