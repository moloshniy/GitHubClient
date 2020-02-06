package com.example.githubapp.ui.screen.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubapp.R
import com.example.githubapp.domain.entity.Users.DomainUserInfoEntity
import com.example.githubapp.domain.exceptions.UncknownException
import com.example.githubapp.ui.screen.BaseDaggerActivity
import com.example.githubapp.ui.screen.repositores.RepositoriesActivity
import com.example.githubapp.utils.obslivedata.LdAction.*
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : BaseDaggerActivity() {

    lateinit var adapter: UsersAdapter
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Users"

        adapter = UsersAdapter(this) {
            val intent = Intent(this, RepositoriesActivity::class.java)
            intent.putExtra(RepositoriesActivity.INTENT_BUNDLE_KEY, it)
            startActivity(intent)
        }

        users_recycle_view.adapter = adapter
        users_recycle_view.layoutManager = LinearLayoutManager(
            this
            , LinearLayoutManager.VERTICAL,
            false
        )

        viewModel.getUsersLiveData().observe(this) {
            when (it) {
                is OnStart -> showProgressBar()
                is OnSuccess -> {
                    adapter.userList.clear()
                    adapter.userList.addAll(it.getValue())
                    adapter.notifyDataSetChanged()
                }
                is OnComplete -> hideProgressBar()
                is OnError -> when (it.getError()) {
                    is UncknownException -> showToast("UncknownException")
                    else -> showToast("Else Exception")
                }
            }
        }
    }
}

