package com.toptop.provider.android.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.toptop.provider.android.navigation.TTApp
import com.toptop.provider.data.datastore.AppStore
import org.koin.android.ext.android.inject

class TTActivity : ComponentActivity() {

    private val appStore by inject<AppStore>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent { TTApp(appStore.getEntry()) }
    }
}