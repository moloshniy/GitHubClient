package com.example.githubapp.data.service

import com.example.githubapp.data.entity.user.ServerUserInfoEntity
import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.http.GET

interface UsersService {

    @GET("users")
    fun getUsersList():Deferred<List<ServerUserInfoEntity>>
}