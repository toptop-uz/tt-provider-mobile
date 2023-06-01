package com.toptop.provider.android.designsystem.components.textFields

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.toptop.provider.android.core.extensions.vibrateFeedback
import com.toptop.provider.android.designsystem.theme.ColorDivider
import com.toptop.provider.android.designsystem.theme.ColorOnBackground
import com.toptop.provider.android.designsystem.theme.ColorOutline
import com.toptop.provider.android.designsystem.theme.ColorPrimary
import com.toptop.provider.android.designsystem.theme.HeadlineLarge
import com.toptop.provider.android.designsystem.theme.ShapeMedium

@Composable
fun TTOtpTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    count: Int = 4,
    isError: Boolean = false,
    isEnabled: Boolean = true
) {
    BasicTextField(
        modifier = modifier.vibrateFeedback(isError = isError),
        value = TextFieldValue(value, selection = TextRange(value.length)),
        onValueChange = {
            if (it.text.length <= count) {
                onValueChange(it.text)
            }
        },
        enabled = isEnabled,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword,
            imeAction = ImeAction.Done
        ),
        decorationBox = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    space = 12.dp,
                    alignment = Alignment.CenterHorizontally
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(count) { index ->
                    CharView(
                        index = index,
                        text = value
                    )
                }
            }
        }
    )
}

@Composable
private fun CharView(
    index: Int,
    text: String
) {
    val char = when {
        index == text.length -> ""
        index > text.length -> ""
        else -> text[index].toString()
    }

    Text(
        modifier = Modifier
            .width(54.dp)
            .clip(ShapeMedium)
            .background(ColorOutline.copy(alpha = 0.1f))
            .border(
                width = if (char.isEmpty()) 1.dp else (1.5).dp,
                color = if (char.isEmpty()) {
                    ColorDivider
                } else {
                    ColorPrimary
                },
                shape = ShapeMedium
            )
            .padding(vertical = 12.dp),
        text = char,
        style = HeadlineLarge,
        color = if (char.isEmpty()) {
            ColorOnBackground
        } else {
            ColorPrimary
        },
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun TTOtpTextFieldPreview() {
    TTOtpTextField(
        value = "12",
        onValueChange = {}
    )
}