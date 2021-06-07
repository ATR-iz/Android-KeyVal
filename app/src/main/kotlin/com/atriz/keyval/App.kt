package com.atriz.keyval

import android.app.Application
import com.atriz.core.di.app.DaggerApplication
import com.atriz.core.di.providers.CoreDependencyProvider
import com.atriz.keyval.di.DI
import com.atriz.keyval.utils.PrettyLoggingTree
import net.danlew.android.joda.JodaTimeAndroid
import timber.log.Timber

class App : Application(), DaggerApplication {

    override fun onCreate() {
        super.onCreate()
        initTimber()
        DI.initComponent(this)
        JodaTimeAndroid.init(this)
    }

    private fun initTimber() {
        if (BuildConfig.ENABLE_LOGS) {
            Timber.plant(PrettyLoggingTree(this))
        }
    }

    override fun coreDependencyProvider(): CoreDependencyProvider = DI.appComponent
}
