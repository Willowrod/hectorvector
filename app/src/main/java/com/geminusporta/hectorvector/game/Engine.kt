package com.geminusporta.hectorvector.game

import com.geminusporta.hectorvector.Shortcuts
import com.geminusporta.hectorvector.constants.GameStates
import com.geminusporta.hectorvector.interfaces.TouchDelegate
import com.geminusporta.hectorvector.vectors.*
import javax.microedition.khronos.opengles.GL10

object Engine: Shortcuts, TouchDelegate {

    var alfie = Alfie()
    val test = Test()
    val bob = Bob()
    val mum = MotherShip()
    val font = Font()
    var logo = GeminusPorta()
    var willowRod = WillowRod()
    var sizer = Sizer()
    var box = BoundingBox()

    var wave = 0

    var state = GameStates.Title

    var vaders: ArrayList<Vector> = ArrayList()

    var fingers: ArrayList<Int> = arrayListOf(-1,-1,-1,-1,0,0)
    var starttime = System.currentTimeMillis()
    var framespassed = 1

    var triggerTime = System.currentTimeMillis()

    init {
        vaders.add(test)
        vaders.add(bob)
        vaders.add(mum)
        triggerTime = System.currentTimeMillis() + 4000
    }

    fun drawFrame(surface: GL10){
        surface.glClear(GL10.GL_COLOR_BUFFER_BIT or GL10.GL_DEPTH_BUFFER_BIT)
        showBoundingBox(surface)
        showFPS(surface)
        when (state){
            GameStates.Title -> showTitle(surface)
            GameStates.Menu -> showMenu(surface)
            GameStates.Game -> showTitle(surface)
            GameStates.GameOver -> showTitle(surface)
            GameStates.HighScoreEntry -> showTitle(surface)
            GameStates.HighScoreTable -> showTitle(surface)
        }
    }

    private fun showBoundingBox(surface: GL10){
        surface.glLoadIdentity()
        surface.glTranslatef(0.5f, 0.3f, 0.0f)
        box.render(surface)
    }

    private fun showFPS(surface: GL10){
            framespassed++
            val FPSseconds = (System.currentTimeMillis() - starttime).toInt() / 1000
            if (FPSseconds > 0)
                //Text.RenderText(
                font.renderString(
                    surface, "FPS = " + framespassed / FPSseconds,
                    0.015f, 0.57f,0, newScale = 0.5f
                )

    }

    private fun showTitle(surface: GL10) {
        surface.glLoadIdentity()
        when (wave) {
            0 -> {
                surface.glTranslatef(0.5f, 0.34f, 0.0f)
                logo.render(surface)
                font.renderString(surface, "Geminus Porta", 0.51f, 0.35f)
                if (eitherFingerLifted() || triggered()){
        wave = 1
                    triggerIn(3000)
                }

            }
            else -> {
                surface.glTranslatef(0.5f, 0.34f, 0.0f)
                willowRod.render(surface)
                font.renderString(surface, "Willow Rod Games", 0.50f, 0.05f)
                if (eitherFingerLifted() || triggered()){
                        state = GameStates.Menu
                    wave = 0
                }

            }
        }
    }

    private fun triggerIn(timeToTrigger: Long){
        triggerTime = System.currentTimeMillis() + timeToTrigger
    }

    private fun triggered(): Boolean {

        if (triggerTime > 0 && System.currentTimeMillis() >= triggerTime){
            triggerTime = 0
            return true
        }
        return false
    }


    private fun showMenu(surface: GL10) {
        font.renderString(surface, "Hector Vector - Earth Protector", 0.50f, 0.54f)
        font.renderString(surface, "Touch screen to play", 0.50f, 0.03f)
    }



    override fun touchDown(x: Int, y: Int, touch: Int) {
        if (touch < 2) {
            fingers[4 + touch] = 0
            fingers[touch] = x
            fingers[touch + 2] = y
        }
    }

    override fun touchMove(x: Int, y: Int, touch: Int) {
        if (touch < 2) {
            fingers[4 + touch] = 0
            fingers[touch] = x
            fingers[touch + 2] = y
        }
    }

    override fun touchUp(touch: Int) {
        if (touch < 2) {
            fingers[4 + touch] = 1
            fingers[touch] = -1
            fingers[touch + 2] = -1
        }
    }

    fun eitherFingerLifted(): Boolean {
        if (fingers[4] == 1 || fingers[5] == 1){
            fingers[4] = 0
            fingers[5] = 0
            return true
        }
        return false
    }



}
