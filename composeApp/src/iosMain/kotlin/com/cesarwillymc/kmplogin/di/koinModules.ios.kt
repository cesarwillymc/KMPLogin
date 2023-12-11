package com.cesarwillymc.kmplogin.di

import com.cesarwillymc.kmplogin.framework.getDataStore
import com.cesarwillymc.kmplogin.presentation.utils.notifications.NotificationManagerIOS
import com.cesarwillymc.kmplogin.presentation.utils.permission.IosPermissionUtil
import com.cesarwillymc.kmplogin.presentation.utils.permission.PermissionUtil
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module
import platform.UserNotifications.UNUserNotificationCenter

actual val platformModule: Module
    get() = module {
        single { getDataStore() }
        factory { IosPermissionUtil(notificationCenter = UNUserNotificationCenter.currentNotificationCenter()) }
        factory {
            NotificationManagerIOS()
        }

    }