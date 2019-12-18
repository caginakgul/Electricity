package com.example.electricity.ui

import com.example.electricity.network.data.RepositoryDetails

interface OnItemClickListener {
    fun onItemClicked(repo: RepositoryDetails)
}
