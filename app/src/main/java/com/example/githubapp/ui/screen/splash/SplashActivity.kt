package com.example.githubapp.ui.screen.splash

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.githubapp.R
import com.example.githubapp.ui.screen.BaseDaggerActivity
import com.example.githubapp.ui.screen.login.LoginActivity
import com.example.githubapp.ui.screen.main.MainActivity

class SplashActivity : BaseDaggerActivity() {

    lateinit var viewModel: SplashViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        viewModel = ViewModelProviders.of(this, factory).get(SplashViewModel::class.java)

        viewModel.getIsAuthenticatedLiveData().observe(this, Observer {
            when (it.getIfNotConsumed()) {
                true -> startActivity(Intent(this, MainActivity::class.java))
                false -> startActivity(Intent(this, LoginActivity::class.java))
            }
        })

        viewModel.checkAuthentication()
    }

}