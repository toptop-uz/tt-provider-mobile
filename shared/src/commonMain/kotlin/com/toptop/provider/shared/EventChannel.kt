package com.toptop.provider.shared

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object EventChannel {

    private val channel = Channel<Event>()

    fun sendEvent(event: Event) {
        channel.trySend(event)
    }

    fun receiveEvent(): Flow<Event> {
        return channel.receiveAsFlow()
    }
}

enum class Event {
    Unauthorized
}