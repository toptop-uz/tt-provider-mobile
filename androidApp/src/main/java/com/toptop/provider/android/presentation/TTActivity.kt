package com.toptop.provider.android.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.toArgb
import androidx.core.view.WindowCompat
import com.toptop.provider.android.designsystem.theme.TTTheme
import com.toptop.provider.android.navigation.navigationGraph
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent
import ru.alexgladkov.odyssey.core.configuration.DisplayType

class TTActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            TTTheme {
                val configuration = OdysseyConfiguration(
                    canvas = this,
                    displayType = DisplayType.EdgeToEdge,
                    backgroundColor = MaterialTheme.colorScheme.background,
                    navigationBarColor = MaterialTheme.colorScheme.background.toArgb()
                )

                setNavigationContent(configuration) {
                    navigationGraph(
                        onApplicationFinish = { finish() }
                    )
                }
            }
        }
    }
}