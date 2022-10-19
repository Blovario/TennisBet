package com.example.tennisbet.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import retrofit2.Response


class MatchViewModel (private val matchRepository: MatchRepository): ViewModel() {
    val matchLiveData : LiveData<List<Match>>

    init {
        Log.d("MatchViewModel", "MatchViewModel")
        matchLiveData = getMatchs()
    }

    private fun getMatchs() = liveData {
        try {
            val listResult = matchRepository.getMatchs()
            emit(listResult)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}