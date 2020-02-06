package com.example.githubapp.data.repository.server

import android.net.Uri
import android.util.Base64
import com.example.githubapp.data.entity.authenticate.ServerAccessTokenEntity
import com.example.githubapp.data.service.AuthenticationService
import com.example.githubapp.domain.exceptions.UnAuthenticateException
import com.example.githubapp.domain.exceptions.UncknownException
import kotlinx.coroutines.delay
import retrofit2.HttpException
import java.lang.Exception
import javax.inject.Inject

class ServerAuthenticateRepository @Inject constructor(private val service:AuthenticationService) {
    companion object{
        private const val CLIENT_ID: String = "a4d19a625c23645bbee4"
        private const val CLIENT_SECRET: String = "70916ce5878658ed17be99f6afe49adca0dfb1c5"
        private const val OAUTH_CALLBACK_URL: String = "githubapp://callback"
        private const val AUTHORIZE_URI:String = "https://github.com/login/oauth/authorize"
    }

    suspend fun getOauthAccessToken(
        code: String
    ): ServerAccessTokenEntity {

        try {
            return service.getOauthAccessToken(CLIENT_ID, CLIENT_SECRET, code).await()
        } catch (e: HttpException) {
            when (e.code()){
                    401 -> throw UnAuthenticateException()
                    402 -> throw UnknownError()
                    else -> throw UncknownException()
                }
            }
        }

    fun getOauthAutorizationUri():Uri {
        return Uri.parse("$AUTHORIZE_URI?client_id=$CLIENT_ID&scope=repo&redirect_uri=$OAUTH_CALLBACK_URL")
    }
}

