package com.example.electricity.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.electricity.base.BaseViewModel
import com.example.electricity.network.GithubRepository
import com.example.electricity.network.data.RepositoryDetails
import javax.inject.Inject

class RepositoriesViewModel @Inject constructor(
    private val githubRepository: GithubRepository
) : BaseViewModel() {
    val viewData: MutableLiveData<List<RepositoryDetails>> = MutableLiveData()

    fun getNewsData(): LiveData<List<RepositoryDetails>> {
        return githubRepository.fetchPopularRepositories(QUERY_STRING)
    }

    private companion object{
        private const val QUERY_STRING = "stars:>25000"
    }
}

