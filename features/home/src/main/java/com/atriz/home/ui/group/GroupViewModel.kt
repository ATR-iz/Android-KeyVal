package com.atriz.home.ui.group

import androidx.lifecycle.viewModelScope
import com.atriz.core_presentation.extensions.update
import com.atriz.core_presentation.model.Navigate
import com.atriz.core_presentation.viewmodel.BaseViewModel
import com.atriz.home.navigation.HomeNavigation
import com.atriz.home.repository.HomeRepository
import com.atriz.home.ui.group.items.AccountItem
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch

class GroupViewModel @AssistedInject constructor(
    @Assisted val groupId: Long,
    private val homeRepository: HomeRepository,
    private val homeNavigation: HomeNavigation,
) : BaseViewModel<GroupViewState>() {

    @AssistedFactory
    interface Factory {
        fun get(groupId: Long): GroupViewModel
    }

    init {
        viewState.value = GroupViewState(
            accountItems = emptyList()
        )
    }

    fun onViewCreated() {
        viewModelScope.launch {
            val accounts = homeRepository.getAccountsInGroup(groupId)

            viewState.update { copy(
                accountItems = accounts.map {
                    AccountItem(name = it.authName, lastUpdate = it.lastUpdate)
                }
            ) }
        }
    }

    fun onCreateAccountClicked() {
        events.onNext(Navigate(homeNavigation.toCreateAccountFragment(groupId)))
    }
}
