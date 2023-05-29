package com.toptop.provider.shared

import android.annotation.SuppressLint
import android.content.Context
import android.net.wifi.WifiManager
import android.os.Build
import com.toptop.provider.core.logger.tryCatch

actual class DeviceInfo(private val context: Context) {

    actual fun getDeviceInfo(): String {
        return "Android, ${Build.MANUFACTURER} ${Build.MODEL}, ${Build.VERSION.SDK_INT}"
    }

    @SuppressLint("HardwareIds")
    @Suppress("DEPRECATION")
    actual fun getDeviceUniqueId(): String {
        var uniqueId: String? = null

        tryCatch {
            val wifiManager =
                context.applicationContext.getSystemService(Context.WIFI_SERVICE) as? WifiManager
            val wifiInfo = wifiManager?.connectionInfo
            uniqueId = wifiInfo?.macAddress
        }

        return uniqueId ?: randomUUID()
    }
}