package com.atriz.group.ui

import android.os.Bundle
import androidx.lifecycle.viewModelScope
import com.atriz.core_presentation.extensions.update
import com.atriz.core_presentation.model.Navigate
import com.atriz.core_presentation.navigation.HomeNavigationHolder
import com.atriz.core_presentation.navigation.NavDirectionsFactory
import com.atriz.core_presentation.viewmodel.BaseViewModel
import com.atriz.group.repository.GroupRepository
import com.atriz.group.ui.items.AccountItem
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch
import org.joda.time.DateTime

class GroupViewModel @AssistedInject constructor(
    @Assisted val groupId: Long,
    private val repository: GroupRepository,
    private val homeNavigationHolder: HomeNavigationHolder
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
            val accounts = repository.getAccountsInGroup(groupId)

            viewState.update { copy(
                accountItems = accounts.map {
                    val lastUpdate = DateTime(it.lastUpdateInMillis)
                        .toString("dd.MM.yyyy HH:mm")

                    AccountItem(name = it.authName, lastUpdate = lastUpdate)
                }
            ) }
        }
    }

    fun onCreateAccountClicked() {
        val bundle = Bundle()
        bundle.putLong(HomeNavigationHolder.GROUP_ID, groupId)

        val toCreateAccountFragment = NavDirectionsFactory.create(
            homeNavigationHolder.toCreateAccountFragment,
            bundle
        )

        events.onNext(Navigate(toCreateAccountFragment))
    }
}
