package com.example.tennisbet.data

import com.example.tennisbet.network.TennisBetApi
import retrofit2.Response

class MatchRepository(private val tennisBetApi: TennisBetApi) {
    suspend fun getMatchs(): List<Match> {
        return tennisBetApi.getMatchs()
    }
}
