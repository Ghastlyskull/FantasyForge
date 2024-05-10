package com.example.fantasyforge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.fantasyforge.models.Spell
import com.example.fantasyforge.models.SpellDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Locale

class SearchViewModel : ViewModel() {
    private val _spellDetail = MutableLiveData<SpellDetail>()
    val spellDetail: LiveData<SpellDetail> = _spellDetail

    // Assuming Spell model is correctly defined for search results
    fun searchSpells(query: String) = liveData(Dispatchers.IO) {
        val response = com.example.fantasyforge.network.RetrofitInstance.api.searchSpells(query)
        if (response.isSuccessful) {
            emit(response.body()?.results ?: emptyList<Spell>())
        } else {
            emit(emptyList<Spell>()) // Handle errors appropriately
        }
    }

    fun fetchSpellByName(spellName: String) {
        viewModelScope.launch {
            val response = com.example.fantasyforge.data.RetrofitInstance.api.getSpellDetail(
                spellName.lowercase(Locale.ROOT).replace(" ", "-")
            )
            if (response.isSuccessful) {
                _spellDetail.postValue(response.body())
            } else {
                // Handle errors
            }
        }
    }
}