package com.toptop.provider.shared

import android.content.ContentResolver
import android.net.Uri

actual typealias ImageFile = ImageUri

actual fun ImageFile.toByteArray() = contentResolver.openInputStream(uri)?.use {
    it.readBytes()
} ?: throw IllegalStateException("Couldn't open inputStream $uri")

class ImageUri(val uri: Uri, val contentResolver: ContentResolver)