package com.atriz.keyval.navigation

import androidx.navigation.NavDirections
import com.atriz.core_presentation.navigation.NavigationHolder
import com.atriz.keyval.AppGraphDirections

class AppNavigationHolder : NavigationHolder {

    override val toAuthGraph: NavDirections get() = AppGraphDirections.toAuth()

    override val toHomeGraph: NavDirections get() = AppGraphDirections.toHome()
}
