package com.example.githubapp.app.di

import com.example.githubapp.data.repository.SessionRepository
import com.example.githubapp.data.repository.server.ServerInterceptor
import com.example.githubapp.data.service.AuthenticationService
import com.example.githubapp.data.service.RepositoryService
import com.example.githubapp.data.service.UsersService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

@Module
class RetrofitModule {

    companion object {
        val BASE_URL: String = "https://api.github.com/"
        val CLIENT_ID: String = "a4d19a625c23645bbee4"
        val CLIENT_SECRET: String = "70916ce5878658ed17be99f6afe49adca0dfb1c5"
        val CALLBACK_URL:String = "githubapp://callback"
    }

    @Provides
    fun provideLogginginterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Provides
    fun provideServerInterceptor(sessionRepository: SessionRepository):ServerInterceptor{
        return ServerInterceptor(sessionRepository)
    }

    @Provides
    fun provideOkHttp(httpLoggingInterceptor: HttpLoggingInterceptor, serverInterceptor: ServerInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).addInterceptor(serverInterceptor).build()
    }

    @Provides
    fun provideRetrofitBuilder(okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpClient)
            .baseUrl(BASE_URL)
    }

    @Provides
    fun provideRetrofit(retrofitBuilder: Retrofit.Builder): Retrofit {
        return retrofitBuilder.build()
    }

    @Provides
    fun provideAuthenticationService(retrofit: Retrofit): AuthenticationService {
        return retrofit.create(AuthenticationService::class.java)
    }

    @Provides
    fun provideRepositoryService(retrofit: Retrofit): RepositoryService {
        return retrofit.create(RepositoryService::class.java)
    }

    @Provides
    fun provideUserService(retrofit: Retrofit): UsersService {
        return retrofit.create(UsersService::class.java)
    }

}