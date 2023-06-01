package com.toptop.provider.android.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.toptop.provider.android.R

val HeadlineLarge: TextStyle
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.typography.headlineLarge

val TitleLarge: TextStyle
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.typography.titleLarge

val TitleMedium: TextStyle
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.typography.titleMedium

val TitleSmall: TextStyle
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.typography.titleSmall

val BodyLarge: TextStyle
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.typography.bodyLarge

val BodyMedium: TextStyle
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.typography.bodyMedium

val Typography = Typography(
    displayLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontFamily = fontFamily,
        fontSize = 56.sp,
        letterSpacing = (-0.25).sp
    ),
    displayMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        fontFamily = fontFamily,
        fontSize = 42.sp
    ),
    displaySmall = TextStyle(
        fontWeight = FontWeight.Bold,
        fontFamily = fontFamily,
        fontSize = 36.sp
    ),
    headlineLarge = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontFamily = fontFamily,
        fontSize = 32.sp
    ),
    headlineMedium = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontFamily = fontFamily,
        fontSize = 28.sp
    ),
    headlineSmall = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontFamily = fontFamily,
        fontSize = 24.sp
    ),
    titleLarge = TextStyle(
        fontWeight = FontWeight.Medium,
        fontFamily = fontFamily,
        fontSize = 22.sp
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.Medium,
        fontFamily = fontFamily,
        fontSize = 18.sp,
        letterSpacing = 0.1.sp
    ),
    titleSmall = TextStyle(
        fontWeight = FontWeight.Medium,
        fontFamily = fontFamily,
        fontSize = 14.sp,
        letterSpacing = 0.1.sp
    ),
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontFamily = fontFamily,
        fontSize = 16.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Normal,
        fontFamily = fontFamily,
        fontSize = 14.sp,
        letterSpacing = 0.25.sp
    ),
    bodySmall = TextStyle(
        fontWeight = FontWeight.Normal,
        fontFamily = fontFamily,
        fontSize = 12.sp,
        letterSpacing = 0.4.sp
    ),
    labelLarge = TextStyle(
        fontWeight = FontWeight.Light,
        fontFamily = fontFamily,
        fontSize = 14.sp,
        letterSpacing = 0.1.sp
    ),
    labelMedium = TextStyle(
        fontWeight = FontWeight.Light,
        fontFamily = fontFamily,
        fontSize = 12.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontWeight = FontWeight.Light,
        fontFamily = fontFamily,
        fontSize = 10.sp
    )
)

private val fontFamily
    get() = FontFamily(
        Font(R.font.light, FontWeight.Light),
        Font(R.font.regular, FontWeight.Normal),
        Font(R.font.medium, FontWeight.Medium),
        Font(R.font.semibold, FontWeight.SemiBold),
        Font(R.font.bold, FontWeight.Bold)
    )