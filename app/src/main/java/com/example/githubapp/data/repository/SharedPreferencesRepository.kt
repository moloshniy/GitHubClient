package com.example.githubapp.data.repository

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreferencesRepository @Inject constructor (
    private val sharedPreferences: SharedPreferences ) {

    fun saveOauthAccessToken(token:String){
        sharedPreferences.edit().putString(OAUTH_ACCESS_TOKEN_KEY,token).apply()
    }

    fun getOauthAccessToken():String?{
        return sharedPreferences.getString(OAUTH_ACCESS_TOKEN_KEY,null)
    }

    fun containOauthAccessToken():Boolean{
        return getOauthAccessToken()!=null
    }
    companion object{
        private const val OAUTH_ACCESS_TOKEN_KEY:String = "OAUTH_ACCESS_TOKEN_KEY"
    }
}