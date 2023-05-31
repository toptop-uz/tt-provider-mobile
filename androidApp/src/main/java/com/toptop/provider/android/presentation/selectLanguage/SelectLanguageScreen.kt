package com.toptop.provider.android.presentation.selectLanguage

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.toptop.provider.android.core.extensions.clickableSingle
import com.toptop.provider.android.designsystem.components.TTIcon
import com.toptop.provider.android.designsystem.components.buttons.TTFilledButton
import com.toptop.provider.android.designsystem.icon.TTIcons
import com.toptop.provider.android.designsystem.theme.LocalStrings
import com.toptop.provider.android.navigation.NavigationTree
import com.toptop.provider.data.model.type.LanguageType
import com.toptop.provider.presentation.selectLanguage.SelectLanguageEvent
import com.toptop.provider.presentation.selectLanguage.SelectLanguageState

@Composable
fun SelectLanguageScreen(
    state: SelectLanguageState,
    onEvent: (SelectLanguageEvent) -> Unit,
    onNavigate: (NavigationTree) -> Unit
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(32.dp),
        contentPadding = PaddingValues(
            top = 48.dp,
            start = 20.dp,
            end = 20.dp,
            bottom = 20.dp
        )
    ) {
        item {
            Image(
                imageVector = TTIcons.Logo,
                contentDescription = LocalStrings.current.appName,
                modifier = Modifier.height(56.dp)
            )
        }
        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = LocalStrings.current.chooseYourLanguage,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = LocalStrings.current.pleaseSelectLanguage,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.outline
                )
            }
        }
        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                LanguageItem(
                    title = LocalStrings.current.uzbek,
                    icon = TTIcons.FlagUz,
                    isSelected = state.selectedLanguage == LanguageType.Uzbek,
                    onClick = {
                        onEvent(SelectLanguageEvent.SelectLanguage(LanguageType.Uzbek))
                    }
                )

                LanguageItem(
                    title = LocalStrings.current.english,
                    icon = TTIcons.FlagEn,
                    isSelected = state.selectedLanguage == LanguageType.English,
                    onClick = {
                        onEvent(SelectLanguageEvent.SelectLanguage(LanguageType.English))
                    }
                )

                LanguageItem(
                    title = LocalStrings.current.russian,
                    icon = TTIcons.FlagRu,
                    isSelected = state.selectedLanguage == LanguageType.Russian,
                    onClick = {
                        onEvent(SelectLanguageEvent.SelectLanguage(LanguageType.Russian))
                    }
                )
            }
        }
        item {
            TTFilledButton(
                text = LocalStrings.current.getStarted,
                onClick = { onNavigate(NavigationTree.Auth) }
            )
        }
    }
}

@Composable
private fun LanguageItem(
    title: String,
    icon: ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium)
            .border(
                width = if (isSelected) (1.5).dp else 1.dp,
                shape = MaterialTheme.shapes.medium,
                color = if (isSelected) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.outline.copy(alpha = 0.35f)
                }
            )
            .clickableSingle(onClick = onClick)
            .padding(16.dp)
    ) {
        Image(
            imageVector = icon,
            contentDescription = title,
            modifier = Modifier.size(24.dp)
        )

        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            color = if (isSelected) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.onBackground
            }
        )

        if (isSelected) {
            Spacer(modifier = Modifier.weight(1f))

            TTIcon(
                imageVector = TTIcons.Check,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}