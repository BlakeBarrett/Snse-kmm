package com.blakebarrett.snse.app.android

data class Sentiment(
    val timestamp: Long,
    val feeling: String,
    val intensity: Int,
    val color: String,
    val water: Boolean,
    val elaborate: String
)