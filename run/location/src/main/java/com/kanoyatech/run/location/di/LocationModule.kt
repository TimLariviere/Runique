package com.kanoyatech.run.location.di

import com.kanoyatech.run.domain.LocationObserver
import com.kanoyatech.run.location.LocationObserverImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val locationModule = module {
    singleOf(::LocationObserverImpl).bind<LocationObserver>()
}