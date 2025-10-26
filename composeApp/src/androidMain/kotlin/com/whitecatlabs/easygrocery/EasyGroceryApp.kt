package com.whitecatlabs.easygrocery

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
class EasyGroceryApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@EasyGroceryApp)
        }
    }
}

fun initKoin(config: (KoinApplication.() -> Unit)? = null) {
    startKoin {
        config?.invoke(this)
        modules(allModules + platformModule())
    }
}
