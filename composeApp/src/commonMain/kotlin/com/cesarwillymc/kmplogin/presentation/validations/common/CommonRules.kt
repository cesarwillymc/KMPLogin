package com.cesarwillymc.kmplogin.presentation.validations.common

import com.cesarwillymc.kmplogin.presentation.validations.entities.FieldValidator

/**
 * Created by cesarwillymamanicanaza on 28/07/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
object CommonRules {
    private const val PASSWORD_REGEX = "^(?=.*?[A-Z])(?=.*?[0-9])(?=.*[@#\$%^&+=.\\-_*!'<>,/:;?])" +
        "(?=" +
        ".*?[^\\s]).{8,}$"
    private const val EMAIL_REGEX = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+"

    val notEmptyField = FieldValidator(
        isSuccessValidator = { it.isNotEmpty() }
    )
    val validEmail = FieldValidator(
        isSuccessValidator = {
            EMAIL_REGEX.toRegex().matches(it)
        }
    )
    val validPassword = FieldValidator(
        isSuccessValidator = {
            // PASSWORD_REGEX.toRegex().matches(it) }
            it.isNotEmpty()
        }

    )
}
