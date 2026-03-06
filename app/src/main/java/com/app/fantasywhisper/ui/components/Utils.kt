package com.app.fantasywhisper.ui.components

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.app.fantasywhisper.ui.data.cosplayItems
import com.app.fantasywhisper.ui.data.kinkItems
import com.app.fantasywhisper.ui.data.placesItems
import com.app.fantasywhisper.ui.data.roleplayItems
import com.app.fantasywhisper.ui.screens.WList
import com.app.fantasywhisper.ui.theme.Crow
import com.app.fantasywhisper.ui.theme.White
import com.app.fantasywhisper.ui.theme.Rose
import kotlin.math.roundToInt


@Composable
fun BulletText(text: String) {
    Row(Modifier.padding(vertical = 6.dp)) {
        Text("• ", color = Color.White)
        Text(
            text,
            color = Color.White.copy(alpha = 0.9f)
        )
    }
}

@Composable
fun NumText(number: Int, text: String) {
    Row(modifier = Modifier.padding(vertical = 6.dp)) {
        Text("$number. ", color = Color.White)
        Text(
            text,
            color = Color.White.copy(alpha = 0.9f)
        )
    }
}

@Composable
fun ListItem (
    text: String,
    description: String,
    isChecked: Boolean,
    isExpanded: Boolean,
    checkChange: (Boolean) -> Unit,
    expandChange: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Crow)
            .animateContentSize()
            .shadow(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clickable { expandChange(!isExpanded) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = checkChange
            )
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium,
                color = White,
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = "Expand",
                tint = Color.White,
                modifier = Modifier.padding(12.dp)
            )
        }
        if (isExpanded) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = description,
                    color = Color.White
                )

            }
        }
    }
}

@Composable
fun ResultItem (
    text: String,
    description: String,
    isExpanded: Boolean,
    expandChange: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Crow)
            .animateContentSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clickable { expandChange(!isExpanded) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "     $text",
                style = MaterialTheme.typography.bodyMedium,
                color = White,
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = "Expand",
                tint = Color.White,
                modifier = Modifier.padding(12.dp)
            )
        }
        if (isExpanded) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = description,
                    color = Color.White
                )

            }
        }
    }
}

@Composable
fun PeopleSlider(amount: Int, onValueChange: (Int) -> Unit) {
        Slider (
            value = amount.coerceIn(2,50).toFloat(),
            onValueChange = { onValueChange(it.roundToInt()) },
            valueRange = 2f..50f,
            steps = 47,
            colors = SliderDefaults.colors(
                thumbColor = Rose,
                activeTrackColor = Rose,
                inactiveTrackColor = Crow
            )
        )
}

fun saveData(context: Context, uri: Uri, listType: WList, data: List<Int>) {
    val sourceList = when (listType) {
        WList.ROLEPLAY -> roleplayItems
        WList.COSPLAY -> cosplayItems
        WList.PLACES -> placesItems
        WList.KINKS -> kinkItems
    }

    val categoryString = when (listType) {
        WList.ROLEPLAY -> "# You both want to try those roleplays:  "
        WList.COSPLAY -> "# You both fantasize about those cosplays:  "
        WList.PLACES -> "# You both want to try something on those places:  "
        WList.KINKS -> "# You both have those fantasies in common:  "
    }

    try {
        context.contentResolver.openOutputStream(uri)?.use { outputStream ->
            outputStream.bufferedWriter().use { writer ->
                writer.write(categoryString)
                writer.newLine()
                writer.write("---")
                writer.newLine()
                data.forEach { item ->
                    val data = sourceList[item]
                    val title = data.name
                    val description = data.description
                    writer.write("- **$title**: *$description*")
                    writer.newLine()
                    writer.write("---")
                    writer.newLine()
                }
                writer.write("---")
                writer.newLine()
            }
        }
        Toast.makeText(context, "Saved successfully!", Toast.LENGTH_SHORT).show()
    } catch (e: Exception) {
        Toast.makeText(context, "Failed to save", Toast.LENGTH_SHORT).show()
    }
}