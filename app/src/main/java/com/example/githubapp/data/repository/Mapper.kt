package com.example.githubapp.data.repository

import com.example.githubapp.data.entity.authenticate.ServerAccessTokenEntity
import com.example.githubapp.data.entity.repository.ServerRepositoryEntity
import com.example.githubapp.data.entity.user.ServerUserInfoEntity
import com.example.githubapp.domain.entity.Users.DomainUserInfoEntity
import com.example.githubapp.domain.entity.authenticate.DomainAccessTokenEntity
import com.example.githubapp.domain.entity.repository.DomainRepositoryEntity

class Mapper {
    fun convert (s: ServerAccessTokenEntity): DomainAccessTokenEntity{
        return DomainAccessTokenEntity(s.accessToken, s.scope)
    }

    fun convert (s: ServerRepositoryEntity): DomainRepositoryEntity{
        return DomainRepositoryEntity(
           s.id,s.repositoryShortName,s.repositoryFullName,s.isPrivate,s.watchersCount,s.repositoryOwner
        )
    }

    fun convert (s: List<ServerRepositoryEntity>): List<DomainRepositoryEntity>{
        val domainRepositoryList:MutableList<DomainRepositoryEntity> = ArrayList()
        s.forEach {
            domainRepositoryList.add(convert(it))
        }

        return domainRepositoryList
    }

    fun convert(s:ServerUserInfoEntity): DomainUserInfoEntity {
        return DomainUserInfoEntity(s.id,s.login,s.avatarUrl)
    }

    fun convertUserList(s:List<ServerUserInfoEntity>): List<DomainUserInfoEntity> {
      val l:MutableList<DomainUserInfoEntity> =  ArrayList()
       s.forEach{
            l.add(convert(it))
       }
        return l
    }


}