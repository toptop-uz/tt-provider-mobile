package com.toptop.provider.android.designsystem.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TTFilledButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    small: Boolean = false,
    containerColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = MaterialTheme.colorScheme.onPrimary,
    textStyle: TextStyle = if (small) {
        MaterialTheme.typography.titleSmall
    } else {
        MaterialTheme.typography.titleMedium
    },
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = if (small) {
            modifier.heightIn(min = TTButtonDefaults.SmallButtonHeight)
        } else {
            modifier.heightIn(min = TTButtonDefaults.NormalButtonHeight)
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
                    trailingIcon = trailingIcon
                )
            }
        }
    )
}

@Composable
fun TTTextButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    small: Boolean = false,
    containerColor: Color = Color.Transparent,
    contentColor: Color = MaterialTheme.colorScheme.onBackground,
    textStyle: TextStyle = if (small) {
        MaterialTheme.typography.titleSmall
    } else {
        MaterialTheme.typography.titleMedium
    },
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
                    trailingIcon = trailingIcon
                )
            }
        }
    )
}

@Composable
private fun RowScope.TTButtonContent(
    text: String,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null
) {
    if (leadingIcon != null) {
        Box(Modifier.sizeIn(maxHeight = TTButtonDefaults.ButtonIconSize)) {
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

private object TTButtonDefaults {

    val SmallButtonHeight = 36.dp
    val NormalButtonHeight = 48.dp

    private const val DisabledButtonContainerAlpha = 0.12f
    private const val DisabledButtonContentAlpha = 0.38f

    private val ButtonHorizontalPadding = 24.dp
    private val SmallButtonHorizontalPadding = 16.dp

    val ButtonContentSpacing = 12.dp
    val ButtonIconSize = 24.dp

    @Composable
    fun filledButtonColors(
        containerColor: Color = MaterialTheme.colorScheme.primary,
        contentColor: Color = MaterialTheme.colorScheme.onPrimary
    ) = ButtonDefaults.buttonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = MaterialTheme.colorScheme.onBackground.copy(
            alpha = DisabledButtonContainerAlpha
        ),
        disabledContentColor = MaterialTheme.colorScheme.onBackground.copy(
            alpha = DisabledButtonContentAlpha
        )
    )

    @Composable
    fun textButtonColors(
        containerColor: Color = Color.Transparent,
        contentColor: Color = MaterialTheme.colorScheme.onBackground
    ) = ButtonDefaults.textButtonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = containerColor,
        disabledContentColor = contentColor.copy(
            alpha = DisabledButtonContentAlpha
        )
    )

    fun buttonContentPadding(
        small: Boolean,
        leadingIcon: Boolean = false,
        trailingIcon: Boolean = false
    ): PaddingValues {
        return PaddingValues(
            start = when {
                small && leadingIcon -> SmallButtonHorizontalPadding
                small -> SmallButtonHorizontalPadding
                else -> ButtonHorizontalPadding
            },
            top = 0.dp,
            end = when {
                small && trailingIcon -> SmallButtonHorizontalPadding
                small -> SmallButtonHorizontalPadding
                else -> ButtonHorizontalPadding
            },
            bottom = 0.dp
        )
    }
}