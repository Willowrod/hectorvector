package com.geminusporta.hectorvector.interfaces

interface TouchDelegate {
    fun touchDown(x: Int, y: Int, touch: Int)
    fun touchMove(x: Int, y: Int, touch: Int)
    fun touchUp(touch: Int)
}