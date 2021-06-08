package com.atriz.home.ui.home

import android.os.Bundle
import android.view.View
import com.atriz.core.di.providers.coreDependencyProvider
import com.atriz.core_presentation.extensions.observe
import com.atriz.core_presentation.extensions.viewModels
import com.atriz.core_presentation.fragment.BaseFragment
import com.atriz.core_presentation.utils.groupieAdapter
import com.atriz.home.R
import com.atriz.home.databinding.FragmentHomeBinding
import com.atriz.home.di.HomeComponent
import com.redmadrobot.extensions.viewbinding.viewBinding
import javax.inject.Inject
import javax.inject.Provider

class HomeFragment : BaseFragment(R.layout.fragment_home) {

    @Inject
    internal lateinit var viewModelFactory: Provider<HomeViewModel>
    private val viewModel by viewModels { viewModelFactory.get() }

    private val binding: FragmentHomeBinding by viewBinding()

    private val pagesAdapter by groupieAdapter()

    override fun init() {
        HomeComponent.Initializer
                .init(coreDependencyProvider)
                .inject(this)
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        binding.homeViewpager.adapter = pagesAdapter
    }

    override fun observeViewModel() {
        observe(viewModel.events, ::onEventReceived)
        observe(viewModel.viewState, ::onStateReceived)
    }

    private fun onStateReceived(state: HomeViewState) {
        pagesAdapter.update(state.pageItems)
    }
}
