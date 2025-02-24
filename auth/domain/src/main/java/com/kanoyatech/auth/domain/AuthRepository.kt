package com.kanoyatech.auth.domain

import com.kanoyatech.core.domain.util.DataError
import com.kanoyatech.core.domain.util.EmptyResult

interface AuthRepository {
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
    suspend fun login(email: String, password: String): EmptyResult<DataError.Network>
}