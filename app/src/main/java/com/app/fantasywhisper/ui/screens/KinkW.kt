package com.app.fantasywhisper.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.fantasywhisper.ui.theme.White
import com.app.fantasywhisper.ui.data.cosplayItems
import com.app.fantasywhisper.ui.data.kinkItems
import com.app.fantasywhisper.ui.data.placesItems
import com.app.fantasywhisper.ui.data.roleplayItems
import com.app.fantasywhisper.ui.components.ListItem
import com.app.fantasywhisper.ui.components.LobsterFont
import com.app.fantasywhisper.ui.components.TitleText

@Composable
fun KinkListCaller(listType: WList, amountOfPeople: Int, onEnd: () -> Unit) {
    var state by remember { mutableIntStateOf(0) }
    var filledWarning = remember { mutableStateOf(Warning.OKAY) }

    val sourceList = when (listType) {
        WList.ROLEPLAY -> roleplayItems
        WList.COSPLAY -> cosplayItems
        WList.PLACES -> placesItems
        WList.KINKS -> kinkItems
    }

    var resultList = remember { mutableStateOf(BooleanArray(sourceList.size) {true})}

    BackHandler(enabled = true) { }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.primary,
            )
    ) {
        if (state < amountOfPeople) {
            val buttonText = if (state == amountOfPeople - 1) "See results" else "Proceed to next member"

            key(state) {
                KinkListScreen(listType, filledWarning, buttonText, resultList) { state++ }
            }
        } else {
            if (filledWarning.value != Warning.OKAY) {
                WarningScreen(listType, resultList, filledWarning.value, onEnd)
            } else {
                ResultScreen(listType, resultList, onEnd)
            }
        }
    }
}

@Composable
fun KinkListScreen(source: WList, warning: MutableState<Warning>, label: String, result: MutableState<BooleanArray>, onNext: () -> Unit) {

    val sourceList = when (source) {
        WList.ROLEPLAY -> roleplayItems
        WList.COSPLAY -> cosplayItems
        WList.PLACES -> placesItems
        WList.KINKS -> kinkItems
    }

    var checkedList = remember {mutableStateListOf<Boolean>().apply {
        addAll(List(sourceList.size) {false})
    }}

    var expandedList = remember {mutableStateListOf<Boolean>().apply {
        addAll(List(sourceList.size) {false})
    }}

    Scaffold (
        contentColor = MaterialTheme.colorScheme.tertiary
    ){ padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .background(MaterialTheme.colorScheme.tertiary),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            TitleText("Select boxes")
            // List
            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items (sourceList.size) { index ->
                    val data = sourceList[index]
                    val title = data.name
                    val description = data.description
                    val checked = checkedList[index]
                    val expanded = expandedList[index]

                    ListItem(
                        title,
                        description,
                        checked,
                        expanded,
                        checkChange = { newValue ->
                            checkedList[index] = newValue
                        },
                        expandChange = { newValue ->
                            expandedList[index] = newValue
                        }
                    )
                }
            }

            Button(
                onClick = {
                    val update = result.value.copyOf()
                    var checkedAmount = 0

                    for (i in sourceList.indices) {
                        update[i] = result.value[i] && checkedList[i]
                    }

                    for (i in sourceList.indices) {
                        if (checkedList[i]) {
                            checkedAmount ++
                        }
                       checkedList[i] = false
                    }

                    val percentage = (checkedAmount.toFloat() / checkedList.size.toFloat()) * 100
                    if (percentage >= 100) {
                        warning.value = Warning.ALL
                    } else if (percentage >= 99) {
                        warning.value = Warning.Percent99
                    } else if (percentage >= 90) {
                        warning.value = Warning.Percent90
                    }

                    result.value = update
                    onNext()
                          },
                modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth(),
                colors = ButtonDefaults.buttonColors (
                    MaterialTheme.colorScheme.surface,
                    White
                )
            ) {
                Text(label, style = MaterialTheme.typography.bodyMedium.copy(
                    fontFamily = LobsterFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                ))
            }
        }
    }
}

enum class WList() {
    KINKS,
    ROLEPLAY,
    COSPLAY,
    PLACES
}

enum class Warning() {
    OKAY,
    Percent90,
    Percent99,
    ALL
}

