package com.example.githubapp.ui.screen.login

import android.util.Log
import androidx.lifecycle.*
import com.example.githubapp.data.repository.RepositoryManager
import com.example.githubapp.utils.obslivedata.ObservableLiveData
import kotlinx.coroutines.delay


import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject
import kotlin.random.Random

class LoginViewModel @Inject constructor(private val repository: RepositoryManager) : ViewModel() {

    val loginOauthLiveData: ObservableLiveData<Unit> = ObservableLiveData()

    fun getOauthAccessToken(code: String) {
        loginOauthLiveData.onStart()
        viewModelScope.launch {
            try {
                repository.getOauthAccessToken(code)
                loginOauthLiveData.onSuccess(Unit)
            } catch (e: Exception) {
                loginOauthLiveData.onError(e)
            } finally {
                loginOauthLiveData.onComplete()
            }


        }
    }
}