package com.example.electricity.di.component

import com.example.electricity.ElectricityApp
import com.example.electricity.di.builder.ActivityBuilder
import com.example.electricity.di.module.*
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidInjectionModule::class,
        ActivityBuilder::class,
        HttpModule::class,
        DataRepositoryModule::class,
        ApiModule::class,
        TimeModule::class
    ]
)
interface ElectricityComponent {
    fun inject(app: ElectricityApp)
}
