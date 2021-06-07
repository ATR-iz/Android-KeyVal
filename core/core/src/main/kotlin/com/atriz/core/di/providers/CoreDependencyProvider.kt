package com.atriz.core.di.providers

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import com.atriz.core.di.app.DaggerApplication

interface CoreDependencyProvider :
        PresentationDependencyProvider,
        StorageDependencyProvider {

    fun provideAppContext(): Context
}

val Activity.coreDependencyProvider: CoreDependencyProvider
    get() = (this.applicationContext as DaggerApplication).coreDependencyProvider()

val Fragment.coreDependencyProvider: CoreDependencyProvider
    get() = (activity?.applicationContext as DaggerApplication).coreDependencyProvider()
