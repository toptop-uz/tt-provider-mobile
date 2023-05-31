package com.toptop.provider.android.presentation.base

import androidx.compose.runtime.Composable
import com.toptop.provider.android.designsystem.components.TTBackground
import ru.alexgladkov.odyssey.compose.RootController
import ru.alexgladkov.odyssey.compose.local.LocalRootController

@Composable
fun BaseScreenWrapper(
    onApplicationFinish: (() -> Unit)? = null,
    content: @Composable (RootController) -> Unit
) {
    val controller = LocalRootController.current
    controller.onApplicationFinish = onApplicationFinish

    TTBackground { content(controller) }
}