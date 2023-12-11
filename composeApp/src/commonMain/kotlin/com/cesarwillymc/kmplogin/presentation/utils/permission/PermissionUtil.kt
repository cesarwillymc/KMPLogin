package com.cesarwillymc.kmplogin.presentation.utils.permission

/**
 * Created by Cesar Canaza on 12/11/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
internal interface PermissionUtil {
    fun hasNotificationPermission(onPermissionResult: (Boolean) -> Unit = {})
    fun askNotificationPermission(onPermissionGranted: () -> Unit = {})
}