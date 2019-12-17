package com.example.electricity.network.data

import com.google.gson.annotations.SerializedName

data class RepositoryDetails(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("html_url") val html_url: String,
    @SerializedName("stargazers_count") val stargazersCount: Long,
    @SerializedName("language") val language: String,
    @SerializedName("open_issues_count") val openIssuesCount: Int
)
