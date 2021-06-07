package com.atriz.core_presentation.extensions

import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@MainThread
inline fun <reified VM : ViewModel> Fragment.viewModels(
    crossinline viewModelProducer: () -> VM
): Lazy<VM> {
    return lazy(LazyThreadSafetyMode.NONE) { createViewModel { viewModelProducer() } }
}

@MainThread
inline fun <reified VM : ViewModel> Fragment.createViewModel(
    crossinline viewModelProducer: () -> VM
): VM {
    val factory = object : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <VM : ViewModel> create(modelClass: Class<VM>) = viewModelProducer() as VM
    }
    val viewModelProvider = ViewModelProvider(this, factory)
    return viewModelProvider[VM::class.java]
}
