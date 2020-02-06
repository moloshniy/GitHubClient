package com.example.githubapp.ui.screen.login.oauth

import android.content.Intent
import android.os.Bundle

import androidx.lifecycle.ViewModelProviders
import com.example.githubapp.R
import com.example.githubapp.ui.screen.BaseDaggerActivity
import kotlinx.android.synthetic.main.activity_oauth.*

class OauthActivity : BaseDaggerActivity() {

    private lateinit var viewModel: OauthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oauth)

        viewModel = ViewModelProviders.of(this, factory).get(OauthViewModel::class.java)

        browser.webViewClient = OauthWebViewClient {
            var intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.data = it
            startActivity(intent)
        }

        browser.loadUrl(viewModel.getOauthAutorizationUri().toString())
    }
}
