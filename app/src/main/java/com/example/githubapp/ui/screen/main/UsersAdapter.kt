package com.example.githubapp.ui.screen.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubapp.R
import com.example.githubapp.domain.entity.Users.DomainUserInfoEntity

class UsersAdapter(private val contex: Context, private val onItemClickListener:(DomainUserInfoEntity)->Unit) : RecyclerView.Adapter<UsersAdapter.UserHolder>() {

    val userList: MutableList<DomainUserInfoEntity> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val view = LayoutInflater.from(contex).inflate(R.layout.users_cell_layout, parent, false)
        return UserHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size;
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        Glide.with(contex).load(userList[position].avatarUrl).into(holder.imageView)
        holder.loginTextView.text = userList[position].login
        holder.itemView.setOnClickListener{onItemClickListener.invoke(userList[position])}

    }

    inner class UserHolder(private val v: View) : RecyclerView.ViewHolder(v) {
        val imageView: ImageView = v.findViewById(R.id.avatar_image_view)
        val loginTextView: TextView = v.findViewById(R.id.login_text_view)
    }
}