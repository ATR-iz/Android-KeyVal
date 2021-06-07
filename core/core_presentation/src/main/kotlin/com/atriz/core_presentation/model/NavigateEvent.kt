package com.atriz.core_presentation.model

import androidx.navigation.NavDirections

interface NavigateEvent : Event
class Navigate(val directions: NavDirections) : NavigateEvent
object NavigateUp : NavigateEvent
