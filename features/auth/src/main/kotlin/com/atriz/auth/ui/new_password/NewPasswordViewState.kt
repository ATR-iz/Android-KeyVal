package com.atriz.auth.ui.new_password

data class NewPasswordViewState(
    val newPassword: String,
    val confirmPassword: String,
    val isPasswordsEquals: Boolean
)
