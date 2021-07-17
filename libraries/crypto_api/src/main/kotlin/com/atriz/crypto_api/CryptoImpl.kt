package com.atriz.crypto_api

import android.util.Base64
import com.atriz.core_storage.InMemoryStorage
import com.atriz.core_storage.PasswordKey
import javax.crypto.BadPaddingException
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

internal class CryptoImpl(private val inMemoryStorage: InMemoryStorage) : CryptoApi {

    override fun encrypt(message: String): String {
        val key = modifyKey(inMemoryStorage.get(PasswordKey))

        val secretKeySpec = SecretKeySpec(key.toByteArray(), "AES")
        val iv = key.toByteArray()
        val ivParameterSpec = IvParameterSpec(iv)

        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec)

        val encryptedValue = cipher.doFinal(message.toByteArray())
        return Base64.encodeToString(encryptedValue, Base64.DEFAULT)
    }

    override fun decrypt(message: String): String {
        val key = modifyKey(inMemoryStorage.get(PasswordKey))

        val secretKeySpec = SecretKeySpec(key.toByteArray(), "AES")
        val iv = key.toByteArray()
        val ivParameterSpec = IvParameterSpec(iv)

        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec)

        val decodedValue = Base64.decode(message, Base64.DEFAULT)

        return try {
            String(cipher.doFinal(decodedValue))
        } catch (e: BadPaddingException) {
            "error"
        }
    }

    private fun modifyKey(key: String): String {
        var newKey = key
        if (key.length < 16){
            for(i in key.length until 16){
                newKey += "1"
            }
        }
        return newKey
    }
}