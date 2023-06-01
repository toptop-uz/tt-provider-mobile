package com.toptop.provider.android.designsystem.theme

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.unit.dp

val ShapeLarge: CornerBasedShape
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.shapes.large

val ShapeMedium: CornerBasedShape
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.shapes.medium

val ShapeSmall: CornerBasedShape
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.shapes.small

val Shapes = Shapes(
    extraSmall = RoundedCornerShape(1.dp),
    small = RoundedCornerShape(5.dp),
    medium = RoundedCornerShape(10.dp),
    large = RoundedCornerShape(15.dp),
    extraLarge = RoundedCornerShape(20.dp)
)