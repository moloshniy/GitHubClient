package com.example.githubapp.data.repository.server

import com.bumptech.glide.RequestBuilder
import com.example.githubapp.data.repository.SessionRepository
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.InputStream
import javax.inject.Inject

class ServerInterceptor @Inject constructor(private val sessionRepository: SessionRepository) : Interceptor {
    companion object {
        private const val AUTHORIZATION_HEADER = "Authorization"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request:Request = chain.request()
        val requestBuilder:Request.Builder = request.newBuilder()
        val token = sessionRepository.getOauthAccessToken()
        if (token != null)
            requestBuilder.addHeader(AUTHORIZATION_HEADER, "token $token")

        return chain.proceed(requestBuilder.build())
    }
}