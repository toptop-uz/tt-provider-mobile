package com.toptop.provider.shared

import kotlinx.coroutines.Dispatchers
import java.util.UUID

actual val appUrl: String
    get() = "https://play.google.com/store/apps/details?id=com.toptop.provider.android"

actual fun randomUUID() = UUID.randomUUID().toString()

actual val mainDispatcher = Dispatchers.Main
actual val ioDispatcher = Dispatchers.IO