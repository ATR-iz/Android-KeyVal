package com.atriz.core.di.app

import com.atriz.core.di.providers.CoreDependencyProvider

interface DaggerApplication {

    fun coreDependencyProvider(): CoreDependencyProvider
}
