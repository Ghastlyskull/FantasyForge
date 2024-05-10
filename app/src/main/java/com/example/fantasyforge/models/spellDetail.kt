package com.example.fantasyforge.models

data class SpellDetail(
    val index: String,
    val name: String,
    val desc: List<String>,
    val higher_level: List<String>?,
    val range: String,
    val components: List<String>,
    val material: String?,
    val ritual: Boolean,
    val duration: String,
    val concentration: Boolean,
    val casting_time: String,
    val level: Int,
    val attack_type: String?,
    val damage: Damage?,
    val school: School,
    val classes: List<SpellClass>,
    val subclasses: List<SpellSubclass>,
    val url: String
)

data class Damage(
    val damage_type: DamageType,
    val damage_at_slot_level: Map<String, String>
)

data class DamageType(
    val name: String,
    val url: String
)

data class School(
    val name: String,
    val url: String
)

data class SpellClass(
    val name: String,
    val url: String
)

data class SpellSubclass(
    val name: String,
    val url: String
)