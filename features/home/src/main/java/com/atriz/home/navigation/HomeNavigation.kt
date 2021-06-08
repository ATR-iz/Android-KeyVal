package com.atriz.home.navigation

import com.atriz.home.ui.home.HomeFragmentDirections
import javax.inject.Inject

class HomeNavigation @Inject constructor() {

    fun toCreateGroupFragment() = HomeFragmentDirections.toCreateGroupFragment()
}
