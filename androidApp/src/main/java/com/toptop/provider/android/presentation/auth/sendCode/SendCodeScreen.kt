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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.toptop.provider.android.core.extensions.showToast
import com.toptop.provider.android.designsystem.components.TTTopAppBar
import com.toptop.provider.android.designsystem.components.buttons.TTTextButton
import com.toptop.provider.android.designsystem.components.textFields.TTOtpTextField
import com.toptop.provider.android.designsystem.icon.TTIcons
import com.toptop.provider.android.designsystem.theme.LocalStrings
import com.toptop.provider.android.navigation.NavigationTree
import com.toptop.provider.presentation.auth.login.LoginEvent
import com.toptop.provider.presentation.auth.sendCode.SendCodeEvent
import com.toptop.provider.presentation.auth.sendCode.SendCodeState
import com.toptop.provider.presentation.auth.sendCode.SendCodeType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SendCodeScreen(
    state: SendCodeState,
    onEvent: (SendCodeEvent) -> Unit,
    onNavigate: (NavigationTree) -> Unit
) {
    val context = LocalContext.current

    LaunchedEffect(state.exception) {
        if (state.exception != null) {
            context.showToast(state.exception?.message)
            onEvent(SendCodeEvent.Idle)
        }
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
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
                horizontalAlignment = Alignment.Start
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
        item {
            TTOtpTextField(
                modifier = Modifier.padding(horizontal = 20.dp),
                value = state.code,
                onValueChange = {
                    onEvent(SendCodeEvent.ChangeCode(it))
                },
                isError = state.exception != null,
                isEnabled = !state.isLoading
            )
        }
        item {
            when (state.type) {
                SendCodeType.ResendCode -> {
                    Column(
                        modifier = Modifier.padding(horizontal = 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = LocalStrings.current.didntReceiveCode,
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.outline
                        )

                        TTTextButton(
                            text = LocalStrings.current.resendCode,
                            onClick = { onEvent(SendCodeEvent.ResendCode) },
                            small = true,
                            contentColor = MaterialTheme.colorScheme.primary,
                            textStyle = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.Medium
                            )
                        )
                    }
                }

                SendCodeType.Timer -> {
                    Text(
                        text = LocalStrings.current.resendCodeIn("00:35"),
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )
                }

                else -> {}
            }
        }
    }
}