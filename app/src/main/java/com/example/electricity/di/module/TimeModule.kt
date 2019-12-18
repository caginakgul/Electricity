package com.example.electricity.di.module

import dagger.Module
import dagger.Provides
import java.util.*
import javax.inject.Singleton

@Module
class TimeModule {
    @Provides
    @Singleton
    fun provideTimer(): Timer = Timer()
}
