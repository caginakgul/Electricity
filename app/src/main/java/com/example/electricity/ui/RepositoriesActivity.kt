package com.example.electricity.ui

import android.os.Bundle

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.electricity.R
import com.example.electricity.base.BaseActivity
import com.example.electricity.network.data.RepositoryDetails
import com.example.electricity.ui.details.RepositoryDetailsBottomSheet
import kotlinx.android.synthetic.main.activity_repositories.*
import timber.log.Timber
import javax.inject.Inject

class RepositoriesActivity : BaseActivity(), OnItemClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: RepositoriesViewModel
    override var contentViewId = R.layout.activity_repositories
    private val bottomSheetTag: String = "BottomSheet"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("onCreate()")
        initBinding()
        initRecyclerView()
        fetchRepositoryData()
    }

    override fun onItemClicked(repo: RepositoryDetails) {
        RepositoryDetailsBottomSheet.newInstance(repo)
            .show(supportFragmentManager, bottomSheetTag)
    }

    private fun fetchRepositoryData() = viewModel.getNewsData().observe(this, Observer { repositoryList -> repositoryList?.let { displayRepositories(it) } })

    private fun initBinding() {
        viewModel = ViewModelProvider(this, viewModelFactory).get(RepositoriesViewModel::class.java)
    }

    private fun displayRepositories(items: List<RepositoryDetails>) {
        repositoryRecyclerView.adapter = RepositoryAdapter(items, this)
    }

    private fun initRecyclerView() {
        Timber.i("RecyclerView is initialised.")
        repositoryRecyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
    }
}
