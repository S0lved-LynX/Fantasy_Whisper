package com.example.fantasywhisper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.fantasywhisper.ui.theme.FantasyWhisperTheme
import com.example.fantasywhisper.ui.screens.ContentScreen
import com.example.fantasywhisper.ui.screens.WhisperChooseScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FantasyWhisperTheme {
                FantasyWhisperApp()
            }
        }
    }
}

@PreviewScreenSizes
@Composable
fun FantasyWhisperApp() {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }

    val showBottom = currentDestination != AppDestinations.LIST

    if (showBottom) {
        NavigationSuiteScaffold(
            navigationSuiteItems = {
                AppDestinations.entries
                    .filter { it != AppDestinations.LIST && it != AppDestinations.RESULT }
                    .forEach {
                        var isSelected = it == currentDestination


                        item(
                            icon = {
                                Box(
                                    modifier = Modifier
                                        .size(48.dp),
                                    contentAlignment = Alignment.BottomCenter
                                ) {
                                    Icon(
                                        it.icon,
                                        contentDescription = it.label,
                                        modifier = Modifier
                                            .size(if (isSelected) 48.dp else 32.dp)
                                    )
                                }
                            },
                            label = { Text(it.label) },
                            selected = isSelected,
                            onClick = { currentDestination = it }
                        )
                    }
            }
        ) {

            ContentScreen(currentDestination) {
                currentDestination = AppDestinations.LIST
            }
        }
    } else {
        WhisperChooseScreen {
            currentDestination = AppDestinations.HOME
        }
    }
}

enum class AppDestinations(
    val label: String,
    val icon: ImageVector,
) {
    HOME("Home", Icons.Default.Home),
    DISCLAIMER("Disclaimer",Icons.Default.Info),
    LIST("List", Icons.Default.Menu),
    RESULT("Results",Icons.Default.Done)
}