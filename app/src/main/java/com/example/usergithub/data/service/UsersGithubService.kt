package com.example.usergithub.data.service

import com.example.usergithub.data.model.Users
import retrofit2.Response
import retrofit2.http.GET

interface UsersGithubService {

    @GET("users")
    suspend fun getUsers(): Response<List<Users>>
}