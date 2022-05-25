package com.example.githubclient.domain.repository

import com.example.githubclient.domain.model.user.User
import com.example.githubclient.domain.model.user.UserDetails

interface UserRepository {

    suspend fun getUsers(since: Int, perPage: Int): Result<List<User>>

    suspend fun searchUsers(query: String, page: Int, perPage: Int): Result<List<User>>

    suspend fun getUserDetails(login: String): Result<UserDetails>
}