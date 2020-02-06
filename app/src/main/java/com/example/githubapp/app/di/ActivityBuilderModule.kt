package com.example.githubapp.app.di

import com.example.githubapp.ui.screen.login.LoginActivity
import com.example.githubapp.ui.screen.login.oauth.OauthActivity
import com.example.githubapp.ui.screen.main.MainActivity
import com.example.githubapp.ui.screen.repositores.RepositoriesActivity
import com.example.githubapp.ui.screen.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun provideMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun provideLoginActivity():LoginActivity

    @ContributesAndroidInjector
    abstract fun provideSplashActivity():SplashActivity

    @ContributesAndroidInjector
    abstract fun provideRepositoriesActivity(): RepositoriesActivity

    @ContributesAndroidInjector
    abstract fun provideOauthActivity(): OauthActivity


}