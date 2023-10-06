package com.blakebarrett.snse.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.blakebarrett.snse.app.android.SetupNavigation
import com.blakebarrett.snse.app.android.SnseApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SnseApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SetupNavigation()
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    SnseApplicationTheme {
        SetupNavigation()
    }
}
