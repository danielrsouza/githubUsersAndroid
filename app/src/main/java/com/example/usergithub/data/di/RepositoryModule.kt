package com.example.usergithub.data.di

import com.example.usergithub.data.remote.UsersGithubRemoteDataSource
import com.example.usergithub.data.repositories.UsersGithubRepository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    fun provideUserGithubRepository(usersGithubRemoteDataSource: UsersGithubRemoteDataSource): UsersGithubRepository =
        UsersGithubRepository(usersGithubRemoteDataSource)
}