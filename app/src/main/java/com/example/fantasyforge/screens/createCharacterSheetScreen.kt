package com.example.fantasyforge.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.fantasyforge.models.CharacterSheet
import com.example.fantasyforge.viewmodel.CharacterCreationViewModel

@Composable
fun CreateCharacterSheetScreen(navController: NavHostController, viewModel: CharacterCreationViewModel = viewModel()) {
    var name by remember { mutableStateOf("") }
    var race by remember { mutableStateOf("") }
    var characterClass by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Create New Character Sheet", style = MaterialTheme.typography.bodySmall)
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = race,
            onValueChange = { race = it },
            label = { Text("Race") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = characterClass,
            onValueChange = { characterClass = it },
            label = { Text("Class") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                viewModel.insertCharacterSheet(CharacterSheet(name = name, race = race, characterClass = characterClass))
                navController.popBackStack()
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Create")
        }
    }
}
