package com.cesarwillymc.kmplogin.presentation.utils

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.toNSDateComponents
import platform.Foundation.NSDateFormatter

/**
 * Created by Cesar Canaza on 12/6/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
actual class DateFormat actual constructor(val pattern: String) {
    actual fun format(dateTime: LocalDateTime): String {
        val dateFormatter = NSDateFormatter()
        dateFormatter.dateFormat = pattern

        return dateTime.date.toNSDateComponents().date?.let { dateFormatter.stringFromDate(it) }.orEmpty()
    }
}