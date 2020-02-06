package com.example.githubapp.ui.screen.repositores

import android.os.Bundle
import android.widget.TableLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubapp.R
import com.example.githubapp.domain.entity.Users.DomainUserInfoEntity
import com.example.githubapp.domain.exceptions.UncknownException
import com.example.githubapp.ui.screen.BaseDaggerActivity
import com.example.githubapp.ui.screen.main.RepositoryAdapter
import com.example.githubapp.utils.obslivedata.LdAction.*
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_repositories.*

class RepositoriesActivity : BaseDaggerActivity() {

    lateinit var adapter: RepositoryAdapter
    lateinit var viewModel: RepositoriesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repositories)

        viewModel = ViewModelProviders.of(this, factory).get(RepositoriesViewModel::class.java)
        adapter = RepositoryAdapter(this) {}
        users_recycle_view.adapter = adapter
        users_recycle_view.layoutManager = LinearLayoutManager(
            this
            , LinearLayoutManager.VERTICAL,
            false
        )

        intent.getParcelableExtra<DomainUserInfoEntity>(INTENT_BUNDLE_KEY)?.let {
            viewModel.getUserRepository(it.login)
        }

        viewModel.getUserRepositoryLiveData().observe(this) {
            when (it) {
                is OnStart -> showProgressBar()
                is OnSuccess -> {
                    adapter.repositoryList.clear()
                    adapter.repositoryList.addAll(it.getValue())
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

    companion object {
        const val INTENT_BUNDLE_KEY: String = "INTENT_BUNDLE_KEY"
    }
}
