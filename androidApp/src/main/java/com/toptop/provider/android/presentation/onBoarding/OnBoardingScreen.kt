package com.toptop.provider.android.presentation.onBoarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.toptop.provider.android.designsystem.components.TTFilledButton
import com.toptop.provider.android.designsystem.icon.TTIcons
import com.toptop.provider.android.designsystem.theme.LocalStrings
import com.toptop.provider.android.navigation.NavigationTree

@Composable
fun OnBoardingScreen(
    onNavigate: (NavigationTree) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(36.dp)
    ) {
        Image(
            imageVector = TTIcons.Logo,
            contentDescription = LocalStrings.current.appName
        )

        Text(
            text = LocalStrings.current.appDescription,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground
        )

        TTFilledButton(
            text = LocalStrings.current.getStarted,
            onClick = { onNavigate(NavigationTree.Auth) }
        )
    }
}