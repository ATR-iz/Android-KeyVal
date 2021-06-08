package com.atriz.home.ui.create_account

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.navArgs
import com.atriz.core.di.providers.coreDependencyProvider
import com.atriz.core_presentation.extensions.observe
import com.atriz.core_presentation.extensions.viewModels
import com.atriz.core_presentation.fragment.BaseFragment
import com.atriz.home.R
import com.atriz.home.databinding.FragmentCreateAccountBinding
import com.atriz.home.di.HomeComponent
import com.redmadrobot.extensions.viewbinding.viewBinding
import javax.inject.Inject

class CreateAccountFragment : BaseFragment(R.layout.fragment_create_account) {

    private val args: CreateAccountFragmentArgs by navArgs()

    @Inject
    lateinit var viewModelFactory: CreateAccountViewModel.Factory
    private val viewModel: CreateAccountViewModel by viewModels { viewModelFactory.get(args.groupId) }

    private val binding: FragmentCreateAccountBinding by viewBinding()

    override fun init() {
        HomeComponent.Initializer
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
