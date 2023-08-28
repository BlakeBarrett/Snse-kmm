package com.blakebarrett.snse.app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform