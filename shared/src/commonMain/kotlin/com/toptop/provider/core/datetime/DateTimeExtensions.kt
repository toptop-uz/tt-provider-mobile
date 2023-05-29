package com.toptop.provider.core.datetime

import kotlinx.datetime.Clock

fun currentUtcDate(): String {
    return Clock.System.now().toString()
}

fun currentTimestamp(): Long {
    return Clock.System.now().toEpochMilliseconds()
}