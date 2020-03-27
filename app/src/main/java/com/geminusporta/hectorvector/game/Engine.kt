package com.geminusporta.hectorvector.game

import android.provider.SyncStateContract.Helpers.update
import com.geminusporta.hectorvector.Shortcuts
import com.geminusporta.hectorvector.constants.GameStates
import com.geminusporta.hectorvector.interfaces.TouchDelegate
import com.geminusporta.hectorvector.services.LoggingService
import com.geminusporta.hectorvector.vectors.*
import com.geminusporta.hectorvector.vectors.Vector
import java.math.BigDecimal
import java.util.*
import javax.microedition.khronos.opengles.GL10
import kotlin.collections.ArrayList

object Engine: Shortcuts, TouchDelegate {

    var invaderTime: Long = 0
    var invaderFrameSpeed = 100L
    var alfie = Alfie()
    val test = Test()
    val bob = Bob()
    val mum = MotherShip()
    val font = Font()
    var logo = GeminusPorta(0.5f, 0.34f)
    var willowRod = WillowRod(0.5f, 0.34f)
    var sizer = Sizer()
    var box = BoundingBox()
    var inUpdate = false

    var wave = 0

    var state = GameStates.Title

    var vaders: ArrayList<Vector> = ArrayList()

    var fingers: ArrayList<Int> = arrayListOf(-1,-1,-1,-1,0,0)
    var starttime = System.currentTimeMillis()
    var framespassed = 1

    var triggerTime = System.currentTimeMillis()

    var shouldReverseInvaders = false

    init {
        triggerTime = System.currentTimeMillis() + 4000
    }

    fun drawFrame(surface: GL10){
        surface.glClear(GL10.GL_COLOR_BUFFER_BIT or GL10.GL_DEPTH_BUFFER_BIT)
        showBoundingBox(surface)
        showFPS(surface)
        when (state){
            GameStates.Title -> showTitle(surface)
            GameStates.Menu -> showMenu(surface)
            GameStates.Game -> showGame(surface)
            GameStates.GameOver -> showGame(surface)
            GameStates.HighScoreEntry -> showTitle(surface)
            GameStates.HighScoreTable -> showTitle(surface)
        }
    }

    private fun showBoundingBox(surface: GL10){
       // surface.glLoadIdentity()
       // surface.glTranslatef(0.5f, 0.3f, 0.0f)
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
        if (eitherFingerLifted()){
            setGameToPlay()
        }
    }

    private fun setGameToPlay() {
vaders = ArrayList()
        var count = 0
        for (a in 1..11) {
            val theFloat = (BigDecimal("0.06") * BigDecimal("$a")).toFloat()
            log.Log("Creating invader $count at X:$theFloat")
            vaders.add(Alfie(theFloat, 0.46f, count))
            log.Log("Creating invader ${count + 1} at X:$theFloat")
            vaders.add(Bob(theFloat, 0.4f, count + 1))
            count += 2
        }
//        for (a in 1..11) {
//            val theFloat = (0.05f * a).toFloat()
//            log.Log("Creating invader $count at X:$theFloat")
//            vaders.add(Bob(theFloat, 0.4f, count))
//            //vaders.add(Bob(0.05f * a, 0.4f, count))
//            count += 1
//        }
//        vaders.add(GeminusPorta(0.5f, 0.4f))
        state = GameStates.Game
    }

    private fun showGame(surface: GL10){
        surface.glLoadIdentity()
runInvadersForLevel(surface)
    }

    fun runInvadersForLevel(surface: GL10){

        val time = Date().time
        if (time > invaderTime + 500L - invaderFrameSpeed) {
            invaderTime = time
            var reverse = false
            if (shouldReverseInvaders){
                for (vader in vaders){
                    vader.reverse()
                }
                shouldReverseInvaders = false
            } else if (!inUpdate) {
                inUpdate = true
                for (vader in vaders) {
                    vader.runFrame(reverse)
                    vader.render(surface)
                }
                inUpdate = false
            }
        } else {
            for (vader in vaders) {
                vader.render(surface)
            }
        }
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
