package com.toptop.provider.core.logger

import com.toptop.provider.core.datetime.currentTimestamp

fun Any?.log() {
    println("LOG_TAG: ${this?.toString()}")
}

inline fun tryCatch(onTryAction: () -> Unit) {
    try {
        onTryAction()
    } catch (_: Throwable) {
    }
}

inline fun shouldRequest(
    timestamp: Long,
    delay: Long,
    onChangeAction: (Long) -> Unit
): Boolean {
    val currentTimestamp = currentTimestamp()
    if (currentTimestamp - timestamp < delay) return false
    onChangeAction(currentTimestamp)
    return true
}