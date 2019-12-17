package com.example.electricity.network

import androidx.lifecycle.LiveData
import com.example.electricity.network.data.RepositoryDetails

interface GithubRepository {
    fun fetchPopularRepositories(query: String): LiveData<List<RepositoryDetails>>
}
