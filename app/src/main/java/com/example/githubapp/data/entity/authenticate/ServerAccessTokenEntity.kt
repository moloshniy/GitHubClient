package com.example.githubapp.data.entity.authenticate

import com.google.gson.annotations.SerializedName

class ServerAccessTokenEntity(
    @SerializedName("access_token")val accessToken: String,
    @SerializedName("scope")val scope: String
)