package com.example.githubclient.data.repository

import com.example.githubclient.data.api.GithubApi
import com.example.githubclient.data.mapper.toDomainModel
import com.example.githubclient.domain.repository.UserRepository

internal class UserRepositoryImpl(private val githubApi: GithubApi) : UserRepository {

    override suspend fun getUsers(since: Int, perPage: Int) = runCatching {
        githubApi.getUsers(since, perPage)
    }.map { users ->
        users.map { it.toDomainModel() }
    }

    override suspend fun searchUsers(query: String, page: Int, perPage: Int) = runCatching {
        githubApi.searchUsers(query, page, perPage)
    }.map { searchedUsers ->
        searchedUsers.items.map { it.toDomainModel() }
    }

    override suspend fun getUserDetails(login: String) = runCatching {
        githubApi.getUserDetails(login)
    }.map {
        it.toDomainModel()
    }
}