package com.atriz.core_presentation.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.atriz.core_presentation.model.Event
import com.atriz.core_presentation.model.EventsQueue
import java.util.*

fun Fragment.observe(eventsQueue: EventsQueue, eventHandler: (Event) -> Unit) {
    eventsQueue.observe(
            this.viewLifecycleOwner,
            Observer<Queue<Event>> { queue: Queue<Event>? ->
                while (queue != null && queue.isNotEmpty()) {
                    eventHandler(queue.poll()!!)
                }
            }
    )
}

inline fun <reified T : Any, reified L : LiveData<T?>> Fragment.observe(
    liveData: L,
    noinline block: (T) -> Unit
) {
    liveData.observe(this.viewLifecycleOwner, Observer { it?.let { block.invoke(it) } })
}

val <T> MutableLiveData<T>.requireValue: T get() = this.value ?: error("required value not set")

inline fun <reified T : Any> MutableLiveData<T>.update(action: T.() -> T) {
    value = action.invoke(requireValue)
}

inline fun <reified T : Any> MutableLiveData<T>.set(newState: T) {
    value = newState
}
