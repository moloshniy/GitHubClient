package com.example.githubapp.ui.screen.login.oauth

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.example.githubapp.data.repository.RepositoryManager
import javax.inject.Inject

class OauthViewModel @Inject constructor(private val repository: RepositoryManager) : ViewModel() {

    fun getOauthAutorizationUri():Uri {
        return repository.getOauthAutorizationUri()
    }
}