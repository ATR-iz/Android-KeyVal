package com.atriz.create_account.ui

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.atriz.core.di.providers.coreDependencyProvider
import com.atriz.core_presentation.extensions.observe
import com.atriz.core_presentation.extensions.viewModels
import com.atriz.core_presentation.fragment.BaseFragment
import com.atriz.core_presentation.navigation.HomeNavigationHolder
import com.atriz.create_account.R
import com.atriz.create_account.databinding.FragmentCreateAccountBinding
import com.atriz.create_account.di.CreateAccountComponent
import com.redmadrobot.extensions.viewbinding.viewBinding
import javax.inject.Inject

class CreateAccountFragment : BaseFragment(R.layout.fragment_create_account) {

    @Inject
    lateinit var viewModelFactory: CreateAccountViewModel.Factory
    private val viewModel: CreateAccountViewModel by viewModels {
        viewModelFactory.get(requireArguments().getLong(HomeNavigationHolder.GROUP_ID))
    }

    private val binding: FragmentCreateAccountBinding by viewBinding()

    override fun init() {
        CreateAccountComponent.Initializer
            .init(coreDependencyProvider)
            .inject(this)
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        binding.createAccountInputName.addTextChangedListener {
            viewModel.onNameChanged(it.toString())
        }

        binding.createAccountInputPassword.addTextChangedListener {
            viewModel.onPasswordChanged(it.toString())
        }

        binding.createAccountButtonSave.setOnClickListener {
            viewModel.onSaveAccountClicked()
        }
    }

    override fun observeViewModel() {
        observe(viewModel.events, ::onEventReceived)
        observe(viewModel.viewState, ::onStateReceived)
    }

    private fun onStateReceived(state: CreateAccountViewState) {
        binding.createAccountButtonSave.isEnabled = state.isNameValid
    }
}
