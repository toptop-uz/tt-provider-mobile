package com.toptop.provider.shared

import platform.UIKit.UIDevice

actual class DeviceInfo {

    actual fun getDeviceInfo(): String {
        return "${UIDevice.currentDevice.systemName}, ${UIDevice.currentDevice.model}, ${UIDevice.currentDevice.systemVersion}"
    }

    actual fun getDeviceUniqueId(): String {
        return UIDevice.currentDevice.identifierForVendor?.UUIDString ?: randomUUID()
    }
}