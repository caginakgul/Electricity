package com.example.electricity.di.module

import com.example.electricity.network.GithubApi
import com.example.electricity.network.GithubRepository
import com.example.electricity.network.GithubRepositoryImpl
import dagger.Module
import dagger.Provides
import java.util.*
import javax.inject.Singleton

@Module
class DataRepositoryModule {
    @Provides
    @Singleton
    fun provideGithubRepository(
        githubApi: GithubApi,
        timer: Timer
    ): GithubRepository = GithubRepositoryImpl(githubApi, timer)
}
