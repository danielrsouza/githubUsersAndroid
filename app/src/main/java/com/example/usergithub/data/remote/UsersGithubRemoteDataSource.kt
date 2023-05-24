package com.example.usergithub.data.remote

import com.example.usergithub.data.model.Users
import com.example.usergithub.data.service.UsersGithubService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UsersGithubRemoteDataSource constructor(private val usersGithubService: UsersGithubService) {

    suspend fun getUsers(): Response<List<Users>> {
        val result: Response<List<Users>>

        withContext(Dispatchers.IO) {
            result = usersGithubService.getUsers()
        }

        return result
    }
}