package com.atriz.auth.ui.new_password

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.atriz.auth.R
import com.atriz.auth.databinding.FragmentNewPasswordBinding
import com.atriz.auth.di.AuthComponent
import com.atriz.core.di.providers.coreDependencyProvider
import com.atriz.core_presentation.extensions.observe
import com.atriz.core_presentation.extensions.viewModels
import com.atriz.core_presentation.fragment.BaseFragment
import com.redmadrobot.extensions.viewbinding.viewBinding
import javax.inject.Inject
import javax.inject.Provider

class NewPasswordFragment : BaseFragment(R.layout.fragment_new_password) {

    @Inject
    internal lateinit var viewModelFactory: Provider<NewPasswordViewModel>
    private val viewModel by viewModels { viewModelFactory.get() }

    private val binding: FragmentNewPasswordBinding by viewBinding()

    override fun init() {
        AuthComponent.Initializer
                .init(coreDependencyProvider)
                .inject(this)
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        binding.newPasswordInputNewPassword.addTextChangedListener {
            viewModel.onPasswordChanged(it.toString())
        }

        binding.newPasswordInputConfirmPassword.addTextChangedListener {
            viewModel.onPasswordConfirmChanged(it.toString())
        }

        binding.newPasswordButtonSave.setOnClickListener {
            viewModel.onButtonSaveClicked()
        }
    }

    override fun observeViewModel() {
        observe(viewModel.events, ::onEventReceived)
        observe(viewModel.viewState, ::onStateReceived)
    }

    private fun onStateReceived(state: NewPasswordViewState) {
        binding.newPasswordButtonSave.isEnabled = state.isPasswordsEquals

        if (state.isPasswordsEquals) {
            binding.newPasswordTextError.text = ""
        } else {
            binding.newPasswordTextError.text = getString(R.string.new_password_error_description)
        }
    }
}
