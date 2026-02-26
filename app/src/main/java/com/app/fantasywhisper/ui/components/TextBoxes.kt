package com.app.fantasywhisper.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.app.fantasywhisper.ui.theme.White

@Composable
fun TitleText (title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineMedium.copy(
            fontWeight = FontWeight.Bold
        ),
        textAlign = TextAlign.Center,
        color = Color.White,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun EmptyResult (onEndWhisper: () -> Unit) {
    Scaffold { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.secondary)
                .padding(padding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = MaterialTheme.colorScheme.secondary
                    )
                    .padding(6.dp)
            ) {
                TitleText("Result")
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(start = 6.dp, top = 32.dp, end = 6.dp, bottom = 32.dp)
                        .weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        MaterialTheme.colorScheme.primary,
                                        MaterialTheme.colorScheme.surface,
                                        MaterialTheme.colorScheme.tertiary
                                    )
                                ),
                                shape = RoundedCornerShape(16.dp))
                            .padding(12.dp)
                    ) {
                        Text(
                            text = "It looks like you don't have anything in common, but don't be sad! Try to communicate with your partner and maybe you will find something you both want to try. Or you can try to negotiate a compromise. \nAfter all this app is about communication, so don't be sad about the result and try to find different solution to make your desires come true.\n\n (And also remember: tastes can change!)",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.White.copy(alpha = 0.9f)
                        )
                    }

                }
                Button(
                    onClick = onEndWhisper,
                    modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
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