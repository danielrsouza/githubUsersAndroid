package com.example.usergithub.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.usergithub.R
import com.example.usergithub.databinding.ActivityMainBinding
import com.example.usergithub.ui.adapters.UsersGithubAdapter
import com.example.usergithub.ui.viewmodels.UiState
import com.example.usergithub.ui.viewmodels.UsersGithubViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val usersGithubViewModel: UsersGithubViewModel by viewModels()
    private val usersGithubAdapter: UsersGithubAdapter = UsersGithubAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.adapter = usersGithubAdapter
        handleGetUsers()
        setupObserver()

        setContentView(binding.root)

    }

    private fun handleGetUsers() {
        usersGithubViewModel.getUsers()
    }

    private fun setupObserver() {
        usersGithubViewModel.uiState.observe(this) { uiState ->
            when(uiState) {
                is UiState.Loading -> Log.i("test", "Loading")
                is UiState.Failure -> Log.i("test", "failure")
                is UiState.Success -> {
                    usersGithubAdapter.setUsers(uiState.data)
                }
            }
        }
    }
}