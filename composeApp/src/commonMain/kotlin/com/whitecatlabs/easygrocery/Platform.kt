package com.whitecatlabs.easygrocery

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform