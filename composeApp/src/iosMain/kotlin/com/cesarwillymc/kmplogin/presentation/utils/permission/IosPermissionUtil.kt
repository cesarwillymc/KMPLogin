package com.cesarwillymc.kmplogin.presentation.utils.permission

/**
 * Created by Cesar Canaza on 12/11/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
import com.cesarwillymc.kmplogin.presentation.utils.notifications.NotificationManagerIOS
import platform.UserNotifications.UNAuthorizationOptionAlert
import platform.UserNotifications.UNAuthorizationOptionBadge
import platform.UserNotifications.UNAuthorizationOptionSound
import platform.UserNotifications.UNAuthorizationStatusAuthorized
import platform.UserNotifications.UNUserNotificationCenter

class IosPermissionUtil(private val notificationCenter: UNUserNotificationCenter) : PermissionUtil {
    companion object {
        val NOTIFICATION_PERMISSIONS =
            UNAuthorizationOptionAlert or
                    UNAuthorizationOptionSound or
                    UNAuthorizationOptionBadge
    }

    override fun hasNotificationPermission(onPermissionResult: (Boolean) -> Unit) {
        notificationCenter.getNotificationSettingsWithCompletionHandler {
            onPermissionResult(it?.authorizationStatus == UNAuthorizationStatusAuthorized)
        }
    }

    override fun askNotificationPermission(onPermissionGranted: () -> Unit) {
        notificationCenter.requestAuthorizationWithOptions(NOTIFICATION_PERMISSIONS) { isGranted, _ ->
            if (isGranted) {
                UNUserNotificationCenter.currentNotificationCenter().delegate =
                    NotificationManagerIOS.NotificationDelegate()
                onPermissionGranted()
            }
        }
    }
}