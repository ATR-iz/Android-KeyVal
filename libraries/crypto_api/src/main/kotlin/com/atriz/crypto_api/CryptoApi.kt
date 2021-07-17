package com.atriz.crypto_api

interface CryptoApi {

    fun encrypt(message: String): String
    fun decrypt(message: String): String
}