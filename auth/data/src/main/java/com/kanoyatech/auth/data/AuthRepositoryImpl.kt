package com.kanoyatech.auth.data

import com.kanoyatech.auth.domain.AuthRepository
import com.kanoyatech.core.data.networking.post
import com.kanoyatech.core.domain.AuthInfo
import com.kanoyatech.core.domain.SessionStorage
import com.kanoyatech.core.domain.util.DataError
import com.kanoyatech.core.domain.util.EmptyResult
import com.kanoyatech.core.domain.util.Result
import com.kanoyatech.core.domain.util.asEmptyDataResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient,
    private val sessionStorage: SessionStorage
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

    override suspend fun login(email: String, password: String): EmptyResult<DataError.Network> {
        val result = httpClient.post<LoginRequest, LoginResponse>(
            route = "/login",
            body = LoginRequest(
                email = email,
                password = password
            )
        )

        if (result is Result.Success) {
            sessionStorage.set(
                AuthInfo(
                    accessToken = result.data.accessToken,
                    refreshToken = result.data.refreshToken,
                    userId = result.data.userId
                )
            )
        }

        return result.asEmptyDataResult()
    }
}