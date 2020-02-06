package com.example.githubapp.data.entity.repository

import com.google.gson.annotations.SerializedName

class ServerRepositoryOwner (
    @SerializedName("login")val login:String,
    @SerializedName("id")val id:String,
    @SerializedName("avatar_url")val avatarURL:String
)