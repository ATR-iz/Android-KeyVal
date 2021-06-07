package com.atriz.core.di.providers

import android.content.SharedPreferences
import com.atriz.core_storage.InMemoryStorage

interface StorageDependencyProvider {

    fun provideInMemoryStorage(): InMemoryStorage

    fun provideSharedPreference(): SharedPreferences
}
