package com.atriz.home.di

import com.atriz.core.di.providers.CoreDependencyProvider
import com.atriz.home.ui.create_account.CreateAccountFragment
import com.atriz.home.ui.create_group.CreateGroupFragment
import com.atriz.home.ui.group.GroupFragment
import com.atriz.home.ui.home.HomeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        dependencies = [
            CoreDependencyProvider::class
        ]
)
interface HomeComponent {

    fun inject(target: HomeFragment)
    fun inject(target: CreateGroupFragment)
    fun inject(target: GroupFragment)
    fun inject(target: CreateAccountFragment)

    class Initializer private constructor() {

        companion object {
            fun init(coreDependencyProvider: CoreDependencyProvider): HomeComponent {
                return DaggerHomeComponent
                        .builder()
                        .coreDependencyProvider(coreDependencyProvider)
                        .build()
            }
        }
    }
}
