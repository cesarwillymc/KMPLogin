package com.cesarwillymc.kmplogin.presentation.validations.field

import com.cesarwillymc.kmplogin.presentation.validations.TextFieldState
import com.cesarwillymc.kmplogin.presentation.validations.common.CommonRules

/**
 * Created by cesarwillymamanicanaza on 28/07/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
class EmailField : TextFieldState(
    validations = listOf(CommonRules.notEmptyField, CommonRules.validEmail)
)
