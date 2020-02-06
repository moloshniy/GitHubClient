package com.example.githubapp.data.entity.repository

import com.google.gson.annotations.SerializedName

class ServerRepositoryEntity(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val repositoryShortName: String,
    @SerializedName("full_name") val repositoryFullName: String,
    @SerializedName("private") val isPrivate: Boolean,
    @SerializedName("watchers_count") val watchersCount: Int,
    @SerializedName("owner") val repositoryOwner: ServerRepositoryOwner
)
