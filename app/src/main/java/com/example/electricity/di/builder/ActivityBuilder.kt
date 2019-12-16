package com.example.electricity.di.builder

import com.example.electricity.di.module.RepositoriesActivityModule
import com.example.electricity.ui.RepositoriesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [RepositoriesActivityModule::class])
    internal abstract fun contributeRepositoriesActivity(): RepositoriesActivity
}
