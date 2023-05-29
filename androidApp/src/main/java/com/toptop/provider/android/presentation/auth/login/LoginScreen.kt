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
import com.toptop.provider.android.navigation.navigate
import ru.alexgladkov.odyssey.compose.local.LocalRootController

@Composable
fun LoginScreen() {
    val controller = LocalRootController.current

    TTBackground {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                controller.navigate(NavigationTree.SendCode.name)
            }) {
                Text(text = "Navigate to Send code")
            }
        }
    }
}