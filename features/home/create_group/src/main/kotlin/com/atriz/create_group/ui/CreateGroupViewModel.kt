package com.atriz.create_group.ui

import androidx.lifecycle.viewModelScope
import com.atriz.core_presentation.extensions.update
import com.atriz.core_presentation.model.NavigateUp
import com.atriz.core_presentation.viewmodel.BaseViewModel
import com.atriz.create_group.repository.CreateGroupRepository
import com.atriz.database_api.model.Group
import kotlinx.coroutines.launch
import javax.inject.Inject

class CreateGroupViewModel @Inject constructor(
    private val repository: CreateGroupRepository
) : BaseViewModel<CreateGroupViewState>() {
    private var groupName: String = ""
    private var iconPath: String = ""

    init {
        viewState.value = CreateGroupViewState(
            isNameValid = false
        )
    }

    fun onSaveClicked() {
        viewModelScope.launch {
            repository.createGroup(
                Group(
                    groupId = 0,
                    groupName = groupName,
                    iconPath = iconPath
                )
            )

            events.onNext(NavigateUp)
        }
    }

    fun onNameChanged(name: String) {
        groupName = name.trim()

        viewState.update { copy(isNameValid = name.isNotEmpty()) }
    }
}
