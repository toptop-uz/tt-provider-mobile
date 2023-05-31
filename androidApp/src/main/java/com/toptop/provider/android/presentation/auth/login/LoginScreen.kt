package com.toptop.provider.android.presentation.auth.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.toptop.provider.android.designsystem.components.TTBackground
import com.toptop.provider.android.navigation.NavigationTree

@Composable
fun LoginScreen(
    onNavigate: (NavigationTree) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
            onNavigate(NavigationTree.SendCode)
        }) {
            Text(text = "Navigate to Send code")
        }
    }
}