package com.cafe.querocafe.ioc

import android.app.Application
import com.cafe.querocafe.model.Person
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val app: Application) {

    @Provides
    fun provideApplication(): Application = app

    @Provides
    fun providePerson(): Person = Person("Lucas")

}