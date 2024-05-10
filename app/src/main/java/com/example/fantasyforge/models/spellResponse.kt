package com.example.fantasyforge.models


data class SpellResponse(
    val results: List<Spell>
)

data class Spell(
    val index: String,
    val name: String,
    // Include other relevant fields
)