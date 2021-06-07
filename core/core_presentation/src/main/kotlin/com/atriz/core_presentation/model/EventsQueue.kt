package com.atriz.core_presentation.model

import androidx.annotation.MainThread
import androidx.lifecycle.MutableLiveData
import java.util.*

class EventsQueue : MutableLiveData<Queue<Event>>() {

    @MainThread
    fun onNext(event: Event) {
        val queue = value ?: LinkedList()
        queue.add(event)
        value = queue
    }
}
