package com.cafe.querocafe.ioc

import com.cafe.querocafe.App
import com.cafe.querocafe.view.MainActivity
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApplicationModule::class
    ]
)
interface ApplicationComponent {
    fun inject(application: App)
    fun inject(activity: MainActivity)
}
