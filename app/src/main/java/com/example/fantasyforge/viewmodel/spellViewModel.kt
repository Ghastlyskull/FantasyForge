package com.example.fantasyforge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fantasyforge.data.RetrofitInstance
import com.example.fantasyforge.models.SpellDetail
import kotlinx.coroutines.launch
import java.util.Locale

class SpellViewModel(private val spellIndex: String) : ViewModel() {

    private val _spellDetail = MutableLiveData<SpellDetail>()
    val spellDetail: LiveData<SpellDetail> = _spellDetail

    fun fetchSpellByName(spellName: String) {
        viewModelScope.launch {
            // Simulate fetching a spell by name. Adjust according to your API's capabilities.
            // This is a placeholder implementation.
            val response = RetrofitInstance.api.getSpellDetail(
                spellName.lowercase(Locale.ROOT).replace(" ", "-"))
            if (response.isSuccessful) {
                _spellDetail.postValue(response.body())
            } else {
                // Handle errors
            }
        }
    }
}