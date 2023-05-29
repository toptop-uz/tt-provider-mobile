package com.toptop.provider.core.helpers

object Helpers {

    fun Int.az(): String = if (this >= 10) "" + this else "0$this"
}