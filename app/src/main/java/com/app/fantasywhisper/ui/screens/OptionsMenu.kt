package com.app.fantasywhisper.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
//import com.app.fantasywhisper.ui.theme.Blood
import com.app.fantasywhisper.ui.theme.White
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.app.fantasywhisper.ui.components.ResultItem
import com.app.fantasywhisper.ui.components.WhisperOptionsButton
import com.app.fantasywhisper.ui.data.cosplayItems
import com.app.fantasywhisper.ui.data.kinkItems
import com.app.fantasywhisper.ui.data.placesItems
import com.app.fantasywhisper.ui.data.roleplayItems

@Composable
fun WhisperChooseScreen(onBack: () -> Unit) {
    var screen by remember { mutableStateOf("options") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.surface,
                        MaterialTheme.colorScheme.tertiary
                    )
                ),
                shape = RoundedCornerShape(16.dp))
            .padding(start = 12.dp, top = 64.dp, end = 12.dp, bottom = 32.dp)
    ) {
        Text(
            modifier = Modifier.align(Alignment.TopCenter),
            style = MaterialTheme.typography.headlineLarge,
            color = White,
            text = "Choose a category"
        )

        Column(
            modifier = Modifier.align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                WhisperOptionsButton("Kinks"   , Modifier.weight(1f)) { screen = "kinkcaller"}
                WhisperOptionsButton("Cosplay" , Modifier.weight(1f)) { screen = "cosplaycaller" }
            }
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                WhisperOptionsButton("Roleplay", Modifier.weight(1f)) { screen = "roleplaycaller" }
                WhisperOptionsButton("Places"  , Modifier.weight(1f)) { screen = "placescaller" }
            }
        }

        BackHandler(enabled = true) { onBack() }
        Button(
            onClick = onBack,
            modifier = Modifier.align(Alignment.BottomStart)
        ) {
            Text("Back")
        }


    }

    // Change screen when button is clicked
    when (screen) {
        "kinkcaller" -> KinkListCaller(WList.KINKS,onBack)
        "cosplaycaller" -> KinkListCaller(WList.COSPLAY,onBack)
        "roleplaycaller" -> KinkListCaller(WList.ROLEPLAY,onBack)
        "placescaller" -> KinkListCaller(WList.PLACES, onBack)
    }
}

@Composable
fun ResultScreen(listType: WList, number: MutableState<BooleanArray>, onEndWhisper: () -> Unit) {
    val sourceList = when (listType) {
        WList.ROLEPLAY -> roleplayItems
        WList.COSPLAY -> cosplayItems
        WList.PLACES -> placesItems
        WList.KINKS -> kinkItems
    }
    val result = number.value
    var indexes = remember {mutableStateListOf<Int>()}

    for (i in result.indices) {
        if (result[i]) {
            indexes.add(i)
        }
    }

    Scaffold { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.tertiary)
                .padding(padding)
        ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            color = MaterialTheme.colorScheme.tertiary
                        )
                        .padding(6.dp)
                ) {
                    Text(
                        text = "Results",
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Text(
                        text = "You both want to try or have in common:",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White.copy(alpha = 0.9f)
                    )


                    LazyColumn(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items (indexes.size) { index ->
                            val data = sourceList[indexes[index]]
                            val title = data.name
                            val description = data.description

                            ResultItem(
                                title,
                                description
                            )
                        }
                    }


                    Button(
                        onClick = onEndWhisper,
                        modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors (
                            MaterialTheme.colorScheme.surface,
                            White
                        )
                    ) {
                        Text("End Whisper")
                    }
                }
            }

    }
}
