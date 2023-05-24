package com.example.usergithub.data.di

import com.example.usergithub.data.remote.UsersGithubRemoteDataSource
import com.example.usergithub.data.service.UsersGithubService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceModule {

    @Singleton
    @Provides
    fun provideUsersGithubRemoteDataSource(usersGithubService: UsersGithubService): UsersGithubRemoteDataSource =
        UsersGithubRemoteDataSource(usersGithubService)
}