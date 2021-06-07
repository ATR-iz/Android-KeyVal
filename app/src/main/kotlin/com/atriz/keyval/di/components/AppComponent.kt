package com.atriz.keyval.di.components

import android.content.Context
import com.atriz.core.di.providers.CoreDependencyProvider
import com.atriz.keyval.di.module.PresentationModule
import com.atriz.keyval.di.module.StorageModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            StorageModule::class,
            PresentationModule::class,
        ]
)
interface AppComponent : CoreDependencyProvider {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(appContext: Context): Builder

        fun build(): AppComponent
    }
}
