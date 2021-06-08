package com.atriz.home.navigation

import androidx.navigation.NavDirections
import com.atriz.home.ui.group.GroupFragmentDirections
import com.atriz.home.ui.home.HomeFragmentDirections
import javax.inject.Inject

class HomeNavigation @Inject constructor() {

    fun toCreateGroupFragment() = HomeFragmentDirections.toCreateGroupFragment()

    fun toGroupFragment(groupId: Long) = HomeFragmentDirections.toGroupFragment(groupId)

    fun toCreateAccountFragment(groupId: Long): NavDirections {
        return GroupFragmentDirections.toCreateAccountFragment(groupId)
    }
}
