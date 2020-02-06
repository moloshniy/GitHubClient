package com.example.githubapp.data.entity.user

import com.google.gson.annotations.SerializedName

class ServerUserInfoEntity(
    @SerializedName("id")val id:Int,
    @SerializedName("login")val login:String,
    @SerializedName("avatar_url")val avatarUrl:String
)