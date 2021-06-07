package com.atriz.keyval.di

import android.content.Context
import com.atriz.keyval.di.components.AppComponent
import com.atriz.keyval.di.components.DaggerAppComponent

object DI {

    lateinit var appComponent: AppComponent

    fun initComponent(context: Context) {
        appComponent = DaggerAppComponent
                .builder()
                .context(context)
                .build()
    }
}
