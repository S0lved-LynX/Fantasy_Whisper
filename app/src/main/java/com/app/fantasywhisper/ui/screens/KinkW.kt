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
import androidx.compose.ui.unit.dp
import com.app.fantasywhisper.ui.theme.White
import com.app.fantasywhisper.ui.data.cosplayItems
import com.app.fantasywhisper.ui.data.kinkItems
import com.app.fantasywhisper.ui.data.placesItems
import com.app.fantasywhisper.ui.data.roleplayItems
import com.app.fantasywhisper.ui.components.ListItem

@Composable
fun KinkListCaller(listType: WList, onEnd: () -> Unit) {
    var state by remember { mutableIntStateOf(0) }

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
        when (state) {
            0 -> KinkListScreen(listType,"Proceed to next member",resultList) {state++}
            1 -> KinkListScreen(listType,"See results",resultList) {state++}
            else -> ResultScreen(listType,resultList, onEnd)
        }
    }
}

@Composable
fun KinkListScreen(source: WList, label: String, result: MutableState<BooleanArray>, onNext: () -> Unit) {

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
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.headlineLarge,
                color = White,
                text = "Select boxes"
            )
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

                    for (i in sourceList.indices) {
                        update[i] = result.value[i] && checkedList[i]
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
                Text(label)
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

