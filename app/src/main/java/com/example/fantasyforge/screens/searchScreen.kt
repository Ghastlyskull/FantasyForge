package com.example.fantasyforge.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.fantasyforge.models.SpellDetail
import com.example.fantasyforge.viewmodel.SearchViewModel

@Composable
fun SearchScreen(viewModel: SearchViewModel = viewModel(), navController: NavHostController) {
    var searchText by remember { mutableStateOf("") }

    // Use Column with horizontalAlignment set to CenterHorizontally
    Column(
        modifier = Modifier
            .fillMaxSize() // Ensure the Column takes up the max size
            .padding(16.dp), // Apply padding around the Column
        horizontalAlignment = Alignment.CenterHorizontally, // Center children horizontally
        verticalArrangement = Arrangement.Center // Optional: Center children vertically
    ) {
        Text(
            text = "Search for a Spell",
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            label = { Text("Enter spell name") },
            singleLine = true, // Makes the text field single line
            modifier = Modifier.padding(vertical = 8.dp) // Apply vertical padding
        )
        Button(
            onClick = { viewModel.fetchSpellByName(searchText) },
            modifier = Modifier.padding(top = 8.dp) // Apply top padding to separate button from input
        ) {
            Text("Search")
        }

        // Display the spell detail or search results
        val spellDetail = viewModel.spellDetail.observeAsState().value
        spellDetail?.let { spell ->
            SpellDetailContent(spell)
        }
    }
}

@Composable
fun SpellDetailContent(spell: SpellDetail) {
    Column {
        Text("Name: ${spell.name}", fontWeight = FontWeight.Bold)
        spell.desc.forEach { desc ->
            Text("Description: $desc")
        }
        // Display other spell details as desired
    }
}