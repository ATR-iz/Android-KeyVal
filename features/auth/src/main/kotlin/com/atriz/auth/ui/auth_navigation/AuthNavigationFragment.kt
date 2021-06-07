package com.atriz.auth.ui.auth_navigation

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.atriz.auth.di.AuthComponent
import com.atriz.auth.model.HashKey
import com.atriz.core.di.providers.coreDependencyProvider
import com.atriz.core_presentation.activity.BaseActivity
import javax.inject.Inject

class AuthNavigationFragment : Fragment() {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AuthComponent.Initializer
            .init(coreDependencyProvider)
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val hash = sharedPreferences.getString(HashKey.name, "")

        val action = if (hash.isNullOrEmpty()) {
            AuthNavigationFragmentDirections.toNewPasswordFragment()
        } else {
            AuthNavigationFragmentDirections.toAuthFragment()
        }

        (this.requireActivity() as BaseActivity).navigate(action)

        return super.onCreateView(inflater, container, savedInstanceState)
    }
}
