package com.example.electricity.ui

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.electricity.R
import com.example.electricity.base.BaseActivity
import timber.log.Timber
import javax.inject.Inject

class RepositoriesActivity : BaseActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: RepositoriesViewModel
    override var contentViewId = R.layout.activity_repositories

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("onCreate()")
        initBinding()
    }

    private fun initBinding() {
        viewModel = ViewModelProvider(this, viewModelFactory).get(RepositoriesViewModel::class.java)
    }
}
