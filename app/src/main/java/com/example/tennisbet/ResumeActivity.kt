package com.example.tennisbet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResumeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resume)

        val bundle: Bundle? = intent.extras

        val joueur1: TextView = findViewById(R.id.resume)
        if (bundle != null) {
            joueur1.text = bundle.getString("JOUEUR1")
        }
    }
}