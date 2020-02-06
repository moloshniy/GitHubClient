package com.example.githubapp.data.repository.server

import com.example.githubapp.data.entity.repository.ServerRepositoryEntity
import com.example.githubapp.data.service.RepositoryService
import okhttp3.ResponseBody
import retrofit2.HttpException
import javax.inject.Inject

class ServerReposityRepository @Inject constructor(private val service:RepositoryService) {

    suspend fun getMyRepositoryList(token:String): List<ServerRepositoryEntity> {
        try {
           val list:List<ServerRepositoryEntity> =   service.getMyRepository().await()
            val str:String
            return list

        } catch (e: HttpException) {
            throw  e
        }
    }

    suspend fun getUserRepository(userName:String):List<ServerRepositoryEntity>{
        try {
            val body:List<ServerRepositoryEntity> = service.getUserRepository(userName).await()
            return body
        }
        catch (e:HttpException){
            throw e
        }
    }
}