package com.toptop.provider.android.core.extensions

import android.content.Context
import android.widget.Toast

fun Context.showToast(message: String?) {
    Toast.makeText(this, message.orEmpty(), Toast.LENGTH_SHORT).show()
}