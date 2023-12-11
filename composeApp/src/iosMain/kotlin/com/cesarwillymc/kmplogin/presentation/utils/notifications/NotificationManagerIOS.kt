package com.cesarwillymc.kmplogin.presentation.utils.notifications
import platform.UIKit.UIApplication
import platform.UIKit.UIUserNotificationSettings
import platform.UIKit.UIUserNotificationType
import platform.UIKit.registerUserNotificationSettings
import platform.UserNotifications.UNMutableNotificationContent
import platform.UserNotifications.UNNotificationRequest
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


 class NotificationManagerIOS  {

    private val notificationCenter = UNUserNotificationCenter.currentNotificationCenter()

//    init {
//        notificationCenter.delegate = NotificationDelegate()
//        val settings = UIUserNotificationSettings.settingsForTypes(
//            UIUserNotificationType.MAX_VALUE,
//            categories = null
//        )
//        UIApplication.sharedApplication.registerUserNotificationSettings(settings)
//    }

     fun showNotification(title: String, body: String) {
        val content = UNMutableNotificationContent().apply {
            setTitle(title)
            setBody(body)
        }

        val trigger = UNTimeIntervalNotificationTrigger.triggerWithTimeInterval(5.0, repeats = false)

        val request:UNNotificationRequest = UNNotificationRequest.requestWithIdentifier(
            "notification_id",
            content = content,
            trigger = trigger
        )

        notificationCenter.addNotificationRequest(request,null)
    }

    // Delegate to handle notifications
    private class NotificationDelegate : NSObject(), UNUserNotificationCenterDelegateProtocol {
        // Implement delegate methods if needed
    }
}
