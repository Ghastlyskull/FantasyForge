package com.example.fantasyforge.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlin.random.Random

@Composable
fun DiceRollerScreen(navController: NavHostController) {
    var diceType by remember { mutableStateOf("") }
    var diceCount by remember { mutableStateOf("") }
    var totalValue by remember { mutableIntStateOf(0) }
    var diceResults by remember { mutableStateOf<List<Int>>(emptyList()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = diceType,
            onValueChange = { diceType = it },
            label = { Text("Dice Type (e.g., 6 for a D6)") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = diceCount,
            onValueChange = { diceCount = it },
            label = { Text("Number of Dice") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Parse the inputs and roll the dice
                val type = diceType.toIntOrNull()
                val count = diceCount.toIntOrNull()
                if (type != null && count != null && type > 0 && count > 0) {
                    rollDice(type, count) { rolls, total ->
                        diceResults = rolls
                        totalValue = total
                    }
                }
            }
        ) {
            Text("Roll Dice")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(diceResults) { result ->
                Text("Dice Roll: $result")
            }

            if (diceResults.isNotEmpty()) {
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Total Value: $totalValue")
                }
            }
        }
    }
}

private fun rollDice(diceType: Int, diceCount: Int, onResult: (List<Int>, Int) -> Unit) {
    val rolls = List(diceCount) { Random.nextInt(1, diceType + 1) }
    val total = rolls.sum()
    onResult(rolls, total)
}