package com.example.githubclient.data.model

import com.google.gson.annotations.SerializedName

internal data class UserDTO(
    val id: Long,
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrl: String
)