package com.kanoyatech.run.presentation.di

import com.kanoyatech.run.domain.RunningTracker
import com.kanoyatech.run.presentation.active_run.ActiveRunViewModel
import com.kanoyatech.run.presentation.run_overview.RunOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val runViewModelModule = module {
    singleOf(::RunningTracker)
    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}