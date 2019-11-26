package com.geminusporta.hectorvector

import android.opengl.GLSurfaceView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.TouchDelegate
import android.view.View
import com.geminusporta.hectorvector.game.Engine
import com.geminusporta.hectorvector.opengl1.VectorRenderer
import com.geminusporta.hectorvector.services.LoggingService


class HectorVectorActivity : AppCompatActivity() {

    var touchDelegate: TouchDelegate? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val flags = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        window.decorView.systemUiVisibility = flags
        val decorView = window.decorView
        decorView
            .setOnSystemUiVisibilityChangeListener { visibility ->
                if (visibility and View.SYSTEM_UI_FLAG_FULLSCREEN == 0) {
                    decorView.systemUiVisibility = flags
                }
            }
        val surface = GLSurfaceView(this)
        val renderer = VectorRenderer()
        surface.setRenderer(renderer)
        setContentView(surface)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
event?.let{touch ->
    for (i in 0 until touch.pointerCount) {
        val x = touch.getX(i).toInt()
        val y = touch.getY(i).toInt()
        val id = touch.getPointerId(i)
        val action = touch.actionMasked
        val actionIndex = touch.actionIndex
        if (i < 2) {
            when (action) {
                MotionEvent.ACTION_DOWN, MotionEvent.ACTION_POINTER_DOWN -> {
                    Engine.touchDown(x, y, id)
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_POINTER_UP -> {
                    Engine.touchUp(id)
                }
                MotionEvent.ACTION_MOVE -> {
                    Engine.touchMove(x, y, id)
                }
                else -> {
                }
            }

            var actionString: String = when (action) {
                MotionEvent.ACTION_DOWN -> "DOWN"
                MotionEvent.ACTION_UP -> "UP"
                MotionEvent.ACTION_POINTER_DOWN -> "PNTR DOWN"
                MotionEvent.ACTION_POINTER_UP -> "PNTR UP"
                MotionEvent.ACTION_MOVE -> "MOVE"
                else -> ""
            }

          //  LoggingService.Log("Action: $actionString Index: $actionIndex ID: $id X: $x Y: $y")

        }
    }
}
        return super.onTouchEvent(event)
    }

}
