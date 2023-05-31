package com.toptop.provider.android.designsystem.components.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

object TTButtonDefaults {

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