package com.cesarwillymc.kmplogin.presentation.screens.auth.event

import com.cesarwillymc.kmplogin.presentation.utils.viewModel.BaseEvent

/**
 * Created by Cesar Canaza on 12/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
sealed class AuthEvent : BaseEvent() {
    data object IsSuccess: AuthEvent()
    data object IsFailure: AuthEvent()
}