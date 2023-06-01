package com.toptop.provider.android.designsystem.components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Button
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.toptop.provider.android.designsystem.theme.ColorOnPrimary
import com.toptop.provider.android.designsystem.theme.ColorPrimary
import com.toptop.provider.android.designsystem.theme.TitleMedium
import com.toptop.provider.android.designsystem.theme.TitleSmall

@Composable
fun TTFilledButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    small: Boolean = false,
    containerColor: Color = ColorPrimary,
    contentColor: Color = ColorOnPrimary,
    textStyle: TextStyle = if (small) TitleSmall else TitleMedium,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = if (small) {
            modifier
                .fillMaxWidth()
                .heightIn(min = TTButtonDefaults.SmallButtonHeight)
        } else {
            modifier
                .fillMaxWidth()
                .heightIn(min = TTButtonDefaults.NormalButtonHeight)
        },
        enabled = enabled,
        colors = TTButtonDefaults.filledButtonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        contentPadding = TTButtonDefaults.buttonContentPadding(
            small = small,
            leadingIcon = leadingIcon != null,
            trailingIcon = trailingIcon != null
        ),
        content = {
            ProvideTextStyle(
                value = textStyle.copy(
                    fontWeight = FontWeight.SemiBold
                )
            ) {
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