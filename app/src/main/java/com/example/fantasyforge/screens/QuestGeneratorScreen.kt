package com.example.fantasyforge.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fantasyforge.ui.theme.FantasyForgeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestGeneratorScreen() {
    var generatedQuest by remember { mutableStateOf("") }

    // Arrays for different parts of a quest
    val questTypes = arrayOf("Escort", "Retrieve", "Defend", "Assassinate", "Explore")

    fun generateRandomQuest(questType: String) {
        val objectives = arrayOf("an artifact", "a person", "a location", "a creature")
        val locations = arrayOf("the forest", "the mountains", "the ruins", "the city", "the cave")
        val characters = arrayOf("a mysterious stranger", "a noble", "a wizard", "a thief", "a monster")
        val rewards = arrayOf("gold", "a magical item", "fame", "a favor")

        val randomObjective = objectives.random()
        val randomLocation = locations.random()
        val randomCharacter = characters.random()
        val randomReward = rewards.random()

        generatedQuest = when (questType) {
            "Escort" -> "Escort $randomCharacter from $randomLocation to ${locations.filter { it != randomLocation }.random()} for $randomReward"
            "Assassinate" -> "Assassinate $randomCharacter in $randomLocation for $randomReward"
            "Explore" -> "Explore ${locations.random()} for $randomReward"
            else -> "$questType $randomObjective in $randomLocation for $randomReward"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Banner at the top of the screen
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            color = Color(0xFF780000),
        ) {
            Text(
                text = "Fantasy Forge Quest Generator",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            )
        }

        // Layout for quest buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Column for the first three buttons
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                QuestPartSection("Escort") {
                    generateRandomQuest("Escort")
                }
                QuestPartSection("Retrieve") {
                    generateRandomQuest("Retrieve")
                }
                QuestPartSection("Defend") {
                    generateRandomQuest("Defend")
                }
            }

            // Column for the last three buttons
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                QuestPartSection("Assassination") {
                    generateRandomQuest("Assassinate")
                }
                QuestPartSection("Explore") {
                    generateRandomQuest("Explore")
                }
                // Button to generate a random quest
                Button(
                    onClick = { generateRandomQuest(questTypes.random()) }, // Logic to generate a random quest
                    colors = ButtonDefaults.buttonColors(Color(0xFF780000))
                ) {
                    Text(text = "Generate Random Quest", color = Color.White)
                }
            }
        }

        // Display the generated quest
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Divider(color = Color.Black) // Divider above the text

            Text(
                text = generatedQuest,
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp) // Adjust padding as needed
            )

            Divider(color = Color.Black) // Divider below the text
        }
    }
}

@Composable
fun QuestPartSection(
    label: String,
    generateQuest: () -> Unit
) {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { generateQuest() },
            modifier = Modifier
                .padding(vertical = 8.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF780000))
        ) {
            Text(text = "Generate $label Quest", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuestGeneratorScreenPreview() {
    FantasyForgeTheme {
        QuestGeneratorScreen()
    }
}