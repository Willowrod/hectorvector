package com.geminusporta.hectorvector.game

import com.geminusporta.hectorvector.Shortcuts
import com.geminusporta.hectorvector.constants.GameStates
import com.geminusporta.hectorvector.vectors.*
import javax.microedition.khronos.opengles.GL10

object Engine: Shortcuts {

    var alfie = Alfie()
    val test = Test()
    val bob = Bob()
    val mum = MotherShip()
    val sven = Sven()
    var logo = GeminusPorta()

    var state = GameStates.Title

    var vaders: ArrayList<Vector> = ArrayList()

    init {
        vaders.add(alfie)
        vaders.add(test)
        vaders.add(bob)
        vaders.add(mum)
     //   vaders.add(sven)
    }

    fun drawFrame(surface: GL10){
        surface.glClear(GL10.GL_COLOR_BUFFER_BIT or GL10.GL_DEPTH_BUFFER_BIT)
        when (state){
            GameStates.Title -> showTitle(surface)
            GameStates.Menu -> showMenu(surface)
            GameStates.Game -> showTitle(surface)
            GameStates.GameOver -> showTitle(surface)
            GameStates.HighScoreEntry -> showTitle(surface)
            GameStates.HighScoreTable -> showTitle(surface)
        }
    }

    private fun showTitle(surface: GL10) {

        surface.glLoadIdentity()
        surface.glTranslatef(0.5f, 0.25f, 0.0f)
        logo.render(surface)
    }

    private fun showMenu(surface: GL10) {
        surface.glLoadIdentity()
        surface.glTranslatef(0.5f, 0.4f, 0.0f)
        vaders.forEach { vader ->
            vader.runFrame()
            vader.render(surface)
            surface.glTranslatef(0.0f, -0.06f, 0.0f)
        }
    }
}
