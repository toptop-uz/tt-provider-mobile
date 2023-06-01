package com.toptop.provider.android.designsystem.components.buttons

import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import com.toptop.provider.android.designsystem.theme.ColorOnBackground
import com.toptop.provider.android.designsystem.theme.TitleMedium
import com.toptop.provider.android.designsystem.theme.TitleSmall

@Composable
fun TTTextButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    small: Boolean = false,
    containerColor: Color = Color.Transparent,
    contentColor: Color = ColorOnBackground,
    textStyle: TextStyle = if (small) TitleSmall else TitleMedium,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    onClick: () -> Unit
) {
    TextButton(
        onClick = onClick,
        modifier = if (small) {
            modifier.heightIn(min = TTButtonDefaults.SmallButtonHeight)
        } else {
            modifier.heightIn(min = TTButtonDefaults.NormalButtonHeight)
        },
        enabled = enabled,
        colors = TTButtonDefaults.textButtonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        contentPadding = TTButtonDefaults.buttonContentPadding(
            small = small,
            leadingIcon = leadingIcon != null,
            trailingIcon = trailingIcon != null
        ),
        content = {
            ProvideTextStyle(value = textStyle) {
                TTButtonContent(
                    text = text,
                    leadingIcon = leadingIcon,
                    trailingIcon = trailingIcon,
                    contentColor = contentColor
                )
            }
        }
    )
}