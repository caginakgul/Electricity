package com.example.electricity.network

import com.example.electricity.network.data.RepositoryListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {
    @GET("search/repositories")
    fun getPopularRepositories(
        @Query("q") query: String
    ): Call<RepositoryListResponse>
}
