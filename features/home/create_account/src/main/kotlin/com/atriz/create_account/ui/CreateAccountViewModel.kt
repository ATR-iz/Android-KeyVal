package com.atriz.create_account.ui

import androidx.lifecycle.viewModelScope
import com.atriz.core_presentation.extensions.update
import com.atriz.core_presentation.model.NavigateUp
import com.atriz.core_presentation.viewmodel.BaseViewModel
import com.atriz.create_account.repository.CreateAccountRepository
import com.atriz.database_api.model.Account
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch
import org.joda.time.DateTime

class CreateAccountViewModel @AssistedInject constructor(
    @Assisted val groupId: Long,
    private val repository: CreateAccountRepository
) : BaseViewModel<CreateAccountViewState>() {

    private var name: String = ""
    private var password: String = ""

    @AssistedFactory
    interface Factory {
        fun get(groupId: Long): CreateAccountViewModel
    }

    init {
        viewState.value = CreateAccountViewState(
            isNameValid = false
        )
    }

    fun onNameChanged(name: String) {
        this.name = name

        viewState.update { copy(isNameValid = name.isNotEmpty()) }
    }

    fun onPasswordChanged(password: String) {
        this.password = password
    }

    fun onSaveAccountClicked() {
        viewModelScope.launch {
            repository.createAccount(
                Account(
                    accountId = 0,
                    groupId = groupId,
                    authName = name,
                    authPassword = password,
                    lastUpdateInMillis = DateTime.now().millis,
                    isFavorites = false
                )
            )

            events.onNext(NavigateUp)
        }
    }
}
