package com.kanoyatech.runique

import android.app.Application
import com.kanoyatech.auth.data.di.authDataModule
import com.kanoyatech.auth.presentation.di.authViewModelModule
import com.kanoyatech.core.data.di.coreDataModule
import com.kanoyatech.runique.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp: Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
                coreDataModule
            )
        }
    }
}