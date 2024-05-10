package com.example.fantasyforge.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.fantasyforge.models.CharacterSheet
import com.example.fantasyforge.viewmodel.CharacterCreationViewModel

// Mock data class for demonstration
data class CharacterSheet(
    val id: Int,
    val name: String,
    val race: String,
    val characterClass: String
)

// Example list of character sheets
val exampleCharacterSheets = listOf(
    CharacterSheet(1, "Eldrin", "Elf", "Ranger"),
    CharacterSheet(2, "Thorn", "Human", "Wizard"),
    CharacterSheet(3, "Gimble", "Gnome", "Rogue")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterSheetsScreen(navController: NavHostController, viewModel: CharacterCreationViewModel = viewModel()) {
    val sheets = viewModel.allCharacterSheets.observeAsState(initial = emptyList())

    Scaffold(
        topBar = { TopAppBar(title = { Text("Character Sheets") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("createCharacterSheetScreen")
            }) {
                Icon(Icons.Filled.Add, contentDescription = "Create Character")
            }
        }
    ) { padding ->
        CharacterSheetsList(
            characterSheets = sheets.value,
            onDelete = { sheet ->
                viewModel.deleteCharacterSheet(sheet)
            },
            modifier = Modifier.padding(padding)
        )
    }
}

@Composable
fun CharacterSheetsList(characterSheets: List<com.example.fantasyforge.models.CharacterSheet>, onDelete: (CharacterSheet) -> Unit, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(characterSheets) { sheet ->
            CharacterSheetItem(sheet = sheet, onDelete = { onDelete(sheet) })
        }
    }
}

@Composable
fun CharacterSheetItem(sheet: CharacterSheet, onDelete: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = sheet.name, style = MaterialTheme.typography.bodyMedium)
            Text(text = "Race: ${sheet.race}", style = MaterialTheme.typography.bodySmall)
            Text(text = "Class: ${sheet.characterClass}", style = MaterialTheme.typography.bodySmall)
        }
        IconButton(onClick = onDelete) {
            Icon(Icons.Filled.Delete, contentDescription = "Delete Character")
        }
    }
}