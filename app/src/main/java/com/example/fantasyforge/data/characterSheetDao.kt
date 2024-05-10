package com.example.fantasyforge.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fantasyforge.models.CharacterSheet

@Dao
interface CharacterSheetDao {
    @Query("SELECT * FROM CharacterSheet")
    fun getAllCharacterSheets(): LiveData<List<CharacterSheet>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacterSheet(sheet: CharacterSheet)

    // Add this method to delete a character sheet
    @Delete
    suspend fun deleteCharacterSheet(sheet: CharacterSheet)
}

