package com.toptop.provider.android.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color

val ColorBrand = Color(0xFF696CFF)

val ColorPrimary: Color
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.colorScheme.primary

val ColorOnPrimary: Color
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.colorScheme.onPrimary

val ColorOnBackground: Color
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.colorScheme.onBackground

val ColorOutline: Color
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.colorScheme.outline

val ColorDivider: Color
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)

val md_theme_light_primary = Color(0xFF4748DD)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_primaryContainer = Color(0xFFE1E0FF)
val md_theme_light_onPrimaryContainer = Color(0xFF07006C)
val md_theme_light_secondary = Color(0xFF5D5C72)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_secondaryContainer = Color(0xFFE2E0F9)
val md_theme_light_onSecondaryContainer = Color(0xFF191A2C)
val md_theme_light_tertiary = Color(0xFF795369)
val md_theme_light_onTertiary = Color(0xFFFFFFFF)
val md_theme_light_tertiaryContainer = Color(0xFFFFD8EC)
val md_theme_light_onTertiaryContainer = Color(0xFF2E1125)
val md_theme_light_error = Color(0xFFBA1A1A)
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_onErrorContainer = Color(0xFF410002)
val md_theme_light_background = Color(0xFFFFFBFF)
val md_theme_light_onBackground = Color(0xFF1C1B1F)
val md_theme_light_surface = Color(0xFFFFFBFF)
val md_theme_light_onSurface = Color(0xFF1C1B1F)
val md_theme_light_surfaceVariant = Color(0xFFE4E1EC)
val md_theme_light_onSurfaceVariant = Color(0xFF47464F)
val md_theme_light_outline = Color(0xFF777680)
val md_theme_light_inverseOnSurface = Color(0xFFF3EFF4)
val md_theme_light_inverseSurface = Color(0xFF313034)
val md_theme_light_inversePrimary = Color(0xFFC0C1FF)
val md_theme_light_surfaceTint = Color(0xFF4748DD)
val md_theme_light_outlineVariant = Color(0xFFC8C5D0)
val md_theme_light_scrim = Color(0xFF000000)

val md_theme_dark_primary = Color(0xFFC0C1FF)
val md_theme_dark_onPrimary = Color(0xFF1100A9)
val md_theme_dark_primaryContainer = Color(0xFF2C2AC5)
val md_theme_dark_onPrimaryContainer = Color(0xFFE1E0FF)
val md_theme_dark_secondary = Color(0xFFC6C4DD)
val md_theme_dark_onSecondary = Color(0xFF2E2F42)
val md_theme_dark_secondaryContainer = Color(0xFF454559)
val md_theme_dark_onSecondaryContainer = Color(0xFFE2E0F9)
val md_theme_dark_tertiary = Color(0xFFE9B9D3)
val md_theme_dark_onTertiary = Color(0xFF46263A)
val md_theme_dark_tertiaryContainer = Color(0xFF5F3C51)
val md_theme_dark_onTertiaryContainer = Color(0xFFFFD8EC)
val md_theme_dark_error = Color(0xFFFFB4AB)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_onError = Color(0xFF690005)
val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)
val md_theme_dark_background = Color(0xFF1C1B1F)
val md_theme_dark_onBackground = Color(0xFFE5E1E6)
val md_theme_dark_surface = Color(0xFF1C1B1F)
val md_theme_dark_onSurface = Color(0xFFE5E1E6)
val md_theme_dark_surfaceVariant = Color(0xFF47464F)
val md_theme_dark_onSurfaceVariant = Color(0xFFC8C5D0)
val md_theme_dark_outline = Color(0xFF918F9A)
val md_theme_dark_inverseOnSurface = Color(0xFF1C1B1F)
val md_theme_dark_inverseSurface = Color(0xFFE5E1E6)
val md_theme_dark_inversePrimary = Color(0xFF4748DD)
val md_theme_dark_surfaceTint = Color(0xFFC0C1FF)
val md_theme_dark_outlineVariant = Color(0xFF47464F)
val md_theme_dark_scrim = Color(0xFF000000)

val LightColorScheme = lightColorScheme(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    primaryContainer = md_theme_light_primaryContainer,
    onPrimaryContainer = md_theme_light_onPrimaryContainer,
    secondary = md_theme_light_secondary,
    onSecondary = md_theme_light_onSecondary,
    secondaryContainer = md_theme_light_secondaryContainer,
    onSecondaryContainer = md_theme_light_onSecondaryContainer,
    tertiary = md_theme_light_tertiary,
    onTertiary = md_theme_light_onTertiary,
    tertiaryContainer = md_theme_light_tertiaryContainer,
    onTertiaryContainer = md_theme_light_onTertiaryContainer,
    error = md_theme_light_error,
    errorContainer = md_theme_light_errorContainer,
    onError = md_theme_light_onError,
    onErrorContainer = md_theme_light_onErrorContainer,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
    surfaceVariant = md_theme_light_surfaceVariant,
    onSurfaceVariant = md_theme_light_onSurfaceVariant,
    outline = md_theme_light_outline,
    inverseOnSurface = md_theme_light_inverseOnSurface,
    inverseSurface = md_theme_light_inverseSurface,
    inversePrimary = md_theme_light_inversePrimary,
    surfaceTint = md_theme_light_surfaceTint,
    outlineVariant = md_theme_light_outlineVariant,
    scrim = md_theme_light_scrim,
)


val DarkColorScheme = darkColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    primaryContainer = md_theme_dark_primaryContainer,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    secondaryContainer = md_theme_dark_secondaryContainer,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer,
    tertiary = md_theme_dark_tertiary,
    onTertiary = md_theme_dark_onTertiary,
    tertiaryContainer = md_theme_dark_tertiaryContainer,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer,
    error = md_theme_dark_error,
    errorContainer = md_theme_dark_errorContainer,
    onError = md_theme_dark_onError,
    onErrorContainer = md_theme_dark_onErrorContainer,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    surfaceVariant = md_theme_dark_surfaceVariant,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant,
    outline = md_theme_dark_outline,
    inverseOnSurface = md_theme_dark_inverseOnSurface,
    inverseSurface = md_theme_dark_inverseSurface,
    inversePrimary = md_theme_dark_inversePrimary,
    surfaceTint = md_theme_dark_surfaceTint,
    outlineVariant = md_theme_dark_outlineVariant,
    scrim = md_theme_dark_scrim,
)