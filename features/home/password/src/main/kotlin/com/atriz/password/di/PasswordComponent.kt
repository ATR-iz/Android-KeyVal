package com.atriz.password.di

import com.atriz.core.di.providers.CoreDependencyProvider
import com.atriz.password.ui.PasswordDialog
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        CoreDependencyProvider::class
    ]
)
interface PasswordComponent {

    fun inject(target: PasswordDialog)

    class Initializer private constructor() {

        companion object {
            fun init(coreDependencyProvider: CoreDependencyProvider): PasswordComponent {
                return DaggerPasswordComponent
                    .builder()
                    .coreDependencyProvider(coreDependencyProvider)
                    .build()
            }
        }
    }
}
