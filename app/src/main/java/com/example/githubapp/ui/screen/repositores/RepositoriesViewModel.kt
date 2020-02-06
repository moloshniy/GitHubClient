package com.example.githubapp.ui.screen.repositores

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubapp.data.repository.RepositoryManager
import com.example.githubapp.domain.entity.repository.DomainRepositoryEntity
import com.example.githubapp.utils.obslivedata.ObservableLiveData
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

class RepositoriesViewModel @Inject constructor(val repository: RepositoryManager) : ViewModel() {

    private val userRepositoryLiveData: ObservableLiveData<List<DomainRepositoryEntity>> =
        ObservableLiveData()


    fun getUserRepositoryLiveData(): ObservableLiveData<List<DomainRepositoryEntity>> {
        return userRepositoryLiveData
    }

    fun getUserRepository(userName:String){
        userRepositoryLiveData.onStart()
        viewModelScope.launch {
            try {
                val reposotoryList = repository.getUserRepository(userName)
                userRepositoryLiveData.onSuccess(reposotoryList)
            } catch (e: HttpException) {
                userRepositoryLiveData.onError(e)
            }finally {
                userRepositoryLiveData.onComplete()
            }
        }
    }

}