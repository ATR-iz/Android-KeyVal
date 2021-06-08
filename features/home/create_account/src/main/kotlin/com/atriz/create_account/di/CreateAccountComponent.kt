package com.atriz.create_account.di

import com.atriz.core.di.providers.CoreDependencyProvider
import com.atriz.create_account.ui.CreateAccountFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        CoreDependencyProvider::class
    ]
)
interface CreateAccountComponent {

    fun inject(target: CreateAccountFragment)

    class Initializer private constructor() {

        companion object {
            fun init(coreDependencyProvider: CoreDependencyProvider): CreateAccountComponent {
                return DaggerCreateAccountComponent
                    .builder()
                    .coreDependencyProvider(coreDependencyProvider)
                    .build()
            }
        }
    }
}
