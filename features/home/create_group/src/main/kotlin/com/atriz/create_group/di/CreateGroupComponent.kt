package com.atriz.create_group.di

import com.atriz.core.di.providers.CoreDependencyProvider
import com.atriz.create_group.ui.CreateGroupFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        CoreDependencyProvider::class
    ]
)
interface CreateGroupComponent {

    fun inject(target: CreateGroupFragment)

    class Initializer private constructor() {

        companion object {
            fun init(coreDependencyProvider: CoreDependencyProvider): CreateGroupComponent {
                return DaggerCreateGroupComponent
                    .builder()
                    .coreDependencyProvider(coreDependencyProvider)
                    .build()
            }
        }
    }
}
