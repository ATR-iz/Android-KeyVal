package com.atriz.create_group.ui

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.atriz.core.di.providers.coreDependencyProvider
import com.atriz.core_presentation.extensions.observe
import com.atriz.core_presentation.extensions.viewModels
import com.atriz.core_presentation.fragment.BaseFragment
import com.atriz.create_group.R
import com.atriz.create_group.databinding.FragmentCreateGroupBinding
import com.atriz.create_group.di.CreateGroupComponent
import com.redmadrobot.extensions.viewbinding.viewBinding
import javax.inject.Inject
import javax.inject.Provider

class CreateGroupFragment : BaseFragment(R.layout.fragment_create_group) {

    @Inject
    internal lateinit var viewModelFactory: Provider<CreateGroupViewModel>
    private val viewModel by viewModels { viewModelFactory.get() }

    private val binding: FragmentCreateGroupBinding by viewBinding()

    override fun init() {
        CreateGroupComponent.Initializer
            .init(coreDependencyProvider)
            .inject(this)
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        binding.createGroupInputName.addTextChangedListener {
            viewModel.onNameChanged(it.toString())
        }

        binding.createGroupButtonSave.setOnClickListener {
            viewModel.onSaveClicked()
        }
    }

    override fun observeViewModel() {
        observe(viewModel.events, ::onEventReceived)
        observe(viewModel.viewState, ::onStateReceived)
    }

    private fun onStateReceived(state: CreateGroupViewState) {
        binding.createGroupButtonSave.isEnabled = state.isNameValid
    }
}
