package com.example.fantasyforge.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fantasyforge.ui.theme.FantasyForgeTheme
import kotlin.random.Random

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TownGeneratorScreen() {
    var generatedTown by remember { mutableStateOf("") }
    var lockFirstPart by remember { mutableStateOf(false) }
    var lockLastPart by remember { mutableStateOf(false) }

    // Arrays for beginning and ending words of town names
    val beginningWords = arrayOf(
        "River", "Oak", "Maple", "Pine", "Green", "Spring", "Brook", "Cedar", "Meadow", "Wood",
        "Fair", "Hill", "High", "Briar", "Willow", "Mountain", "Lake", "Stone", "Bright", "Shadow",
        "Golden", "Silver", "Whisper", "Ember", "Frost", "Sun", "Moon", "Star", "Wild", "Clear",
        "Red", "Blue", "White", "Black", "Gray", "Crimson", "Misty", "Frozen", "Sunset",
        "Dawn", "Twilight", "Thunder", "Storm", "Mist", "Moss", "Sky", "Rain", "Wind", "Hammer"
    )
    val endingWords = arrayOf(
        "side", "wood", "ville", "crest", "wich", "field", "view", "hurst", "dale", "mont", "ford",
        "bury", "borough", "ton", "shire", "stead", "burg", "hill", "well", "wick", "ham", "chester",
        "market", "mere"
    )

    fun generateRandomTownName() {
        val randomBeginning = beginningWords.random()
        val randomEnding = endingWords.random()
        generatedTown = when {
            lockFirstPart && lockLastPart -> generatedTown // Do nothing if both parts are locked
            lockFirstPart -> "${generatedTown.substringBefore(" ")} $randomEnding"
            lockLastPart -> "$randomBeginning ${generatedTown.substringAfter(" ")}"
            else -> "$randomBeginning $randomEnding"
        }
    }

    // UI layout
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Banner at the top of the screen
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            color = Color(0xFF780000),
        ) {
            Text(
                text = "Fantasy Forge Town Generator",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            )
        }

        // Lock buttons for town name parts
        Row(
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Checkbox(
                checked = lockFirstPart,
                onCheckedChange = { lockFirstPart = it; if (it) lockLastPart = false },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFF780000),
                    uncheckedColor = MaterialTheme.colorScheme.onBackground
                ),
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Text(text = "Lock First Part")

            Checkbox(
                checked = lockLastPart,
                onCheckedChange = { lockLastPart = it; if (it) lockFirstPart = false },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFF780000),
                    uncheckedColor = MaterialTheme.colorScheme.onBackground
                ),
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Text(text = "Lock Last Part")
        }

        // Button to generate a random town name
        Button(
            onClick = { generateRandomTownName() },
            modifier = Modifier.padding(16.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF780000))
        ) {
            Text(text = "Generate Random Town Name", color = Color.White)
        }

        // Display the generated town name
        Text(
            text = generatedTown,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TownGeneratorScreenPreview() {
    FantasyForgeTheme {
        TownGeneratorScreen()
    }
}