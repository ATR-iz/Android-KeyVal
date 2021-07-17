package com.atriz.crypto_api

import com.atriz.core_storage.InMemoryStorage

class CryptoFactory {

    companion object {
        fun build(inMemoryStorage: InMemoryStorage) : CryptoApi = CryptoImpl(inMemoryStorage)
    }
}