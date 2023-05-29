package com.toptop.provider.android.presentation.auth.sendCode

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.toptop.provider.android.designsystem.components.TTBackground
import com.toptop.provider.android.navigation.NavigationTree
import ru.alexgladkov.odyssey.compose.local.LocalRootController

@Composable
fun SendCodeScreen() {
    val controller = LocalRootController.current

    TTBackground {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Button(onClick = {
                controller.backToScreen(NavigationTree.Login.name)
            }) {
                Text(text = "Navigate to Login")
            }
        }
    }
}