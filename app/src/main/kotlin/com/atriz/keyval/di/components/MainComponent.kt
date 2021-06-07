package com.atriz.keyval.di.components

import com.atriz.core.di.providers.CoreDependencyProvider
import com.atriz.core.di.scope.FeatureScope
import com.atriz.keyval.ui.MainActivity
import dagger.Component

@FeatureScope
@Component(
        dependencies = [
            CoreDependencyProvider::class
        ]
)
interface MainComponent {
    fun inject(target: MainActivity)

    class Initializer private constructor() {

        companion object {
            fun init(coreDependencyProvider: CoreDependencyProvider): MainComponent {
                return DaggerMainComponent
                        .builder()
                        .coreDependencyProvider(coreDependencyProvider)
                        .build()
            }
        }
    }
}
