package com.example.githubclient.data.api

import com.example.githubclient.data.model.SearchedUsersDTO
import com.example.githubclient.data.model.UserDTO
import com.example.githubclient.data.model.UserDetailsDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface GithubApi {

    @GET("users")
    suspend fun getUsers(
        @Query("since") since: Int,
        @Query("per_page") perPage: Int
    ): List<UserDTO>

    @GET("users/{login}")
    suspend fun getUserDetails(
        @Path("login") login: String
    ): UserDetailsDTO

    @GET("search/users")
    suspend fun searchUsers(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): SearchedUsersDTO
}