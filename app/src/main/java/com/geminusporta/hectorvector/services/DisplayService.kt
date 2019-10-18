package com.geminusporta.hectorvector.services

object DisplayService {
    var screenWidth: Int = 0
    var screenHeight: Int = 0

    fun change(w: Int, h: Int){
        screenHeight = h
        screenWidth = w
    }
}