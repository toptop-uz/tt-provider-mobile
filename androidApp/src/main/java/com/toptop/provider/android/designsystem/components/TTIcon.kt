package com.toptop.provider.android.designsystem.components

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import com.toptop.provider.android.designsystem.theme.ColorPrimary

@Composable
fun TTIcon(
    imageVector: ImageVector,
    modifier: Modifier = Modifier,
    color: Color = ColorPrimary,
) {
    Icon(
        imageVector = imageVector,
        contentDescription = null,
        modifier = modifier,
        tint = color
    )
}

@Composable
fun TTIcon(
    painter: Painter,
    modifier: Modifier = Modifier,
    tint: Color = ColorPrimary,
) {
    Icon(
        painter = painter,
        contentDescription = null,
        modifier = modifier,
        tint = tint
    )
}