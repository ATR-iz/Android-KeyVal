package com.atriz.core_presentation.navigation

interface HomeNavigationHolder {

    companion object {
        const val GROUP_ID = "group_id"
    }

    val toCreateGroupFragment: Int
    val toGroupFragment: Int
    val toCreateAccountFragment: Int
}
