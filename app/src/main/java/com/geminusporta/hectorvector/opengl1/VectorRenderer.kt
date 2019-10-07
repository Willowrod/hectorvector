package com.geminusporta.hectorvector.opengl1

import android.opengl.GLES10.*
import android.opengl.GLSurfaceView
import com.geminusporta.hectorvector.game.Engine
import com.geminusporta.hectorvector.services.DisplayService
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

class VectorRenderer: GLSurfaceView.Renderer {
    override fun onDrawFrame(gl: GL10?) {
        gl?.let { surface ->
            Engine.drawFrame(surface)
        }
    }

    override fun onSurfaceChanged(gl: GL10?, width: Int, height: Int) {
DisplayService.screenWidth = width
        DisplayService.screenHeight = height
        gl?.let { surface ->
            surface.glViewport(0,0,width, height)
            val aspect = height.toFloat() / width.toFloat()
            surface.glMatrixMode(GL_PROJECTION)
            surface.glLoadIdentity()
            surface.glOrthof(0.0f,1.0f,0.0f,aspect,-1.0f,1.0f)
            surface.glMatrixMode(GL_MODELVIEW)
            surface.glLoadIdentity()
            surface.glEnableClientState(GL_VERTEX_ARRAY)
        }


    }

    override fun onSurfaceCreated(gl: GL10?, config: EGLConfig?) {


    }
}