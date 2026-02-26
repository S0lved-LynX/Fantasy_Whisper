package com.app.fantasywhisper.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.app.fantasywhisper.AppDestinations
import com.app.fantasywhisper.ui.components.AppMenuButton
import com.app.fantasywhisper.ui.components.BulletText
import com.app.fantasywhisper.ui.components.EmptyResult
import com.app.fantasywhisper.ui.components.ListLink
import com.app.fantasywhisper.ui.components.NumText
import com.app.fantasywhisper.ui.components.ResultItem
import com.app.fantasywhisper.ui.components.TitleText
import com.app.fantasywhisper.ui.data.cosplayItems
import com.app.fantasywhisper.ui.data.kinkItems
import com.app.fantasywhisper.ui.data.placesItems
import com.app.fantasywhisper.ui.data.roleplayItems
import com.app.fantasywhisper.ui.theme.White


@Composable
fun ContentScreen(
    destinations: AppDestinations,
    onStartWhisper: () -> Unit
) {
    when (destinations) {
        AppDestinations.HOME -> Scaffold(
            modifier = Modifier
                .fillMaxSize()
        ) { innerPadding ->
            MenuTextBox(modifier = Modifier.padding(innerPadding), onStartWhisper)
        }
        AppDestinations.DISCLAIMER -> Scaffold(
            modifier = Modifier
                .fillMaxSize()
        ) { innerPadding ->
            DisclaimerBox(modifier = Modifier.padding(innerPadding), onStartWhisper)
        }
        else -> {}
    }
}

@Composable
fun MenuTextBox(modifier: Modifier, onStartWhisper: () -> Unit) {
    Scaffold { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary)
                .padding(padding)
                .offset(x=0.dp,y=20.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colorScheme.secondary,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(8.dp)

            ) {
                val scrollState = rememberScrollState()


                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    MaterialTheme.colorScheme.primary,
                                    MaterialTheme.colorScheme.surface,
                                    MaterialTheme.colorScheme.tertiary
                                )
                            ),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .padding(6.dp)
                ) {
                    TitleText("Welcome")

                    Spacer(Modifier.height(16.dp))

                    Text(
                        text = "Do you want to try something different with your partner and you don't know how to tell them about your desires? Are you a shy person? I built a communication tool for you!",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White.copy(alpha = 0.9f)
                    )

                    Spacer(Modifier.height(16.dp))
                    NumText(1, "Choose category you want to \"Whisper\"")
                    NumText(2, "Fill in your desires privately and then let your partner do the same.")
                    NumText(3, "See ONLY desires that you both have in common.")
                    NumText(4, "And communicate what to do with the result. \nNow it might be a bit easier, don't you think so?")

                    Spacer(Modifier.height(128.dp))

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AppMenuButton(
                            onClick = onStartWhisper
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun DisclaimerBox(modifier: Modifier, onStartWhisper: () -> Unit) {
    Scaffold { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary)
                .padding(padding)
                .offset(x=0.dp,y=20.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colorScheme.secondary,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(8.dp)

            ) {
                val scrollState = rememberScrollState()


                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    MaterialTheme.colorScheme.primary,
                                    MaterialTheme.colorScheme.surface,
                                    MaterialTheme.colorScheme.tertiary
                                )
                            ),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .padding(6.dp)
                ) {
                    TitleText("Disclaimer")

                    Spacer(Modifier.height(16.dp))

                    BulletText("Consent is mandatory. Never use this app to coerce or force anyone into any activity.")
                    BulletText("Privacy Warning: Sharing your desires requires trust. If someone checks all items, they may see your private preferences.")
                    BulletText("Content Policy: Illegal or extreme kinks are strictly excluded for safety and legal compliance.")
                    BulletText("Safety First: Research and practice safety when exploring high-risk activities.")
                    BulletText("Legal Compliance: Users must ensure their activities comply with local laws in their current jurisdiction.")
                    BulletText("Age Restriction: This app is strictly for users aged 18+")

                    Spacer(Modifier.height(16.dp))

                    Text("Privacy & Data: This software is free and publicly available. It does not collect personal data or require special device permissions to function.", color = Color.White.copy(alpha = 0.9f))

                    Spacer(Modifier.height(16.dp))

                    Text("Feedback: I welcome suggestions for updates and new features.", color = Color.White.copy(alpha = 0.9f))
                    Text("Liability: This software is provided for communication purposes only. The developer assumes no liability for any injury, loss, or damage resulting from the use of this app.", color = Color.White.copy(alpha = 0.9f))

                    ListLink()
                    Text("The app idea was revealed to me in a dream.", color = MaterialTheme.colorScheme.tertiary)
                }
            }
        }
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

    var expandedList = remember {mutableStateListOf<Boolean>().apply {
        addAll(List(indexes.size) {false})
    }}

    if (indexes.isEmpty()) {
        // nothing in common
        EmptyResult(onEndWhisper)
    } else {
        // some common items found
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
                    TitleText("Results")

                    Text(
                        text = "You both want to try or have in common:",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White.copy(alpha = 0.9f)
                    )


                    LazyColumn(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(indexes.size) { index ->
                            val data = sourceList[indexes[index]]
                            val title = data.name
                            val description = data.description
                            val isExpanded = expandedList[index]

                            ResultItem(
                                title,
                                description,
                                isExpanded,
                                expandChange = { newValue ->
                                    expandedList[index] = newValue
                                }
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
}
