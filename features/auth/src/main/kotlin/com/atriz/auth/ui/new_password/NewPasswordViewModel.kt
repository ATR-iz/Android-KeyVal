package com.atriz.auth.ui.new_password

import android.content.SharedPreferences
import com.atriz.auth.model.HashKey
import com.atriz.auth.utils.HashUtils
import com.atriz.core_presentation.extensions.requireValue
import com.atriz.core_presentation.extensions.update
import com.atriz.core_presentation.model.Navigate
import com.atriz.core_presentation.navigation.NavigationHolder
import com.atriz.core_presentation.viewmodel.BaseViewModel
import com.atriz.core_storage.InMemoryStorage
import com.atriz.core_storage.PasswordKey
import javax.inject.Inject

class NewPasswordViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val inMemoryStorage: InMemoryStorage,
    private val hashUtils: HashUtils,
    private val navigationHolder: NavigationHolder
) : BaseViewModel<NewPasswordViewState>() {

    init {
        viewState.value = NewPasswordViewState(
                newPassword = "",
                confirmPassword = "",
                isPasswordsEquals = true
        )
    }

    fun onPasswordChanged(password: String) {
        viewState.update { copy(
                newPassword = password,
                isPasswordsEquals = password == viewState.requireValue.confirmPassword
        ) }
    }

    fun onPasswordConfirmChanged(passwordConfirm: String) {
        viewState.update { copy(
                confirmPassword = passwordConfirm,
                isPasswordsEquals = passwordConfirm == viewState.requireValue.newPassword
        ) }
    }

    fun onButtonSaveClicked() {
        val password = viewState.requireValue.newPassword
        val hash = hashUtils.createHash(password)
        sharedPreferences.edit().putString(HashKey.name, hash).apply()
        inMemoryStorage.set(PasswordKey, password)
        events.onNext(Navigate(navigationHolder.toHomeGraph))
    }
}
