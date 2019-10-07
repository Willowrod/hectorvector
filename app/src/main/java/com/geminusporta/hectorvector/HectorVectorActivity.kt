package com.geminusporta.hectorvector

import android.opengl.GLSurfaceView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geminusporta.hectorvector.opengl1.VectorRenderer

class HectorVectorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val surface = GLSurfaceView(this)
        surface.setRenderer(VectorRenderer())
        setContentView(surface)
    }
}
