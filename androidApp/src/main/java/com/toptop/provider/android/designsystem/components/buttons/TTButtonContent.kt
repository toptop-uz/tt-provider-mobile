package com.toptop.provider.android.designsystem.components.buttons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.toptop.provider.android.designsystem.components.TTIcon

@Composable
fun RowScope.TTButtonContent(
    text: String,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null
) {
    if (leadingIcon != null) {
        Box(
            modifier = Modifier.sizeIn(
                maxHeight = TTButtonDefaults.ButtonIconSize
            )
        ) {
            TTIcon(imageVector = leadingIcon)
        }
    }

    Box(
        Modifier
            .weight(1f, fill = false)
            .padding(
                start = if (leadingIcon != null) {
                    TTButtonDefaults.ButtonContentSpacing
                } else {
                    0.dp
                },
                end = if (trailingIcon != null) {
                    TTButtonDefaults.ButtonContentSpacing
                } else {
                    0.dp
                }
            )
    ) {
        Text(text = text)
    }

    if (trailingIcon != null) {
        Box(Modifier.sizeIn(maxHeight = TTButtonDefaults.ButtonIconSize)) {
            TTIcon(imageVector = trailingIcon)
        }
    }
}