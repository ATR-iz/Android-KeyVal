package com.atriz.group.ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.atriz.core.di.providers.coreDependencyProvider
import com.atriz.core_presentation.extensions.observe
import com.atriz.core_presentation.extensions.viewModels
import com.atriz.core_presentation.fragment.BaseFragment
import com.atriz.core_presentation.navigation.HomeNavigationHolder
import com.atriz.core_presentation.utils.groupieAdapter
import com.atriz.group.R
import com.atriz.group.databinding.FragmentGroupBinding
import com.atriz.group.di.GroupComponent
import com.redmadrobot.extensions.viewbinding.viewBinding
import javax.inject.Inject

class GroupFragment : BaseFragment(R.layout.fragment_group) {

    @Inject
    lateinit var viewModelFactory: GroupViewModel.Factory
    private val viewModel: GroupViewModel by viewModels {
        viewModelFactory.get(requireArguments().getLong(HomeNavigationHolder.GROUP_ID))
    }

    private val binding: FragmentGroupBinding by viewBinding()

    private val accountsAdapter by groupieAdapter()

    override fun init() {
        GroupComponent.Initializer
                .init(coreDependencyProvider)
                .inject(this)
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        binding.groupListAccounts.layoutManager = LinearLayoutManager(context)
        binding.groupListAccounts.adapter = accountsAdapter

        binding.groupButtonCreateAccount.setOnClickListener {
            viewModel.onCreateAccountClicked()
        }

        viewModel.onViewCreated()
    }

    override fun observeViewModel() {
        observe(viewModel.events, ::onEventReceived)
        observe(viewModel.viewState, ::onStateReceived)
    }

    private fun onStateReceived(state: GroupViewState) {
        accountsAdapter.update(state.accountItems)
    }
}
