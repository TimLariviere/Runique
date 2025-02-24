package com.kanoyatech.auth.data

import com.kanoyatech.auth.domain.AuthRepository
import com.kanoyatech.core.data.networking.post
import com.kanoyatech.core.domain.util.DataError
import com.kanoyatech.core.domain.util.EmptyResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient
): AuthRepository {
    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }
}