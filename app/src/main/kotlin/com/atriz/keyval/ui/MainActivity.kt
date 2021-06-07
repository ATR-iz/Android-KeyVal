package com.atriz.keyval.ui

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.atriz.core.di.providers.coreDependencyProvider
import com.atriz.core_presentation.activity.BaseActivity
import com.atriz.core_presentation.navigation.NavigationHolder
import com.atriz.keyval.R
import com.atriz.keyval.di.components.MainComponent
import javax.inject.Inject

class MainActivity : BaseActivity() {

    override val navController: NavController
        get() = findNavController(R.id.root_container)

    @Inject
    lateinit var navigationHolder: NavigationHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainComponent.Initializer
                .init(coreDependencyProvider)
                .inject(this)
    }

    override fun onResume() {
        super.onResume()

        navigate(navigationHolder.toAuthGraph)
    }
}
