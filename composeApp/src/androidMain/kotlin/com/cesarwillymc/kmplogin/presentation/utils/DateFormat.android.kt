package com.cesarwillymc.kmplogin.presentation.utils

import android.os.Build
import androidx.core.util.PatternsCompat
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.Date
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.number
import kotlinx.datetime.toJavaLocalDate

/**
 * Created by Cesar Canaza on 12/6/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
actual class DateFormat actual constructor(val pattern: String) {
    actual fun format(dateTime: LocalDateTime): String {
        val javaDateTime = dateTime.date.toJavaLocalDate()
        PatternsCompat.EMAIL_ADDRESS
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            javaDateTime.format(DateTimeFormatter.ofPattern(pattern))
        } else {
            return SimpleDateFormat(pattern).format(Date(dateTime.year,dateTime.month.number, dateTime.dayOfMonth))
        }
    }
}