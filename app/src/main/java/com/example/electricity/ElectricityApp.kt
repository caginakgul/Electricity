package com.example.electricity

import android.app.Application
import com.example.electricity.di.component.DaggerElectricityComponent
import com.example.electricity.di.component.ElectricityComponent
import com.example.electricity.di.module.AppModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class ElectricityApp : Application(), HasAndroidInjector {
    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = activityDispatchingAndroidInjector

    companion object {
        @JvmStatic
        lateinit var component: ElectricityComponent
    }

    override fun onCreate() {
        super.onCreate()

        component = DaggerElectricityComponent.builder()
            .appModule(AppModule(this))
            .build()

        component.inject(this)
    }
}
