package com.toptop.provider.android.designsystem.components.textFields

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
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.toptop.provider.android.designsystem.icon.TTIcons
import com.toptop.provider.android.designsystem.theme.BodyLarge
import com.toptop.provider.android.designsystem.theme.ColorDivider
import com.toptop.provider.android.designsystem.theme.ColorOnBackground
import com.toptop.provider.android.designsystem.theme.ColorOutline
import com.toptop.provider.android.designsystem.theme.ColorPrimary
import com.toptop.provider.android.designsystem.theme.LocalStrings
import com.toptop.provider.android.designsystem.theme.ShapeMedium

@Composable
fun TTPhoneTextField(
    value: String,
    onValueChange: (String) -> Unit,
    imeAction: ImeAction = ImeAction.Done,
    isEnabled: Boolean = true
) {
    var isFocused by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = LocalStrings.current.yourNumber,
            style = BodyLarge,
            color = if (isFocused) {
                ColorPrimary
            } else {
                ColorOnBackground
            },
            fontWeight = FontWeight.SemiBold
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .clip(ShapeMedium)
                .border(
                    width = if (isFocused) (1.5).dp else 1.dp,
                    shape = ShapeMedium,
                    color = if (isFocused) {
                        ColorPrimary
                    } else {
                        ColorDivider
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
                style = BodyLarge
            )

            Divider(
                modifier = Modifier
                    .width(1.dp)
                    .height(20.dp),
                color = ColorDivider
            )

            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusChanged {
                        isFocused = it.isFocused
                    },
                textStyle = BodyLarge.copy(
                    color = ColorOnBackground
                ),
                singleLine = true,
                enabled = isEnabled,
                keyboardOptions = KeyboardOptions(
                    autoCorrect = false,
                    keyboardType = KeyboardType.Phone,
                    imeAction = imeAction
                ),
                cursorBrush = SolidColor(ColorOutline),
                decorationBox = { innerTextField ->
                    if (value.isEmpty()) {
                        Text(
                            text = "90 000 00 00",
                            style = BodyLarge,
                            color = ColorOutline,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    innerTextField()
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TTPhoneTextFieldPreview() {
    TTPhoneTextField(
        value = "",
        onValueChange = {}
    )
}