package com.example.githubclient.domain.model.user

data class UserDetails(
    val id: Long,
    val login: String,
    val avatarUrl: String,
    val followers: Int,
    val following: Int
)