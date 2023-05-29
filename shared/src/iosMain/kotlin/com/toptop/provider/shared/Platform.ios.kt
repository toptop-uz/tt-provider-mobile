package com.toptop.provider.shared

import kotlinx.coroutines.Dispatchers
import platform.CoreFoundation.CFUUIDCreate
import platform.CoreFoundation.CFUUIDCreateString
import platform.Foundation.CFBridgingRelease

actual val appUrl: String
    get() = "https://play.google.com/store/apps/details?id=com.toptop.provider.android"

actual fun randomUUID(): String =
    CFBridgingRelease(CFUUIDCreateString(null, CFUUIDCreate(null))) as String

actual val mainDispatcher = Dispatchers.Main
actual val ioDispatcher = Dispatchers.Default