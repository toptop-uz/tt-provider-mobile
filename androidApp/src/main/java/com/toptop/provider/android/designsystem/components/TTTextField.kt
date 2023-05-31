package com.toptop.provider.android.designsystem.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.toptop.provider.android.designsystem.icon.TTIcons
import com.toptop.provider.android.designsystem.theme.LocalStrings

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
        textStyle = MaterialTheme.typography.bodyLarge,
        label = { Text(text = hint) },
        placeholder = {
            Text(
                text = placeholder,
                color = MaterialTheme.colorScheme.outline
            )
        },
        trailingIcon = {
            trailingIcon?.let {
                IconButton(onClick = { trailingIconClick?.invoke() }) {
                    TTIcon(
                        painter = it,
                        tint = MaterialTheme.colorScheme.outline
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
        shape = MaterialTheme.shapes.medium
    )
}

@Composable
fun TTPhoneTextField(
    value: String,
    onValueChange: (String) -> Unit,
    imeAction: ImeAction = ImeAction.Done
) {
    var isFocused by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = LocalStrings.current.yourNumber,
            style = MaterialTheme.typography.bodyMedium,
            color = if (isFocused) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.onBackground
            },
            fontWeight = FontWeight.SemiBold
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.medium)
                .border(
                    width = if (isFocused) (1.5).dp else 1.dp,
                    shape = MaterialTheme.shapes.medium,
                    color = if (isFocused) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.outline.copy(alpha = 0.35f)
                    }
                )
                .padding(16.dp)
        ) {
            Image(
                imageVector = TTIcons.FlagUz,
                contentDescription = LocalStrings.current.uzbek,
                modifier = Modifier.size(20.dp)
            )

            Text(
                text = "+998",
                style = MaterialTheme.typography.bodyLarge
            )

            Divider(
                modifier = Modifier
                    .width(1.dp)
                    .height(20.dp),
                color = MaterialTheme.colorScheme.outline.copy(alpha = 0.35f)
            )

            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusChanged {
                        isFocused = it.isFocused
                    },
                textStyle = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.onBackground
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    autoCorrect = false,
                    keyboardType = KeyboardType.Phone,
                    imeAction = imeAction
                ),
                cursorBrush = Brush.horizontalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.outline,
                        MaterialTheme.colorScheme.outline
                    )
                ),
                decorationBox = { innerTextField ->
                    if (value.isEmpty()) {
                        Text(
                            text = "90 000 00 00",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.outline,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    innerTextField()
                }
            )
        }
    }
}