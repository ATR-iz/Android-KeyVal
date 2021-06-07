package com.atriz.auth.utils

import android.util.Base64
import java.security.MessageDigest
import javax.inject.Inject

class HashUtils @Inject constructor() {

    companion object {
        private const val ALGORITHM = "SHA-256"
    }

    fun createHash(text: String): String {
        val md = MessageDigest.getInstance(ALGORITHM)
        md.update(text.toByteArray())
        return Base64.encodeToString(md.digest(), Base64.DEFAULT)
    }
}
