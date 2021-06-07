package com.atriz.auth.ui.auth

import android.content.Context
import android.content.SharedPreferences
import com.atriz.auth.R
import com.atriz.auth.model.HashKey
import com.atriz.auth.utils.HashUtils
import com.atriz.core_presentation.model.Navigate
import com.atriz.core_presentation.model.ShowMessage
import com.atriz.core_presentation.navigation.NavigationHolder
import com.atriz.core_presentation.viewmodel.BaseViewModel
import com.atriz.core_storage.InMemoryStorage
import com.atriz.core_storage.PasswordKey
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    sharedPreferences: SharedPreferences,
    private val inMemoryStorage: InMemoryStorage,
    private val hashUtils: HashUtils,
    private val navigationHolder: NavigationHolder,
    private val context: Context
) : BaseViewModel<Unit>() {

    private var password: String = ""
    private var hash: String = ""

    init {
        hash = sharedPreferences.getString(HashKey.name, "").orEmpty()
    }

    fun onPasswordChanged(password: String) {
        this.password = password
    }

    fun onButtonConfirmClicked() {
        if (hash == hashUtils.createHash(password)) {
            inMemoryStorage.set(PasswordKey, password)
            events.onNext(Navigate(navigationHolder.toHomeGraph))
        } else {
            events.onNext(ShowMessage(context.getString(R.string.auth_password_error_description)))
        }
    }
}
