package com.example.githubapp.ui.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubapp.data.repository.RepositoryManager
import com.example.githubapp.domain.entity.Users.DomainUserInfoEntity
import com.example.githubapp.utils.obslivedata.ObservableLiveData
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

class MainViewModel @Inject constructor(val repository: RepositoryManager) : ViewModel() {
    private val usersLiveData: ObservableLiveData<List<DomainUserInfoEntity>> =
        ObservableLiveData()

    init {
        getUsers()
    }

    fun getUsersLiveData(): ObservableLiveData<List<DomainUserInfoEntity>> {
        return usersLiveData
    }

    private fun getUsers() {
        usersLiveData.onStart()
        viewModelScope.launch {
            try {
                val usersList = repository.getUsers()
                usersLiveData.onSuccess(usersList)
            } catch (e: HttpException) {
               usersLiveData.onError(e)
            }finally {
                usersLiveData.onComplete()
            }
        }
    }
}