package com.cesarwillymc.kmplogin.presentation.utils

import kotlinx.datetime.LocalDateTime

/**
 * Created by Cesar Canaza on 12/6/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
expect class DateFormat(pattern:String) {
    fun format(dateTime: LocalDateTime): String
}