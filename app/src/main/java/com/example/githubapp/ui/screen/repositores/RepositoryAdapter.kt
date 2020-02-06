package com.example.githubapp.ui.screen.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.githubapp.R
import com.example.githubapp.domain.entity.Users.DomainUserInfoEntity
import com.example.githubapp.domain.entity.repository.DomainRepositoryEntity

class RepositoryAdapter(
    private val contex: Context,
    private val onItemClickListener: (DomainRepositoryEntity) -> Unit
) : RecyclerView.Adapter<RepositoryAdapter.RepositoryHolder>() {

    val repositoryList: MutableList<DomainRepositoryEntity> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryHolder {
        val view = LayoutInflater.from(contex).inflate(R.layout.users_cell_layout, parent, false)
        return RepositoryHolder(view)
    }

    override fun getItemCount(): Int {
        return repositoryList.size;
    }

    override fun onBindViewHolder(holder: RepositoryHolder, position: Int) {
        holder.repositoryName.text = repositoryList[position].repositoryFullName
        holder.itemView.setOnClickListener { onItemClickListener.invoke(repositoryList[position]) }
    }

    inner class RepositoryHolder(private val v: View) : RecyclerView.ViewHolder(v) {
        val repositoryName: TextView = v.findViewById(R.id.login_text_view)
    }
}