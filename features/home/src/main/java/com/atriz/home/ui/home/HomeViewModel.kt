package com.atriz.home.ui.home

import androidx.lifecycle.viewModelScope
import com.atriz.core_presentation.extensions.update
import com.atriz.core_presentation.model.Navigate
import com.atriz.core_presentation.viewmodel.BaseViewModel
import com.atriz.home.navigation.HomeNavigation
import com.atriz.home.repository.HomeRepository
import com.atriz.home.ui.home.items.FavoritesPageItem
import com.atriz.home.ui.home.items.GroupPageItem
import com.xwray.groupie.Group
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository,
    private val homeNavigation: HomeNavigation
) : BaseViewModel<HomeViewState>() {

    init {
        viewState.value = HomeViewState(
                pageItems = emptyList()
        )
    }

    fun onCreateGroupClicked() {
        events.onNext(Navigate(homeNavigation.toCreateGroupFragment()))
    }

    fun onViewCreated() {
        viewModelScope.launch {
            val groupItems = mutableListOf<Group>()

            val groups = homeRepository.getGroups()
            groupItems.add(GroupPageItem(groups))

            val accounts = homeRepository.getAccountsWithGroup().filter { it.account.isFavorites }
            if (accounts.isNotEmpty()) groupItems.add(FavoritesPageItem(accounts))

            viewState.update { copy(pageItems = groupItems) }
        }
    }
}
