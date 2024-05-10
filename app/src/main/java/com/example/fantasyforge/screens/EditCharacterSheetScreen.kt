package com.example.fantasyforge.screens


/*
@Composable
fun EditCharacterSheetScreen(sheetId: Int, viewModel: CharacterCreationViewModel, navController: NavHostController) {
    // Fetch the character sheet by ID
    val sheet = viewModel.getCharacterSheetById(sheetId).observeAsState().value

    // You can use a simple form or layout to display and edit the character sheet details
    if (sheet != null) {
        CharacterSheetForm(sheet = sheet, onSave = { updatedSheet ->
            viewModel.updateCharacterSheet(updatedSheet)
            navController.popBackStack()  // Go back after saving
        })
    } else {
        Text("Loading...")
    }
}

@Composable
fun CharacterSheetForm(sheet: CharacterSheet, onSave: (CharacterSheet) -> Unit) {
    var name by remember { mutableStateOf(sheet.name) }
    var race by remember { mutableStateOf(sheet.race) }
    var classType by remember { mutableStateOf(sheet.characterClass) }

    Column {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )
        TextField(
            value = race,
            onValueChange = { race = it },
            label = { Text("Race") }
        )
        TextField(
            value = classType,
            onValueChange = { classType = it },
            label = { Text("Class") }
        )
        Button(onClick = { onSave(CharacterSheet(sheet.id, name, race, classType)) }) {
            Text("Save")
        }
    }
}

 */