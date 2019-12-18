package com.example.electricity.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.electricity.network.data.RepositoryDetails
import com.example.electricity.network.data.RepositoryListResponse
import retrofit2.Call
import retrofit2.Response
import timber.log.Timber
import java.util.*

class GithubRepositoryImpl(
    private val api: GithubApi,
    private val timer: Timer
) : GithubRepository {
    override fun fetchPopularRepositories(query: String): LiveData<List<RepositoryDetails>> {
        val liveData: MutableLiveData<List<RepositoryDetails>> = MutableLiveData()
        timer.scheduleAtFixedRate(
            object : TimerTask() {
                override fun run() {
                    api.getPopularRepositories(query)
                        .enqueue((object : retrofit2.Callback<RepositoryListResponse> {
                            override fun onFailure(
                                call: Call<RepositoryListResponse>?,
                                t: Throwable?
                            ) {
                                Timber.e("request failed %s", t?.message)
                                liveData.value = null
                            }

                            override fun onResponse(
                                call: Call<RepositoryListResponse>?,
                                response: Response<RepositoryListResponse>?
                            ) {
                                Timber.i(
                                    "request successful and total size is%s",
                                    response?.body()?.items?.size
                                )
                                liveData.value = response?.body()?.items
                            }
                        }))
                }
            }, 0, 60000
        )
        return liveData
    }
}

