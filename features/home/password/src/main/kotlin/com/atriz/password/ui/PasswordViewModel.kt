package com.atriz.password.ui

import android.content.res.Resources
import com.atriz.core.utils.CopyToClipboard
import com.atriz.core_presentation.extensions.requireValue
import com.atriz.core_presentation.model.NavigateUp
import com.atriz.core_presentation.model.ShowMessage
import com.atriz.core_presentation.viewmodel.BaseViewModel
import com.atriz.password.R
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class PasswordViewModel @AssistedInject constructor(
    @Assisted val encryptedPassword: String,
    private val copyToClipboard: CopyToClipboard,
    private val resources: Resources
) : BaseViewModel<PasswordViewState>() {

    companion object {
        private const val MILLIS = 1000
        private const val TIMER_CLIPBOARD = 20 * MILLIS
    }

    @AssistedFactory
    interface Factory {
        fun get(encryptedPassword: String): PasswordViewModel
    }

    init {
        viewState.value = PasswordViewState(
            password = encryptedPassword
        )
    }

    fun onCloseClicked() {
        events.onNext(NavigateUp)
    }

    fun onCopyClicked() {
        copyToClipboard.copyWithTimer(
                viewState.requireValue.password,
                TIMER_CLIPBOARD.toLong()
        )

        val second = TIMER_CLIPBOARD / MILLIS
        events.onNext(ShowMessage(
                resources.getString(R.string.copy_message_with_timer, second.toString())
        ))
    }
}
