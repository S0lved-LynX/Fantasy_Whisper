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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.ClickableText
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
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
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import com.app.fantasywhisper.AppDestinations
import com.app.fantasywhisper.ui.components.AppMenuButton
import com.app.fantasywhisper.ui.components.BulletText
import com.app.fantasywhisper.ui.components.EmptyResult
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
                        text = "Do you want to try something different with your partner and you don't know how to tell them about your desires? Are you a shy person? I built a tool for you!",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White.copy(alpha = 0.9f)
                    )

                    Spacer(Modifier.height(16.dp))
                    NumText(1, "Choose category you want to \"Whisper\"")
                    NumText(2, "Choose your desires privately and then let your partner do the same.")
                    NumText(3, "See ONLY desires that you have in common. (The desires that you both checked)")
                    NumText(4, "And the last thing is communicating what to do with the result. Now it might be a bit easier, don't you think so?")

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

                    Text(
                        text = "First of all this is my first app so please be patient with me - there might be bugs."
                        + "\n" + "Second thing is that this is a very delicate topic and I created the app with few things in mind:\n",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White.copy(alpha = 0.9f)
                    )
                    Spacer(Modifier.height(16.dp))
                    BulletText("Don't force anybody into using this app or having sex, if they don't want to share or have sex then you should be okay with it - plus they'll probably leave you if you are too harsh. (Just remainder)")
                    BulletText("Be aware that this app can be used against you - if the parnter checks everything then he/she knows your desires. That means you need to trust your partner")
                    BulletText("I didn't include all kinks - I removed the illegal ones.")
                    BulletText("Here are some really DANGEROUS or DISGUSTING kinks - be aware of that and don't hurt yourself or your partner")
                    BulletText("Please don't break any law - in some countries public sex is illegal.")
                    BulletText("This app is 18+. Kids please turn this app off and go play Minecraft. (It's awesome game)")

                    Spacer(Modifier.height(16.dp))

                    Text("This software is free and publicly available - it is not paid, it doesn't collect any personal data, it doesn't need any special permissions.",color = Color.White.copy(alpha = 0.9f))
                    val annotatedString = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.White, fontSize = 18.sp)) {
                            append("The kinks list was taken from this ")
                        }
                        // Start of the clickable part
                        pushStringAnnotation(tag = "URL", annotation = "https://badgirlsbible.com/list-of-kinks-and-fetishes")
                        withStyle(style = SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline)) {
                            withStyle(style = SpanStyle(color = Color.Blue, fontSize = 18.sp, textDecoration = TextDecoration.Underline)) {
                                append("website")
                            }
                        }
                        pop()
                    }

                    val uriHandler = androidx.compose.ui.platform.LocalUriHandler.current
                    ClickableText(
                        text = annotatedString,
                        onClick = { offset ->
                            annotatedString.getStringAnnotations(tag = "URL", start = offset, end = offset)
                                .firstOrNull()?.let { annotation ->
                                    // Use a URI handler to open the link
                                    uriHandler.openUri(annotation.item)
                                }
                        }
                    )

                    Spacer(Modifier.height(16.dp))
                    Text("Feel free to suggest updates and new features to me.",color = Color.White.copy(alpha = 0.9f))
                    Text("I'm not liable for any damage, hurt or death - this software is used only for communication, if you hurt yourself or others then it's your fault, you were warned and should've been careful.",color = Color.White.copy(alpha = 0.9f))

                    Text("The app idea was revealed to me in my dream.", color = MaterialTheme.colorScheme.tertiary)
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
