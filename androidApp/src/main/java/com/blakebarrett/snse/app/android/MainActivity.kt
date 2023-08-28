package com.blakebarrett.snse.app.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

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

enum class Routes(val route: String) {
    NEW("new"), LIST("list")
}

@Composable
fun SetupNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.LIST.route) {
        composable(
            Routes.NEW.route
        ) {
            ComposeSentiment {
                navController.navigate(Routes.LIST.route)
            }
        }
        composable(
            Routes.LIST.route
        ) {
            SetupSentimentsList {
                navController.navigate(Routes.NEW.route)
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SetupSentimentsList(
    composeNew: () -> Unit
) {
    val selectedSentiment = rememberSaveable {
        mutableLongStateOf(0L)
    }
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(
            initialValue = BottomSheetValue.Collapsed
        )
    )
    val coroutineScope = rememberCoroutineScope()
    BottomSheetScaffold(
        modifier = Modifier.fillMaxSize(),
        sheetContent = {
            // The content you want to show in your bottom sheet
            ShowSentiment(id = selectedSentiment.longValue)
        },
        scaffoldState = bottomSheetScaffoldState
    ) { paddingValues ->
        Scaffold(
            modifier = Modifier.padding(paddingValues),
            floatingActionButton = {
                FloatingActionButton(onClick = composeNew) {
                    Icon(Icons.Filled.AddCircle, "New")
                }
            },
        ) { paddingValues ->
            LazyColumn(
                modifier = Modifier.padding(paddingValues)
            ) {
                items(100) {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(paddingValues)
                        .padding(8.dp)
                        .clickable {
                            selectedSentiment.longValue = it.toLong()
                            coroutineScope.launch {
                                bottomSheetScaffoldState.bottomSheetState.expand()
                            }
                        }
                    ) {
                        Text(text = "\uD83D\uDE0A")
                        Text(text = "Lorem ipsum ...")
                    }
                }
            }
        }
    }
}

@Composable
fun ShowSentiment(id: Long) {
}

@Composable
fun ComposeSentiment(
    submit: () -> Unit
) {

}