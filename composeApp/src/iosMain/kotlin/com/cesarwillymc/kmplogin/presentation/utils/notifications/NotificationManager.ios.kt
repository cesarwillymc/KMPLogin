package com.cesarwillymc.kmplogin.presentation.utils.notifications

import com.cesarwillymc.kmplogin.SharedRes
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.StringDesc

/**
 * Created by Cesar Canaza on 12/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
actual class NotificationManager actual constructor() {
    actual fun showForgotPasswordNotification() {
        createNotification(
            StringDesc.Resource(SharedRes.strings.lbl_check_email).localized(),
            StringDesc.Resource(SharedRes.strings.desc_check_email).localized()
        )
    }
}

fun createNotification(title: String, message: String) {
    NotificationManagerIOS().showNotification(title, message)
}