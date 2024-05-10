package com.example.fantasyforge.models


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharacterSheet(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val race: String,
    val characterClass: String
)