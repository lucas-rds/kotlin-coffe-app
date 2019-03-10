package com.cafe.querocafe.ioc

import android.app.Application
import com.cafe.querocafe.model.Person
import com.cafe.querocafe.repository.PurchaseRepository
import dagger.Module
import dagger.Provides

@Module(includes = [ViewModelsModule::class])
class ApplicationModule(private val app: Application) {

    @Provides
    fun provideApplication(): Application = app

    @Provides
    fun providePerson(): Person = Person("Lucas")

    @Provides
    fun providePurchaseRepository(): PurchaseRepository = PurchaseRepository()

}