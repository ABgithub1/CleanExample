package com.example.githubclient.domain.usecase

import com.example.githubclient.domain.model.user.User
import com.example.githubclient.domain.repository.UserRepository

class GetUsersUseCase(private val userRepository: UserRepository) {

    suspend operator fun invoke(since: Int, perPage: Int): Result<List<User>> {
        return userRepository.getUsers(since, perPage)
    }
}