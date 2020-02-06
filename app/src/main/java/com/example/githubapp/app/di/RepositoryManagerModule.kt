package com.example.githubapp.app.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.githubapp.data.repository.Mapper
import com.example.githubapp.data.repository.SharedPreferencesRepository
import com.example.githubapp.data.repository.server.ServerUserRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryManagerModule {

    companion object{
        private val SHARED_PREFERENCES_NAME:String = "SHARED_PREFERENCES_NAME"
    }

    @Provides
    fun provideSharedPreference(application: Application):SharedPreferences{
        return application.baseContext.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

    @Provides
    fun provideSharedPreferenceRepository(sharedPreference:SharedPreferences):SharedPreferencesRepository{
        return SharedPreferencesRepository(sharedPreference)
    }

    @Provides
    fun provideMapper():Mapper{
        return Mapper()
    }
}