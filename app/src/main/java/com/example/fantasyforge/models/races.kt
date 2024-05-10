package com.example.fantasyforge.models

import androidx.room.Entity
import androidx.room.PrimaryKey

data class RaceList(val results: List<Race>)
data class Race(val index: String, val name: String, val url: String)

@Entity
data class CharacterSheets(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val race: String,
    val characterClass: String
)