package com.example.usergithub.data.repositories

import com.example.usergithub.data.model.Users
import com.example.usergithub.data.remote.UsersGithubRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class UsersGithubRepository @Inject constructor(private val usersGithubRemoteDataSource: UsersGithubRemoteDataSource) {

    suspend fun getUsers(): Response<List<Users>> {
        return usersGithubRemoteDataSource.getUsers()
    }
}