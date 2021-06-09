package com.atriz.core.di.providers

import android.content.SharedPreferences
import com.atriz.core.utils.CopyToClipboard
import com.atriz.core_storage.InMemoryStorage
import com.atriz.database_api.DatabaseFactory

interface StorageDependencyProvider {

    fun provideInMemoryStorage(): InMemoryStorage

    fun provideSharedPreference(): SharedPreferences

    fun provideDatabaseFactory(): DatabaseFactory

    fun provideCopyToClipboard(): CopyToClipboard
}
