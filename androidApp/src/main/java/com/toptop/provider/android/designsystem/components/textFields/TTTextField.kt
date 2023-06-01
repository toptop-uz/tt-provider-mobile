package com.toptop.provider.android.designsystem.components.textFields

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import com.toptop.provider.android.designsystem.components.TTIcon
import com.toptop.provider.android.designsystem.theme.BodyLarge
import com.toptop.provider.android.designsystem.theme.ColorOutline
import com.toptop.provider.android.designsystem.theme.ShapeMedium

@Composable
fun TTTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    placeholder: String = "",
    trailingIcon: Painter? = null,
    trailingIconClick: (() -> Unit)? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    imeAction: ImeAction = ImeAction.Default
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        textStyle = BodyLarge,
        label = { Text(text = hint) },
        placeholder = {
            Text(
                text = placeholder,
                color = ColorOutline
            )
        },
        trailingIcon = {
            trailingIcon?.let {
                IconButton(onClick = { trailingIconClick?.invoke() }) {
                    TTIcon(
                        painter = it,
                        tint = ColorOutline
                    )
                }
            }
        },
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions(
            autoCorrect = false,
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        singleLine = true,
        shape = ShapeMedium
    )
}