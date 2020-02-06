package com.example.githubapp.domain.entity.repository

import com.example.githubapp.data.entity.repository.ServerRepositoryOwner

class DomainRepositoryEntity (
    val id: Long,
    val repositoryShortName: String,
    val repositoryFullName: String,
    val isPrivate: Boolean,
    val watchersCount: Int,
    val repositoryOwner: ServerRepositoryOwner
)