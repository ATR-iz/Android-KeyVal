package com.atriz.core.di.providers

import android.content.SharedPreferences
import com.atriz.core.utils.CopyToClipboard
import com.atriz.core_storage.InMemoryStorage
import com.atriz.crypto_api.CryptoApi
import com.atriz.database_api.CryptoDatabase

interface StorageDependencyProvider {

    fun provideInMemoryStorage(): InMemoryStorage

    fun provideSharedPreference(): SharedPreferences

    fun provideDatabaseFactory(): CryptoDatabase

    fun provideCopyToClipboard(): CopyToClipboard

    fun provideCryptoApi(): CryptoApi
}
