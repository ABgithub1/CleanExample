package com.example.githubclient.data.mapper

import com.example.githubclient.data.model.UserDTO
import com.example.githubclient.data.model.UserDetailsDTO
import com.example.githubclient.data.model.UserEntity
import com.example.githubclient.domain.model.user.User
import com.example.githubclient.domain.model.user.UserDetails

internal fun UserDTO.toDomainModel(): User {
    return User(
        id = id,
        login = login,
        avatarUrl = avatarUrl
    )
}

internal fun UserEntity.toDomainModel(): User {
    return User(
        id = id,
        login = login,
        avatarUrl = avatarUrl
    )
}

internal fun UserDetailsDTO.toDomainModel(): UserDetails {
    return UserDetails(
        id = id,
        login = login,
        avatarUrl = avatarUrl,
        followers = followers,
        following = following
    )
}

internal fun User.toUserEntity(): UserEntity {
    return UserEntity(
        id = id,
        login = login,
        avatarUrl = avatarUrl
    )
}