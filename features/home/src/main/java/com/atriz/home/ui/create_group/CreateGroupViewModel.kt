package com.atriz.home.ui.create_group

import androidx.lifecycle.viewModelScope
import com.atriz.core_presentation.extensions.update
import com.atriz.core_presentation.model.NavigateUp
import com.atriz.core_presentation.viewmodel.BaseViewModel
import com.atriz.database_api.model.Group
import com.atriz.home.repository.HomeRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class CreateGroupViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : BaseViewModel<CreateGroupViewState>() {
    private var groupName: String = ""
    private var iconPath: String = ""

    init {
        viewState.value = CreateGroupViewState(
            isNotEmptyName = false
        )
    }

    fun onSaveClicked() {
        viewModelScope.launch {
            homeRepository.createGroup(
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

        viewState.update { copy(isNotEmptyName = name.isNotEmpty()) }
    }
}
