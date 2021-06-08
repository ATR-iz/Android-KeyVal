package com.atriz.home.ui

import android.os.Bundle
import androidx.lifecycle.viewModelScope
import com.atriz.core_presentation.extensions.update
import com.atriz.core_presentation.model.Navigate
import com.atriz.core_presentation.navigation.HomeNavigationHolder
import com.atriz.core_presentation.navigation.NavDirectionsFactory
import com.atriz.core_presentation.viewmodel.BaseViewModel
import com.atriz.home.repository.HomeRepository
import com.atriz.home.ui.items.FavoritesPageItem
import com.atriz.home.ui.items.GroupPageItem
import com.xwray.groupie.Group
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository,
    private val homeNavigationHolder: HomeNavigationHolder
) : BaseViewModel<HomeViewState>() {

    init {
        viewState.value = HomeViewState(
                pageItems = emptyList()
        )
    }

    fun onCreateGroupClicked() {
        val toCreateGroupFragment = NavDirectionsFactory.create(
            homeNavigationHolder.toCreateGroupFragment,
            Bundle()
        )

        events.onNext(Navigate(toCreateGroupFragment))
    }

    fun onViewCreated() {
        viewModelScope.launch {
            val groupItems = mutableListOf<Group>()

            val groups = homeRepository.getGroups()
            groupItems.add(GroupPageItem(groups) { onGroupClicked(it) })

            val accounts = homeRepository.getAccountsWithGroup().filter { it.account.isFavorites }
            if (accounts.isNotEmpty()) groupItems.add(FavoritesPageItem(accounts))

            viewState.update { copy(pageItems = groupItems) }
        }
    }

    private fun onGroupClicked(groupId: Long) {
        val bundle = Bundle()
        bundle.putLong(HomeNavigationHolder.GROUP_ID, groupId)

        val toGroupFragment = NavDirectionsFactory.create(
            homeNavigationHolder.toGroupFragment,
            bundle
        )

        events.onNext(Navigate(toGroupFragment))
    }
}
