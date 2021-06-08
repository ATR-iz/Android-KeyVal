package com.atriz.home.ui.home

import com.atriz.core_presentation.extensions.update
import com.atriz.core_presentation.viewmodel.BaseViewModel
import com.atriz.database_api.DatabaseFactory
import com.atriz.home.ui.home.items.FavoritesPageItem
import com.atriz.home.ui.home.items.GroupPageItem
import com.xwray.groupie.Group
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val databaseFactory: DatabaseFactory,
) : BaseViewModel<HomeViewState>() {

    init {
        viewState.value = HomeViewState(
                pageItems = emptyList()
        )

        createPages()
    }

    private fun createPages() {
        val groupItems = mutableListOf<Group>()

        groupItems.add(GroupPageItem(databaseFactory.api.getGroups()))

        groupItems.add(FavoritesPageItem(databaseFactory.api.getFavorites()))

        viewState.update { copy(pageItems = groupItems) }
    }
}
