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
fun NameGeneratorScreen() {
    var generatedName by remember { mutableStateOf("") }
    var isMaleSelected by remember { mutableStateOf(false) }
    var isFemaleSelected by remember { mutableStateOf(false) }
    var lockFirst by remember { mutableStateOf(false) }
    var lockLast by remember { mutableStateOf(false) }

    // The logic for generating random names
    val maleFirstNames = arrayOf("John", "Michael", "David", "Daniel", "William", "James", "Alexander", "Benjamin", "Matthew", "Elijah", "Joseph", "Samuel", "Ryan", "Luke", "Henry")
    val femaleFirstNames = arrayOf("Jane", "Emily", "Sophia", "Olivia", "Emma", "Isabella", "Mia", "Charlotte", "Amelia", "Evelyn", "Abigail", "Harper", "Elizabeth", "Avery", "Grace")
    val lastNames = arrayOf("Smith", "Johnson", "Williams", "Jones", "Brown", "Miller", "Davis", "García", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson", "Garcia", "Martinez", "Robinson", "Clark", "Rodriguez", "Lewis", "Lee", "Walker", "Hall", "Allen", "Young", "Hernandez", "King")

    fun generateRandomName() {
        val randomFirstName = if (lockFirst) generatedName.substringBefore(" ") else when {
            !isMaleSelected && !isFemaleSelected || isMaleSelected && isFemaleSelected -> {
                if (Random.nextBoolean()) maleFirstNames.random() else femaleFirstNames.random()
            }
            isMaleSelected -> maleFirstNames.random()
            else -> femaleFirstNames.random()
        }
        val randomLastName = if (lockLast) generatedName.substringAfter(" ") else lastNames.random()
        generatedName = "$randomFirstName $randomLastName"
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
                text = "Fantasy Forge Name Generator",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            )
        }

        // Male and Female toggle buttons
        Row(
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Checkbox(
                checked = isMaleSelected,
                onCheckedChange = { isMaleSelected = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFF780000),
                    uncheckedColor = MaterialTheme.colorScheme.onBackground
                ),
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Text(text = "Male")

            Checkbox(
                checked = isFemaleSelected,
                onCheckedChange = { isFemaleSelected = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFF780000),
                    uncheckedColor = MaterialTheme.colorScheme.onBackground
                ),
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Text(text = "Female")
        }

        // Lock buttons for first and last names
        Row(
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Checkbox(
                checked = lockFirst,
                onCheckedChange = { lockFirst = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFF780000),
                    uncheckedColor = MaterialTheme.colorScheme.onBackground
                ),
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Text(text = "Lock First Name")

            Checkbox(
                checked = lockLast,
                onCheckedChange = { lockLast = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFF780000),
                    uncheckedColor = MaterialTheme.colorScheme.onBackground
                ),
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Text(text = "Lock Last Name")
        }

        // Button to generate a random name
        Button(
            onClick = { generateRandomName() },
            modifier = Modifier.padding(16.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF780000))
        ) {
            Text(text = "Generate Random Name", color = Color.White)
        }

        // Display the generated name
        Text(
            text = generatedName,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(16.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun NameGeneratorScreenPreview() {
    FantasyForgeTheme {
        NameGeneratorScreen()
    }
}