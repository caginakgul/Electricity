package com.example.electricity.di.module

import android.app.Application
import android.content.Context
import com.example.electricity.ElectricityApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: ElectricityApp) {
    @Provides
    @Singleton
    fun providesElectricityApp(): ElectricityApp = app

    @Provides
    @Singleton
    fun providesApp(): Application = app

    @Provides
    @Singleton
    fun provideContext(): Context = app
}
