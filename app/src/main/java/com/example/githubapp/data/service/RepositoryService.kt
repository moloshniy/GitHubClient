package com.example.githubapp.data.service

import com.example.githubapp.data.entity.repository.ServerRepositoryEntity
import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface RepositoryService {

    @GET("user/repos")
    fun getMyRepository(): Deferred<List<ServerRepositoryEntity>>

    @GET("users/{username}/repos")
    fun getUserRepository(@Path("username")userName:String):Deferred<List<ServerRepositoryEntity>>
}