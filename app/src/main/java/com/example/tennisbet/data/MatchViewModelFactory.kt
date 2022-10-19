package com.example.tennisbet.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MatchViewModelFactory (private val matchRepository: MatchRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MatchViewModel::class.java)) {
            return MatchViewModel(matchRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}