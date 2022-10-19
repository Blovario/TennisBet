package com.example.tennisbet

import android.app.appsearch.GlobalSearchSession
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tennisbet.data.*
import com.example.tennisbet.matchList.MatchsAdapter
import com.example.tennisbet.network.TennisBetApi
import com.example.tennisbet.network.TennisBetApiService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.create

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("MainActivity", "onCreates")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val m1=  Match("Andy Murray", "Andy Roddick",0,listOf(3,3), Pointage(listOf(1,2),listOf(listOf(6,2),listOf(4,6),listOf(2,6)),listOf(0,0),true), 0)
        val m2=  Match("lub besson", "ca caa",1,listOf(2,3), Pointage(listOf(1,1),listOf(listOf(6,1),listOf(4,1),listOf(2,1)),listOf(1,0),false), 0)
        val m3=  Match("lub besson", "ca caa",1,listOf(2,3), Pointage(listOf(1,1),listOf(listOf(6,1),listOf(4,1),listOf(2,1)),listOf(1,0),false), 0)
        val m4=  Match("lub besson", "ca caa",1,listOf(2,3), Pointage(listOf(1,1),listOf(listOf(6,1),listOf(4,1),listOf(2,1)),listOf(1,0),false), 0)
        val m5=  Match("lub besson", "ca caa",1,listOf(2,3), Pointage(listOf(1,1),listOf(listOf(6,1),listOf(4,1),listOf(2,1)),listOf(1,0),false), 0)
        val m6=  Match("lub besson", "ca caa",1,listOf(2,3), Pointage(listOf(1,1),listOf(listOf(6,1),listOf(4,1),listOf(2,1)),listOf(1,0),false), 0)
        val m7=  Match("lub besson", "ca caa",1,listOf(2,3), Pointage(listOf(1,1),listOf(listOf(6,1),listOf(4,1),listOf(2,1)),listOf(1,0),false), 0)
        val m8=  Match("lub besson", "ca caa",1,listOf(2,3), Pointage(listOf(1,1),listOf(listOf(6,1),listOf(4,1),listOf(2,1)),listOf(1,0),false), 0)
        val m9=  Match("lub besson", "ca caa",1,listOf(2,3), Pointage(listOf(1,1),listOf(listOf(6,1),listOf(4,1),listOf(2,1)),listOf(1,0),false), 0)
        val m10=  Match("lub besson", "ca caa",1,listOf(2,3), Pointage(listOf(1,1),listOf(listOf(6,1),listOf(4,1),listOf(2,1)),listOf(1,0),false), 0)

        val rvMatchs = findViewById<RecyclerView>(R.id.rvMatchs) as RecyclerView
        val matchs = ArrayList<Match>()


        val factory = MatchViewModelFactory(getMatchsRepository())
        val viewModel = ViewModelProvider(this, factory).get(MatchViewModel::class.java)
        rvMatchs.adapter = MatchsAdapter(matchs) { match -> adapterOnClick(match) }
        rvMatchs.layoutManager = LinearLayoutManager(this)

        viewModel.matchLiveData.observe(this, Observer {
            Log.d("MainActivity", "$it")

            matchs.addAll(it)
            Log.d("MainActivity", "$matchs")

            rvMatchs.adapter?.notifyDataSetChanged()

        })



        val matchsApi = TennisBetApiService.getRetrofitInstance().create(TennisBetApi::class.java)
        GlobalScope.launch{
            val results = matchsApi.getMatchs()
            if(results != null){
                Log.d("MainActivity", "onCreate: $results")
            }
        }





    }

    /* Opens ResumeActivity when RecyclerView item is clicked. */
    private fun adapterOnClick(match: Match) {
        val intent = Intent(this, ResumeActivity()::class.java)

        intent.putExtra("JOUEUR1", match.joueur1)
        intent.putExtra("JOUEUR2", match.joueur2)


        startActivity(intent)
    }

    private fun getMatchsRepository(): MatchRepository {
        val matchApiService: TennisBetApi by lazy {
            TennisBetApiService.getRetrofitInstance().create(TennisBetApi::class.java)
        }
        return MatchRepository(matchApiService)
    }
}