package com.example.electricity.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.electricity.base.ElectricityViewModelFactory
import com.example.electricity.ui.RepositoriesViewModel
import dagger.Module
import dagger.Provides

@Module
class RepositoriesActivityModule {
    @Provides
    fun provideRepositoriesViewModel(repoViewModel: RepositoriesViewModel): ViewModelProvider.Factory {
        return ElectricityViewModelFactory(repoViewModel)
    }
}
