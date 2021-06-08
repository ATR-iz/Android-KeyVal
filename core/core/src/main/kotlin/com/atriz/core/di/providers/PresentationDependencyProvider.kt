package com.atriz.core.di.providers

import com.atriz.core_presentation.navigation.HomeNavigationHolder
import com.atriz.core_presentation.navigation.NavigationHolder

interface PresentationDependencyProvider {

    fun provideNavigationHolder(): NavigationHolder

    fun provideHomeNavigationHolder(): HomeNavigationHolder
}
