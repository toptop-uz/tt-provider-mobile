package com.toptop.provider.android.designsystem.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.toptop.provider.android.designsystem.components.extensions.clickableSingle

@Composable
fun TTCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    color: Color = MaterialTheme.colorScheme.surfaceVariant,
    contentColor: Color = contentColorFor(color),
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val shadowModifier = if (darkTheme) {
        modifier
    } else {
        modifier.shadow(
            elevation = 8.dp,
            shape = MaterialTheme.shapes.medium,
            ambientColor = MaterialTheme.colorScheme.outline,
            spotColor = MaterialTheme.colorScheme.outline
        )
    }

    Surface(
        modifier = shadowModifier,
        shape = MaterialTheme.shapes.medium,
        color = color,
        contentColor = contentColor
    ) {
        Box(modifier = Modifier.clickableSingle(onClick = onClick)) {
            content()
        }
    }
}