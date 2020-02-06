package com.example.githubapp.ui.screen.login.oauth

import android.net.Uri
import android.os.Build
import android.webkit.URLUtil
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi

class OauthWebViewClient (private val onReciveCode:(Uri)->Unit): WebViewClient()  {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun shouldOverrideUrlLoading(
        view: WebView?,
        request: WebResourceRequest?
    ): Boolean {
        val url = request?.url.toString()
        if (URLUtil.isNetworkUrl(url))
            return false
        onReciveCode(Uri.parse(url))
        return true
    }
}
