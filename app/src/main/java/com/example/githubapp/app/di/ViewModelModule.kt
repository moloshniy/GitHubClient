package com.example.githubapp.app.di

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubapp.ui.ViewModelFactory
import com.example.githubapp.ui.screen.login.LoginViewModel
import com.example.githubapp.ui.screen.login.oauth.OauthViewModel
import com.example.githubapp.ui.screen.main.MainViewModel
import com.example.githubapp.ui.screen.repositores.RepositoriesViewModel
import com.example.githubapp.ui.screen.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface  ViewModelModule {

    @Binds
     fun provideViewModelFactory(viewModelFactory:ViewModelFactory):ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun mainViewModel(mainViewModel: MainViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun loginViewModel(loginViewModel:LoginViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RepositoriesViewModel::class)
    fun repositoriesViewModel(repositoriesViewModel: RepositoriesViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(OauthViewModel::class)
    fun oauthViewModel(repositoriesViewModel: OauthViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    fun splashViewModel(repositoriesViewModel: SplashViewModel):ViewModel
}