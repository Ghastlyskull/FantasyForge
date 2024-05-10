package com.example.fantasyforge.network

import com.example.fantasyforge.models.Spell
import com.example.fantasyforge.models.SpellDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DnD5eApiService {
    // Example endpoint for searching spells, adjust according to your actual API
    @GET("spells/search")
    suspend fun searchSpells(@Query("query") query: String): Response<SpellSearchResponse>

    // Define other methods like getSpellDetail
    @GET("spells/{spellName}")
    suspend fun getSpellDetail(@retrofit2.http.Path("spellName") spellName: String): Response<SpellDetail>
}

data class SpellSearchResponse(
    val results: List<Spell>
)