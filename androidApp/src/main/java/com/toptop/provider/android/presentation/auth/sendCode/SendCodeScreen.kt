package com.toptop.provider.android.presentation.auth.sendCode

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.toptop.provider.android.navigation.NavigationTree

@Composable
fun SendCodeScreen(
    onNavigate: (NavigationTree) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Navigate to Login")
    }
}