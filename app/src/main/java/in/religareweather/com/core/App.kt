package `in`.religareweather.com.core

import `in`.religareweather.com.di.component.DaggerCoreComponent
import android.content.Context

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerCoreComponent
            .builder()
            .application(this)
            .build()
    }
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}