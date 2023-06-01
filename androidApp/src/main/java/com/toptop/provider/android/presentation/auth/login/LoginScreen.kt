package com.toptop.provider.android.presentation.auth.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.toptop.provider.android.core.extensions.clickableSingle
import com.toptop.provider.android.core.extensions.showToast
import com.toptop.provider.android.designsystem.components.TTIcon
import com.toptop.provider.android.designsystem.components.TTTopAppBar
import com.toptop.provider.android.designsystem.components.buttons.TTFilledButton
import com.toptop.provider.android.designsystem.components.textFields.TTPhoneTextField
import com.toptop.provider.android.designsystem.icon.TTIcons
import com.toptop.provider.android.designsystem.theme.BodyLarge
import com.toptop.provider.android.designsystem.theme.BodyMedium
import com.toptop.provider.android.designsystem.theme.ColorOutline
import com.toptop.provider.android.designsystem.theme.ColorPrimary
import com.toptop.provider.android.designsystem.theme.LocalStrings
import com.toptop.provider.android.designsystem.theme.TitleLarge
import com.toptop.provider.android.navigation.NavigationTree
import com.toptop.provider.android.presentation.components.HyperlinkText
import com.toptop.provider.presentation.auth.login.LoginEvent
import com.toptop.provider.presentation.auth.login.LoginState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    state: LoginState,
    onEvent: (LoginEvent) -> Unit,
    onNavigate: (NavigationTree) -> Unit
) {
    val context = LocalContext.current

    LaunchedEffect(state.isSuccess) {
        if (state.isSuccess) {
            onNavigate(NavigationTree.SendCode)
            onEvent(LoginEvent.Idle)
        }
    }

    LaunchedEffect(state.exception) {
        if (state.exception != null) {
            context.showToast(state.exception?.message)
            onEvent(LoginEvent.Idle)
        }
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(32.dp),
        contentPadding = PaddingValues(bottom = 20.dp)
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
                    text = LocalStrings.current.signIn,
                    style = TitleLarge,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = LocalStrings.current.youWillReceiveCode,
                    style = BodyLarge,
                    color = ColorOutline
                )
            }
        }
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                TTPhoneTextField(
                    value = state.phone,
                    onValueChange = { onEvent(LoginEvent.ChangePhone(it)) },
                    isEnabled = !state.isLoading
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickableSingle(
                            hasIndication = false,
                            onClick = { onEvent(LoginEvent.ToggleTerms) }
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    TTIcon(
                        imageVector = if (state.isTermsChecked) {
                            TTIcons.CheckCircle
                        } else {
                            TTIcons.CheckCircleOutline
                        },
                        color = if (state.isTermsChecked) {
                            ColorPrimary
                        } else {
                            ColorOutline
                        }
                    )

                    HyperlinkText(
                        fullText = LocalStrings.current.acceptTerms,
                        linkText = listOf(
                            LocalStrings.current.termsOfService,
                            LocalStrings.current.privacyPolicy
                        ),
                        hyperlinks = listOf(
                            "https://www.google.com/",
                            "https://www.google.com/",
                        ),
                        style = BodyMedium.copy(
                            color = ColorOutline
                        )
                    )
                }
            }
        }
        item {
            TTFilledButton(
                text = LocalStrings.current.signIn,
                enabled = state.isEnabled && !state.isLoading,
                onClick = { onNavigate(NavigationTree.SendCode) },
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        state = LoginState(),
        onEvent = {},
        onNavigate = {}
    )
}