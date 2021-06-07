package com.atriz.auth.ui.auth

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.atriz.auth.R
import com.atriz.auth.databinding.FragmentAuthBinding
import com.atriz.auth.di.AuthComponent
import com.atriz.core.di.providers.coreDependencyProvider
import com.atriz.core_presentation.extensions.observe
import com.atriz.core_presentation.extensions.viewModels
import com.atriz.core_presentation.fragment.BaseFragment
import com.redmadrobot.extensions.viewbinding.viewBinding
import javax.inject.Inject
import javax.inject.Provider

class AuthFragment : BaseFragment(R.layout.fragment_auth) {

    @Inject
    internal lateinit var viewModelFactory: Provider<AuthViewModel>
    private val viewModel by viewModels { viewModelFactory.get() }

    private val binding: FragmentAuthBinding by viewBinding()

    override fun init() {
        AuthComponent.Initializer
                .init(coreDependencyProvider)
                .inject(this)
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        binding.authInputPassword.addTextChangedListener {
            viewModel.onPasswordChanged(it.toString())
        }

        binding.authButtonConfirm.setOnClickListener {
            viewModel.onButtonConfirmClicked()
        }
    }

    override fun observeViewModel() {
        observe(viewModel.events, ::onEventReceived)
    }
}
