package com.example.electricity.ui

import androidx.lifecycle.LiveData
import com.example.electricity.base.BaseViewModel
import com.example.electricity.network.GithubRepository
import com.example.electricity.network.data.RepositoryDetails
import javax.inject.Inject

class RepositoriesViewModel @Inject constructor(
    private val githubRepository: GithubRepository
) : BaseViewModel() {
    fun getNewsData(): LiveData<List<RepositoryDetails>> =
        githubRepository.fetchPopularRepositories(QUERY_STRING)

    private companion object {
        private const val QUERY_STRING = "stars:>25000"
    }
}

