package com.example.githubapp.data.repository.server

import com.example.githubapp.data.entity.user.ServerUserInfoEntity
import com.example.githubapp.data.service.UsersService
import okhttp3.ResponseBody
import retrofit2.HttpException
import javax.inject.Inject

class ServerUserRepository @Inject constructor(private val service:UsersService) {

    suspend fun getUsers(): List<ServerUserInfoEntity> {
        try {
            return service.getUsersList().await()
        } catch (e: HttpException) {
            throw e
        }
    }
}