package com.atriz.core.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CopyToClipboard(
    private val context: Context
) {

    @Suppress("GlobalCoroutineUsage")
    fun copyWithTimer(text: String, timeInMillis: Long) {
        GlobalScope.launch {
            copy(text)
            delay(timeInMillis)
            copy(null)
        }
    }

    fun copy(text: String?) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip: ClipData = ClipData.newPlainText("User data", text)
        clipboard.setPrimaryClip(clip)
    }
}
