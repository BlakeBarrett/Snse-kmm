package com.blakebarrett.snse.app.android

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@Preview
@Composable
fun SentimentRowPreview() {
    SentimentRow(id = 0)
}


@Composable
fun SentimentRow(id: Long) {
    getSentimentById(id).let {sentiment ->
        Card(
            modifier = Modifier.background(
                color = Color.Magenta,
                shape = MaterialTheme.shapes.medium
            ).fillMaxSize()
        ) {
            Row (
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = sentiment.feeling
                )
                Text(
                    modifier = Modifier.padding(8.dp),
                    fontStyle = MaterialTheme.typography.body1.fontStyle,
                    text = sentiment.elaborate
                )
            }
        }
    }
}


fun getSentimentById(id: Long) : Sentiment {
    return Sentiment(
        timestamp = id,
        feeling = "\uD83D\uDE0A",
        intensity = 69,
        color = "",
        elaborate = "Lorem ipsum ...",
        water = true
        )
}