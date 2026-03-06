package com.app.fantasywhisper.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.app.fantasywhisper.ui.components.LobsterFont
import com.app.fantasywhisper.ui.components.PeopleSlider
import com.app.fantasywhisper.ui.components.TitleText
import com.app.fantasywhisper.ui.components.WhisperOptionsButton

@Composable
fun WhisperChooseScreen(onBack: () -> Unit) {
    var screen by remember { mutableStateOf("options") }
    var numberOfParticipants by remember { mutableStateOf(2) }

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

        Column (modifier = Modifier.padding(16.dp)) {
            TitleText("Choose a category")

            Spacer(Modifier.height(16.dp))

            Text(
                "Select number of people: $numberOfParticipants",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontFamily = LobsterFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp
                ),
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier.fillMaxWidth()
            )

            PeopleSlider(
                numberOfParticipants,
                onValueChange = {newValue -> numberOfParticipants = newValue}
            )
        }

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
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                WhisperOptionsButton("Custom sets", Modifier.weight(1f).padding(16.dp)) {
                    screen = "roleplaycaller"
                }
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
        "kinkcaller" -> KinkListCaller(WList.KINKS, numberOfParticipants,onBack)
        "cosplaycaller" -> KinkListCaller(WList.COSPLAY, numberOfParticipants, onBack)
        "roleplaycaller" -> KinkListCaller(WList.ROLEPLAY, numberOfParticipants, onBack)
        "placescaller" -> KinkListCaller(WList.PLACES, numberOfParticipants, onBack)
    }
}