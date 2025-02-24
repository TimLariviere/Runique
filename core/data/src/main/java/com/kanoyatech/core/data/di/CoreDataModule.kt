package com.kanoyatech.core.data.di

import com.kanoyatech.core.data.auth.EncryptedSessionStorage
import com.kanoyatech.core.data.networking.HttpClientFactory
import com.kanoyatech.core.domain.SessionStorage
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
}