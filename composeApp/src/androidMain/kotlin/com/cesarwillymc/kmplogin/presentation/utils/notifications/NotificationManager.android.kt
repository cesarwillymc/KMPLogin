package com.cesarwillymc.kmplogin.presentation.utils.notifications

import android.content.Context
import com.cesarwillymc.kmplogin.R
import com.cesarwillymc.kmplogin.presentation.notification.createNotificationChannel
import com.cesarwillymc.kmplogin.presentation.notification.showNotification
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

/**
 * Created by Cesar Canaza on 12/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
actual class NotificationManager actual constructor() : KoinComponent {
    private val context: Context = get<Context>()
    actual fun showForgotPasswordNotification() {
        context.createNotificationChannel()
        context.showNotification(
            context.getString(R.string.lbl_check_email),
            context.getString(R.string.desc_check_email)
        )
    }
}