package com.example.githubapp.data.service

import com.example.githubapp.data.entity.authenticate.ServerAccessTokenEntity
import kotlinx.coroutines.Deferred
import retrofit2.http.*

interface AuthenticationService {

    @POST("https://github.com/login/oauth/access_token")
    @Headers("Accept: application/json")
    @FormUrlEncoded
    fun getOauthAccessToken(@Field("client_id")clientID:String, @Field("client_secret")clientSecret:String, @Field("code")code:String): Deferred<ServerAccessTokenEntity>
}