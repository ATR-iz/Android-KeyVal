package com.atriz.keyval.utils

import android.content.Context
import com.atriz.keyval.R
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import timber.log.Timber

class PrettyLoggingTree(context: Context) : Timber.Tree() {

    companion object {
        private const val COUNT = 2
        private const val OFFSET = 7
    }

    init {
        val formatStrategy = PrettyFormatStrategy.newBuilder()
                .tag(context.getString(R.string.app_name))
                .showThreadInfo(false)
                .methodCount(COUNT)
                .methodOffset(OFFSET)
                .build()

        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
    }

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        Logger.log(priority, tag, message, t)
    }
}
