package com.example.fantasyforge.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fantasyforge.data.AppDatabase
import com.example.fantasyforge.models.CharacterSheet
import kotlinx.coroutines.launch

class CharacterCreationViewModels : ViewModel() {

    // Explicitly specify the type of LiveData being emitted - List<Race>
    /*val races = liveData<List<Race>>(Dispatchers.IO) {
        try {
            val response = RetrofitInstance.api.getRaces()
            if (response.isSuccessful) {
                // Directly emit the results or an empty list if null
                emit(response.body()?.results ?: emptyList())
            } else {
                // Log error or handle it as needed
                emit(emptyList<Race>()) // Emit an empty list in case of error
            }
        } catch (e: Exception) {
            // Log exception or handle it
            emit(emptyList<Race>()) // Emit an empty list in case of exception
        }
    }

     */
}

class CharacterCreationViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = AppDatabase.getDatabase(application).characterSheetDao()

    // LiveData to observe all character sheets
    val allCharacterSheets = dao.getAllCharacterSheets()

    // Function to insert a new character sheet into the database
    fun insertCharacterSheet(sheet: CharacterSheet) = viewModelScope.launch {
        dao.insertCharacterSheet(sheet)
    }

    // Function to delete a character sheet from the database
    fun deleteCharacterSheet(sheet: CharacterSheet) = viewModelScope.launch {
        dao.deleteCharacterSheet(sheet)
    }
}