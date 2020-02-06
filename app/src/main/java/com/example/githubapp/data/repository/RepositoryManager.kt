package com.example.githubapp.data.repository

import android.net.Uri
import com.example.githubapp.data.entity.repository.ServerRepositoryEntity
import com.example.githubapp.data.repository.server.ServerAuthenticateRepository
import com.example.githubapp.data.repository.server.ServerReposityRepository
import com.example.githubapp.data.repository.server.ServerUserRepository
import com.example.githubapp.domain.entity.Users.DomainUserInfoEntity
import com.example.githubapp.domain.entity.authenticate.DomainAccessTokenEntity
import com.example.githubapp.domain.entity.repository.DomainRepositoryEntity
import javax.inject.Inject

class RepositoryManager @Inject constructor(
    private val serverAuthenticateRepository:ServerAuthenticateRepository,
    private val serverUserRepository: ServerUserRepository,
    private val serverReposityRepository:ServerReposityRepository,
    private val sharedPreferencesRepository: SharedPreferencesRepository,
    private val mapper:Mapper
) {
    suspend fun getOauthAccessToken(code: String) {
        val token = serverAuthenticateRepository.getOauthAccessToken(code)
        sharedPreferencesRepository.saveOauthAccessToken(token.accessToken)
    }

    suspend fun getMyRepositoryList():List<DomainRepositoryEntity> {
        val serverRepositoryList:List<ServerRepositoryEntity> = serverReposityRepository.getMyRepositoryList(sharedPreferencesRepository.getOauthAccessToken()!!)
        return mapper.convert(serverRepositoryList)
    }

    suspend fun getUserRepository(userName:String):List<DomainRepositoryEntity>{
        return mapper.convert(serverReposityRepository.getUserRepository(userName))
    }

    suspend fun getUsers():List<DomainUserInfoEntity>{
        return  mapper.convertUserList(serverUserRepository.getUsers())
    }

    suspend fun isAuthenticated(): Boolean {
      return sharedPreferencesRepository.containOauthAccessToken()
    }

    fun getOauthAutorizationUri(): Uri {
        return serverAuthenticateRepository.getOauthAutorizationUri()
    }

}

