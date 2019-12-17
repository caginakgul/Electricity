package com.example.electricity.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.electricity.R
import com.example.electricity.network.data.RepositoryDetails
import kotlinx.android.synthetic.main.repository_item.view.*

class RepositoryAdapter(
    private val repos: List<RepositoryDetails>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {
    override fun getItemCount() = repos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(repos[position], itemClickListener)
    }

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        fun bind(repository: RepositoryDetails, clickListener: OnItemClickListener) {
            itemView.nameTextView.text = repository.name
            itemView.languageTextView.text = repository.language
            itemView.setOnClickListener { clickListener.onItemClicked(repository) }
        }
    }
}
