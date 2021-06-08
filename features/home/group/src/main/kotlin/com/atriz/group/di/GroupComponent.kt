package com.atriz.group.di

import com.atriz.core.di.providers.CoreDependencyProvider
import com.atriz.group.ui.GroupFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        CoreDependencyProvider::class
    ]
)
interface GroupComponent {

    fun inject(target: GroupFragment)

    class Initializer private constructor() {

        companion object {
            fun init(coreDependencyProvider: CoreDependencyProvider): GroupComponent {
                return DaggerGroupComponent
                    .builder()
                    .coreDependencyProvider(coreDependencyProvider)
                    .build()
            }
        }
    }
}
