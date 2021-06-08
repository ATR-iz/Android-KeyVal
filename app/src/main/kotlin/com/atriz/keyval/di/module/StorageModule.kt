package com.atriz.keyval.di.module

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import com.atriz.core_storage.InMemoryStorage
import com.atriz.database_api.DatabaseFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {

    companion object {
        private const val SHARED_PREFERENCE_NAME = "p"
        private const val SHARED_PREFERENCE_KEY = "p_k"
    }

    @Singleton
    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return EncryptedSharedPreferences.create(
                SHARED_PREFERENCE_NAME,
                SHARED_PREFERENCE_KEY,
                context,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    @Singleton
    @Provides
    fun provideInMemoryStorage(): InMemoryStorage = InMemoryStorage()

    @Singleton
    @Provides
    fun provideDatabase(context: Context): DatabaseFactory {
        return DatabaseFactory.build(context)
    }
}
