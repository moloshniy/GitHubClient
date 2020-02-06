package com.example.githubapp.ui.screen.login

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.githubapp.R
import com.example.githubapp.domain.exceptions.UncknownException
import com.example.githubapp.ui.screen.BaseDaggerActivity
import com.example.githubapp.ui.screen.login.oauth.OauthActivity
import com.example.githubapp.ui.screen.main.MainActivity

import com.example.githubapp.utils.obslivedata.LdAction.*

import kotlinx.android.synthetic.main.activity_login.*
import java.lang.Exception

// android:noHistory="true" in manifest
class LoginActivity : BaseDaggerActivity() {

    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        viewModel = ViewModelProviders.of(this, factory).get(LoginViewModel::class.java)

        viewModel.loginOauthLiveData.apply {
            observe(this@LoginActivity) {
                when (it) {
                    is OnStart -> showProgressBar()
                    is OnSuccess ->it.doSingleValue {moveToMainActivity()}
                    is OnComplete -> hideProgressBar()
                    is OnError -> when (it.getError()) {
                    is UncknownException -> showToast("UncknownException")
                    else -> showToast("Else Exception")
                }
                }
            }
        }

        login_oauth_button.setOnClickListener() {
             val intent = Intent(this, OauthActivity::class.java)
            startActivity(intent)

        }

        fun handleOauthCallBack() {
            intent.data?.let { uri ->
                uri.getQueryParameter("code")?.let { code ->
                    viewModel.getOauthAccessToken(code)
                }
            }
        }

        handleOauthCallBack()
    }

    fun moveToMainActivity() {
        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        startActivity(intent)
    }

}
