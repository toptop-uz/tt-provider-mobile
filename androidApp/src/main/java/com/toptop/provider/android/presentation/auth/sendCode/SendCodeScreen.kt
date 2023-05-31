package com.toptop.provider.android.presentation.auth.sendCode

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.toptop.provider.android.designsystem.components.TTTopAppBar
import com.toptop.provider.android.designsystem.icon.TTIcons
import com.toptop.provider.android.designsystem.theme.LocalStrings
import com.toptop.provider.android.navigation.NavigationTree
import com.toptop.provider.presentation.auth.sendCode.SendCodeEvent
import com.toptop.provider.presentation.auth.sendCode.SendCodeState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SendCodeScreen(
    state: SendCodeState,
    onEvent: (SendCodeEvent) -> Unit,
    onNavigate: (NavigationTree) -> Unit
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        item {
            TTTopAppBar(
                navigationIcon = TTIcons.ArrowBack,
                onNavigationClick = { onNavigate(NavigationTree.NavigateUp) }
            )
        }
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    text = LocalStrings.current.verifyYourAccount,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = LocalStrings.current.weHaveSentCode("+998946444247"),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.outline
                )
            }
        }
    }
}