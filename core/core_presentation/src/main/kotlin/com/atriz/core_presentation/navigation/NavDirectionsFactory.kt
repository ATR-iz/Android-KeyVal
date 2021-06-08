package com.atriz.core_presentation.navigation

import android.os.Bundle
import androidx.navigation.NavDirections

object NavDirectionsFactory {

    fun create(action: Int, bundle: Bundle) = object : NavDirections {
        override fun getArguments() = bundle
        override fun getActionId() = action
    }
}
