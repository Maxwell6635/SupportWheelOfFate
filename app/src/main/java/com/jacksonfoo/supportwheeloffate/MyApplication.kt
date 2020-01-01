package com.jacksonfoo.supportwheeloffate

import android.app.Application
import com.jacksonfoo.supportwheeloffate.di.apiModule
import com.jacksonfoo.supportwheeloffate.di.networkModule
import com.jacksonfoo.supportwheeloffate.di.viewModelModule
import com.jakewharton.threetenabp.AndroidThreeTen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@Suppress("Unused")
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        startKoin {
            // declare used Android context
            androidContext(this@MyApplication)
            // declare modules
            modules(listOf(networkModule, apiModule, viewModelModule))
        }
    }
}