package com.toptop.provider.android.designsystem.components

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import com.toptop.provider.core.resources.TTStrings

@Composable
fun TTIcon(
    imageVector: ImageVector,
    modifier: Modifier = Modifier,
    tint: Color = MaterialTheme.colorScheme.onSurface,
) {
    Icon(
        imageVector = imageVector,
        contentDescription = TTStrings.imageContent,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun TTIcon(
    painter: Painter,
    modifier: Modifier = Modifier,
    tint: Color = MaterialTheme.colorScheme.onSurface,
) {
    Icon(
        painter = painter,
        contentDescription = TTStrings.imageContent,
        modifier = modifier,
        tint = tint
    )
}