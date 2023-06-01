package com.toptop.provider.android.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.dp
import com.toptop.provider.data.model.type.LanguageType
import com.toptop.provider.resources.stringResourcesUz

@Composable
fun TTTheme(
    language: LanguageType,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val backgroundTheme = if (darkTheme) DarkBackgroundTheme else LightBackgroundTheme
    val stringResources = when (language) {
        LanguageType.English -> stringResourcesUz()
        LanguageType.Russian -> stringResourcesUz()
        else -> stringResourcesUz()
    }

    CompositionLocalProvider(
        LocalBackgroundTheme provides backgroundTheme,
        LocalStrings provides stringResources
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}