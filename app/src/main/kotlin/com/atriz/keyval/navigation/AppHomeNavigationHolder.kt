package com.atriz.keyval.navigation

import com.atriz.core_presentation.navigation.HomeNavigationHolder
import com.atriz.keyval.R

class AppHomeNavigationHolder : HomeNavigationHolder {

    override val toCreateGroupFragment = R.id.to_create_group_fragment
    override val toGroupFragment = R.id.to_group_fragment
    override val toCreateAccountFragment = R.id.to_create_account_fragment
}
