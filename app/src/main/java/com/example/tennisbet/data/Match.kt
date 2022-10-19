package com.example.tennisbet.data

import androidx.annotation.DrawableRes

data class Match (

    val joueur1: String,
    val joueur2: String,
    val serveur: Int,
    val contestation: List<Int>?,
    val pointage: Pointage,
    val temps_partie: Long
    )