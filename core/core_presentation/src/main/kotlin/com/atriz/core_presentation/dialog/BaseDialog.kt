package com.atriz.core_presentation.dialog

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment
import com.atriz.core_presentation.activity.BaseActivity
import com.atriz.core_presentation.model.*

abstract class BaseDialog(@LayoutRes contentLayoutId: Int) : DialogFragment(contentLayoutId) {

    protected abstract fun init()

    protected abstract fun initView(view: View, savedInstanceState: Bundle?)

    protected abstract fun observeViewModel()

    override fun onAttach(context: Context) {
        init()
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view, savedInstanceState)
        observeViewModel()
    }

    @CallSuper
    protected open fun onEventReceived(event: Event) {
        when (event) {
            is NavigateEvent -> handleNavigateEvent(event)
            is ShowMessage -> showMessage(event.message)
        }
    }

    private fun showMessage(message: String) {
        val activity = activity as BaseActivity
        activity.showMessage(message)
    }

    private fun handleNavigateEvent(event: NavigateEvent) {
        val activity = activity as BaseActivity

        when (event) {
            is Navigate -> activity.navigate(event.directions)
            is NavigateUp -> activity.navigateUp()
        }
    }
}
