package com.atriz.core_presentation.navigation

import android.os.Bundle
import androidx.navigation.NavDirections

class NavDirectionsWithBundle(
    private val action: Int,
    private val bundle: Bundle
) : NavDirections {

    override fun getArguments() = bundle
    override fun getActionId() = action
}
