package com.cesarwillymc.kmplogin.presentation.utils.notifications

import com.cesarwillymc.kmplogin.presentation.utils.permission.IosPermissionUtil
import com.cesarwillymc.kmplogin.presentation.utils.permission.PermissionUtil
import org.koin.core.component.KoinComponent
import platform.UIKit.UIApplication
import platform.UIKit.UIUserNotificationSettings
import platform.UIKit.UIUserNotificationType
import platform.UIKit.registerUserNotificationSettings
import org.koin.core.component.get
import org.koin.core.qualifier.named

import platform.UserNotifications.UNMutableNotificationContent
import platform.UserNotifications.UNNotification
import platform.UserNotifications.UNNotificationPresentationOptions
import platform.UserNotifications.UNNotificationRequest
import platform.UserNotifications.UNNotificationResponse
import platform.UserNotifications.UNNotificationSound
import platform.UserNotifications.UNTimeIntervalNotificationTrigger
import platform.UserNotifications.UNUserNotificationCenter
import platform.UserNotifications.UNUserNotificationCenterDelegateProtocol
import platform.darwin.NSObject

/**
 * Created by Cesar Canaza on 12/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */


class NotificationManagerIOS: KoinComponent{
     private val permissionUtil: IosPermissionUtil = get()
    private val notificationCenter: UNUserNotificationCenter  = UNUserNotificationCenter.currentNotificationCenter()


    fun showNotification(title: String, body: String) {
        permissionUtil.askNotificationPermission {
            val content = UNMutableNotificationContent().apply {
                setTitle(title)
                setBody(body)
                setSound(UNNotificationSound.defaultSound)
            }

            val trigger =
                UNTimeIntervalNotificationTrigger.triggerWithTimeInterval(1.0, repeats = false)

            val request: UNNotificationRequest = UNNotificationRequest.requestWithIdentifier(
                "notification_id",
                content = content,
                trigger = trigger
            )

            notificationCenter.addNotificationRequest(request) { error ->
                error?.let { println("Error showing notification: $error") }
            }
        }

    }

    internal class NotificationDelegate : UNUserNotificationCenterDelegateProtocol, NSObject() {
        override fun userNotificationCenter(
            center: UNUserNotificationCenter,
            didReceiveNotificationResponse: UNNotificationResponse,
            withCompletionHandler: () -> Unit,
        ) {

            withCompletionHandler()
        }

        override fun userNotificationCenter(
            center: UNUserNotificationCenter,
            willPresentNotification: UNNotification,
            withCompletionHandler: (UNNotificationPresentationOptions) -> Unit,
        ) {
            withCompletionHandler(IosPermissionUtil.NOTIFICATION_PERMISSIONS)
        }
    }
}
