package com.atriz.auth.di

import com.atriz.auth.ui.auth_navigation.AuthNavigationFragment
import com.atriz.auth.ui.auth.AuthFragment
import com.atriz.auth.ui.new_password.NewPasswordFragment
import com.atriz.core.di.providers.CoreDependencyProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        dependencies = [
            CoreDependencyProvider::class
        ]
)
interface AuthComponent {

    fun inject(target: AuthNavigationFragment)
    fun inject(target: AuthFragment)
    fun inject(target: NewPasswordFragment)

    class Initializer private constructor() {

        companion object {
            fun init(coreDependencyProvider: CoreDependencyProvider): AuthComponent {
                return DaggerAuthComponent
                        .builder()
                        .coreDependencyProvider(coreDependencyProvider)
                        .build()
            }
        }
    }
}
