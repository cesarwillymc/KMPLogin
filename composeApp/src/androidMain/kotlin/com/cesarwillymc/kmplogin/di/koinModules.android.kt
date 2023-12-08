package com.cesarwillymc.kmplogin.di

import android.content.Context
import com.cesarwillymc.kmplogin.framework.getDataStore
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module
    get() = module {
        single { getDataStore(get<Context>()) }
    }