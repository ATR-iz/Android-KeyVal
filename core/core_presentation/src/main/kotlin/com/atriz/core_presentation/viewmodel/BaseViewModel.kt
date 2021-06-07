package com.atriz.core_presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.atriz.core_presentation.model.EventsQueue
import com.atriz.core_presentation.model.ShowMessage

open class BaseViewModel<T> : ViewModel() {

    val events = EventsQueue()

    val viewState = MutableLiveData<T>()

    protected fun showMessage(message: String) {
        events.onNext(ShowMessage(message))
    }
}
