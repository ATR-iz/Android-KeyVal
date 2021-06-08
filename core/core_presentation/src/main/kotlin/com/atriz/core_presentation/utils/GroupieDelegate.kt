package com.atriz.core_presentation.utils

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.xwray.groupie.GroupieAdapter
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun Fragment.groupieAdapter(): ReadOnlyProperty<Any?, GroupieAdapter> {
    return GroupieDelegate(this)
}

class GroupieDelegate constructor(
    private val fragment: Fragment,
) : ReadOnlyProperty<Any?, GroupieAdapter> {

    private var groupieAdapter: GroupieAdapter? = null

    private val groupieCleaner: LifecycleObserver by lazy {
        object : LifecycleEventObserver {
            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    groupieAdapter = null
                    source.lifecycle.removeObserver(this)
                }
            }
        }
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): GroupieAdapter = groupieAdapter ?: obtainGroupie()

    private fun obtainGroupie() = GroupieAdapter().also(::saveGroupieIfNeed)

    private fun saveGroupieIfNeed(groupieAdapter: GroupieAdapter) {
        val lifecycle = fragment.viewLifecycleOwner.lifecycle
        // Save groupie if view is not destroyed
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) {
            this.groupieAdapter = groupieAdapter
            // Clean groupie on view destroy
            lifecycle.addObserver(groupieCleaner)
        }
    }
}
