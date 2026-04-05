package com.app.fantasywhisper.ui.screens

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.app.fantasywhisper.AppDestinations
import com.app.fantasywhisper.AppLang
import com.app.fantasywhisper.ui.EnglishStrings
import com.app.fantasywhisper.ui.components.AppMenuButton
import com.app.fantasywhisper.ui.components.MenuLangButton
import com.app.fantasywhisper.ui.components.BulletText
import com.app.fantasywhisper.ui.components.EmptyResult
import com.app.fantasywhisper.ui.components.ListLink
import com.app.fantasywhisper.ui.components.GitLink
import com.app.fantasywhisper.ui.components.LobsterFont
import com.app.fantasywhisper.ui.components.NumText
import com.app.fantasywhisper.ui.components.ResultItem
import com.app.fantasywhisper.ui.components.TitleText
import com.app.fantasywhisper.ui.components.saveData
import com.app.fantasywhisper.ui.data.cosplayItems
import com.app.fantasywhisper.ui.data.kinkItems
import com.app.fantasywhisper.ui.data.placesItems
import com.app.fantasywhisper.ui.data.roleplayItems
import com.app.fantasywhisper.ui.theme.White


@Composable
fun ContentScreen(
    destinations: AppDestinations,
    changeLang: () -> Unit,
    onStartWhisper: () -> Unit
) {
    when (destinations) {
        AppDestinations.HOME -> Scaffold(
            modifier = Modifier
                .fillMaxSize()
        ) { innerPadding ->
            MenuTextBox(modifier = Modifier.padding(innerPadding), changeLang, onStartWhisper)
        }
        AppDestinations.DISCLAIMER -> Scaffold(
            modifier = Modifier
                .fillMaxSize()
        ) { innerPadding ->
            DisclaimerBox(modifier = Modifier.padding(innerPadding))
        }

        else -> {}
    }
}

@Composable
fun MenuTextBox(modifier: Modifier, changeLang: () -> Unit, onStartWhisper: () -> Unit) {
    val lang = AppLang.current
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
                    TitleText(lang.menuTitle)

                    Spacer(Modifier.height(16.dp))

                    Text(
                        text = lang.menuText,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White.copy(alpha = 0.9f)
                    )

                    Spacer(Modifier.height(16.dp))
                    NumText(1, lang.menuPointOne)
                    NumText(2, lang.menuPointTwo)
                    NumText(3, lang.menuPointThree)
                    NumText(4, lang.menuPointFour)

                    Spacer(Modifier.height(128.dp))

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AppMenuButton(
                            onClick = onStartWhisper
                        )
                    }

                    Spacer(Modifier.height(8.dp))

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        MenuLangButton(
                            changeLang = changeLang
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun DisclaimerBox(modifier: Modifier) {
    val lang = AppLang.current
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
                    TitleText(lang.menuDis)

                    Spacer(Modifier.height(16.dp))

                    BulletText(lang.disBull1)
                    BulletText(lang.disBull2)
                    BulletText(lang.disBull3)
                    BulletText(lang.disBull4)
                    BulletText(lang.disBull5)
                    BulletText(lang.disBull6)

                    Spacer(Modifier.height(16.dp))

                    Text(lang.disPriv, color = Color.White.copy(alpha = 0.9f))
                    GitLink()
                    Spacer(Modifier.height(16.dp))

                    Text(lang.disFeed, color = Color.White.copy(alpha = 0.9f))
                    Text(lang.disLiability, color = Color.White.copy(alpha = 0.9f))

                    ListLink()
                    Text("The app idea was revealed to me in a dream.", color = MaterialTheme.colorScheme.tertiary)
                }
            }
        }
    }
}

@Composable
fun ResultScreen(listType: WList, number: MutableState<BooleanArray>, onEndWhisper: () -> Unit) {
    val lang = AppLang.current

    val sourceList = when (listType) {
        WList.ROLEPLAY -> lang.roleplayData
        WList.COSPLAY -> lang.cosplayData
        WList.PLACES -> lang.placesData
        WList.KINKS -> lang.kinkData
    }
    val categoryString = when (listType) {
        WList.ROLEPLAY -> lang.expRoleplays
        WList.COSPLAY -> lang.expCosplays
        WList.PLACES -> lang.expPlaces
        WList.KINKS -> lang.expKinks
    }
    val langBool = if (AppLang.current == EnglishStrings) true else false

    val result = number.value
    var indexes = remember {mutableStateListOf<Int>()}

    for (i in result.indices) {
        if (result[i]) {
            indexes.add(i)
        }
    }

    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.CreateDocument("text/markdown")
    ) { uri ->
        uri?.let { safeUri ->
            saveData(context, safeUri, listType, indexes, categoryString, lang.obsidianInfo, lang.okSave, lang.badSave, langBool)
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
                    TitleText(lang.resTitle)

                    Button(
                        onClick = { launcher.launch(lang.resFileName) },
                        modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            MaterialTheme.colorScheme.surface,
                            White
                        )
                    ) {
                        Text(lang.resExportButton, style = MaterialTheme.typography.bodyMedium.copy(
                            fontFamily = LobsterFont,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        ))
                    }
                    Text(
                        text = lang.resText,
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
                        Text(lang.resEnd, style = MaterialTheme.typography.bodyMedium.copy(
                            fontFamily = LobsterFont,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        ))
                    }
                }
            }
        }
    }
}

@Composable
fun WarningScreen(listType: WList, resultList: MutableState<BooleanArray>, warning: Warning, onEndWhisper: () -> Unit) {
    val lang = AppLang.current

    val warningText = when (warning) {
        Warning.Percent90 -> lang.warnPercent90
        Warning.Percent99 -> lang.warnPercent99
        Warning.ALL -> lang.warnALL
        Warning.OKAY -> lang.warnOKAY
    }

    var showResult by remember { mutableStateOf(false) }

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
                TitleText(lang.warnTitle)
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
                            text = lang.warnText(warningText),
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.White.copy(alpha = 0.9f)
                        )
                    }

                }

                if (showResult) {
                    ResultScreen(listType,resultList, onEndWhisper)
                }

                Button(
                    onClick = { showResult = true },
                    modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        MaterialTheme.colorScheme.surface,
                        White
                    )
                ) {
                    Text(lang.warnContinue, style = MaterialTheme.typography.bodyMedium.copy(
                        fontFamily = LobsterFont,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    ))
                }

                Button(
                    onClick = onEndWhisper,
                    modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        MaterialTheme.colorScheme.surface,
                        White
                    )
                ) {
                    Text(lang.resEnd, style = MaterialTheme.typography.bodyMedium.copy(
                        fontFamily = LobsterFont,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    ))
                }
            }
        }
    }
}
