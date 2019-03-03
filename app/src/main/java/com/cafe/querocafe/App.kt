package com.cafe.querocafe

import android.app.Application
import com.cafe.querocafe.ioc.ApplicationModule
import com.cafe.querocafe.ioc.ApplicationComponent
import com.cafe.querocafe.ioc.DaggerApplicationComponent

class App : Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}