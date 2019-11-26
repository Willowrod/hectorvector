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

    var state = GameStates.Title

    var vaders: ArrayList<Vector> = ArrayList()

    var fingers: ArrayList<Int> = arrayListOf(-1,-1,-1,-1,0,0)

    init {
        vaders.add(test)
        vaders.add(bob)
        vaders.add(mum)
    }

    fun drawFrame(surface: GL10){
        surface.glClear(GL10.GL_COLOR_BUFFER_BIT or GL10.GL_DEPTH_BUFFER_BIT)
        showBoundingBox(surface)
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

    private fun showTitle(surface: GL10) {
        surface.glLoadIdentity()
        surface.glTranslatef(0.5f, 0.34f, 0.0f)
        logo.render(surface)
        if (eitherFingerLifted()){
            state = GameStates.Menu
        }
    }

    private fun showMenu(surface: GL10) {
        surface.glLoadIdentity()
        surface.glTranslatef(0.5f, 0.4f, 0.0f)
        surface.glPushMatrix()
        font.renderString(surface,"abCDeFedcBA", 0)
        surface.glPopMatrix()
        surface.glTranslatef(0.0f, -0.06f, 0.0f)
        vaders.forEach { vader ->
            vader.runFrame()
            vader.render(surface)
            surface.glTranslatef(0.0f, -0.06f, 0.0f)
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
