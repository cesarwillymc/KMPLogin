package com.cesarwillymc.kmplogin

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform