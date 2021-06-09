package com.atriz.group.ui

import android.content.res.Resources
import android.os.Bundle
import androidx.lifecycle.viewModelScope
import com.atriz.core.utils.CopyToClipboard
import com.atriz.core_presentation.extensions.update
import com.atriz.core_presentation.model.Navigate
import com.atriz.core_presentation.model.ShowMessage
import com.atriz.core_presentation.navigation.HomeNavigationHolder
import com.atriz.core_presentation.navigation.NavDirectionsWithBundle
import com.atriz.core_presentation.viewmodel.BaseViewModel
import com.atriz.group.R
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
    private val homeNavigationHolder: HomeNavigationHolder,
    private val copyToClipboard: CopyToClipboard,
    private val resources: Resources
) : BaseViewModel<GroupViewState>() {

    companion object {
        private const val MILLIS = 1000
        private const val TIMER_CLIPBOARD = 20 * MILLIS
    }

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

                    AccountItem(
                        name = it.accountName,
                        password = it.accountPassword,
                        lastUpdate = lastUpdate,
                        toPassword = { password -> onViewPasswordClicked(password) },
                        copyPassword = { password -> onCopyClicked(password) }
                    )
                }
            ) }
        }
    }

    fun onCreateAccountClicked() {
        val bundle = Bundle()
        bundle.putLong(HomeNavigationHolder.GROUP_ID, groupId)

        val toCreateAccountFragment = NavDirectionsWithBundle(
            homeNavigationHolder.toCreateAccountFragment,
            bundle
        )

        events.onNext(Navigate(toCreateAccountFragment))
    }

    private fun onCopyClicked(password: String) {
        copyToClipboard.copyWithTimer(
                password,
                TIMER_CLIPBOARD.toLong()
        )

        val second = TIMER_CLIPBOARD / MILLIS
        events.onNext(ShowMessage(
                resources.getString(R.string.copy_message_with_timer, second.toString())
        ))
    }

    private fun onViewPasswordClicked(password: String) {
        val bundle = Bundle()
        bundle.putString(HomeNavigationHolder.PASSWORD, password)

        val toPasswordFragment = NavDirectionsWithBundle(
            homeNavigationHolder.toPasswordFragment,
            bundle
        )

        events.onNext(Navigate(toPasswordFragment))
    }
}
