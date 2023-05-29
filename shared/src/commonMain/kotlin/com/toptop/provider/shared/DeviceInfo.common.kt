package com.toptop.provider.shared

expect class DeviceInfo {

    fun getDeviceInfo(): String

    fun getDeviceUniqueId(): String
}

