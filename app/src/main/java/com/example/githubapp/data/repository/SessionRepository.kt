package com.example.githubapp.data.repository

import javax.inject.Inject

class  SessionRepository @Inject constructor(private val sharedPreference:SharedPreferencesRepository) {
    fun  getOauthAccessToken(): String?{
        return sharedPreference.getOauthAccessToken()
    }
}