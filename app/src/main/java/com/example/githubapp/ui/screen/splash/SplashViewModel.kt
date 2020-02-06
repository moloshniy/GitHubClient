package com.example.githubapp.ui.screen.splash

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubapp.data.repository.RepositoryManager
import com.example.githubapp.ui.screen.main.MainActivity
import com.example.githubapp.ui.utils.SingleConsumed
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class SplashViewModel @Inject constructor(private val repository: RepositoryManager) : ViewModel() {

    private val isAuthenticatedLd:MutableLiveData<SingleConsumed<Boolean>> = MutableLiveData()

    fun getIsAuthenticatedLiveData(): LiveData<SingleConsumed<Boolean>> {
        return isAuthenticatedLd
    }

    fun checkAuthentication(){
        viewModelScope.launch {
            try {
                val isAuthenticated: Boolean = repository.isAuthenticated()
                isAuthenticatedLd.value = SingleConsumed(isAuthenticated)
            }
            catch (e:Exception){
                throw e
            }

        }
    }
}
