package com.kanoyatech.auth.data.di

import com.kanoyatech.auth.data.AuthRepositoryImpl
import com.kanoyatech.auth.data.EmailPatternValidator
import com.kanoyatech.auth.domain.AuthRepository
import com.kanoyatech.auth.domain.PatternValidator
import com.kanoyatech.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator()
    }
    singleOf(::UserDataValidator)
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}