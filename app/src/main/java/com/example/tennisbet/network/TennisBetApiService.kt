package com.example.tennisbet.network
import com.example.tennisbet.data.Match
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class TennisBetApiService {
    companion object {
        val BASE_URL: String = "http://10.0.2.2:3000/"
        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }
    }
}

interface TennisBetApi {
    @GET("/parties")
    suspend fun getMatchs(): List<Match>
}