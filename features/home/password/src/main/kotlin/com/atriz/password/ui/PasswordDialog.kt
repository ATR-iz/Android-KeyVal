package com.atriz.password.ui

import android.os.Bundle
import android.view.View
import com.atriz.core.di.providers.coreDependencyProvider
import com.atriz.core_presentation.dialog.BaseDialog
import com.atriz.core_presentation.extensions.observe
import com.atriz.core_presentation.extensions.viewModels
import com.atriz.core_presentation.navigation.HomeNavigationHolder
import com.atriz.password.R
import com.atriz.password.databinding.DialogPasswordBinding
import com.atriz.password.di.PasswordComponent
import com.redmadrobot.extensions.viewbinding.viewBinding
import javax.inject.Inject

class PasswordDialog : BaseDialog(R.layout.dialog_password) {

    @Inject
    lateinit var viewModelFactory: PasswordViewModel.Factory
    private val viewModel: PasswordViewModel by viewModels {
        viewModelFactory.get(requireArguments().getString(HomeNavigationHolder.PASSWORD).orEmpty())
    }

    private val binding: DialogPasswordBinding by viewBinding()

    override fun init() {
        PasswordComponent.Initializer
            .init(coreDependencyProvider)
            .inject(this)
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        binding.passwordImageClose.setOnClickListener {
            viewModel.onCloseClicked()
        }

        binding.passwordButtonCopy.setOnClickListener {
            viewModel.onCopyClicked()
        }
    }

    override fun observeViewModel() {
        observe(viewModel.events, ::onEventReceived)
        observe(viewModel.viewState, ::onStateReceived)
    }

    private fun onStateReceived(state: PasswordViewState) {
        binding.passwordTextPassword.text = state.password
    }
}
