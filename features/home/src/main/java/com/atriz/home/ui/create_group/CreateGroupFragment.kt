package com.atriz.home.ui.create_group

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.atriz.core.di.providers.coreDependencyProvider
import com.atriz.core_presentation.extensions.observe
import com.atriz.core_presentation.extensions.viewModels
import com.atriz.core_presentation.fragment.BaseFragment
import com.atriz.home.R
import com.atriz.home.databinding.FragmentCreateGroupBinding
import com.atriz.home.di.HomeComponent
import com.redmadrobot.extensions.viewbinding.viewBinding
import javax.inject.Inject
import javax.inject.Provider

class CreateGroupFragment : BaseFragment(R.layout.fragment_create_group) {

    @Inject
    internal lateinit var viewModelFactory: Provider<CreateGroupViewModel>
    private val viewModel by viewModels { viewModelFactory.get() }

    private val binding: FragmentCreateGroupBinding by viewBinding()

    override fun init() {
        HomeComponent.Initializer
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
        binding.createGroupButtonSave.isEnabled = state.isNotEmptyName
    }
}
