package com.atriz.home.di

import com.atriz.core.di.providers.CoreDependencyProvider
import com.atriz.home.ui.create_group.CreateGroupFragment
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
