package com.example.githubclient.domain.usecase

import com.example.githubclient.domain.model.user.UserDetails
import com.example.githubclient.domain.repository.UserRepository

class GetUserDetailsUseCase(private val userRepository: UserRepository) {

    suspend operator fun invoke(login: String): Result<UserDetails> {
        return userRepository.getUserDetails(login)
    }
}