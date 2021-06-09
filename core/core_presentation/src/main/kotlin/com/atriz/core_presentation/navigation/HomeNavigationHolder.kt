package com.atriz.core_presentation.navigation

interface HomeNavigationHolder {

    companion object {
        const val GROUP_ID = "group_id"
        const val PASSWORD = "password"
    }

    val toCreateGroupFragment: Int
    val toGroupFragment: Int
    val toCreateAccountFragment: Int
    val toPasswordFragment: Int
}
