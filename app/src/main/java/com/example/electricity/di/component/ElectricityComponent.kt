package com.example.electricity.di.component

import com.example.electricity.ElectricityApp
import com.example.electricity.di.builder.ActivityBuilder
import com.example.electricity.di.module.AppModule
import com.example.electricity.di.module.HttpModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidInjectionModule::class,
        ActivityBuilder::class,
        HttpModule::class
    ]
)
interface ElectricityComponent {
    fun inject(app: ElectricityApp)
}
