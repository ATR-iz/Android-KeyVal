package com.atriz.home.ui.home

import com.atriz.core_presentation.extensions.update
import com.atriz.core_presentation.viewmodel.BaseViewModel
import com.atriz.home.model.Favorites
import com.atriz.home.ui.home.items.FavoritesPageItem
import com.atriz.home.ui.home.items.GroupPageItem
import com.xwray.groupie.Group
import javax.inject.Inject

class HomeViewModel @Inject constructor() : BaseViewModel<HomeViewState>() {

    init {
        viewState.value = HomeViewState(
                pageItems = emptyList()
        )

        createPages()
    }

    private fun createPages() {
        val groupItems = mutableListOf<Group>()

        groupItems.add(GroupPageItem(listOf(
                com.atriz.home.model.Group("Local", ""),
                com.atriz.home.model.Group("Email", ""),
                com.atriz.home.model.Group("Google", "")
        )))

        groupItems.add(FavoritesPageItem(listOf(
                Favorites("Local", "admin", ""),
                Favorites("Google", "test-account@gmail.com", "")
        )))

        viewState.update { copy(pageItems = groupItems) }
    }
}
