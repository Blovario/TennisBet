package com.example.tennisbet.data

data class Pointage (
    val manches: List<Int>,
    val jeu: List<List<Int>>,
    val echange: List<Int>,
    val final: Boolean
    )