package com.geminusporta.hectorvector.opengl1

import android.opengl.GLES10.*
import android.opengl.GLSurfaceView
import com.geminusporta.hectorvector.Shortcuts
import com.geminusporta.hectorvector.game.Engine
import com.geminusporta.hectorvector.services.DisplayService
import com.geminusporta.hectorvector.services.LoggingService
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

class VectorRenderer: GLSurfaceView.Renderer, Shortcuts {
    var count = 0
    override fun onDrawFrame(gl: GL10?) {
        count += 1
        gl?.let { surface ->

            LoggingService.Log(".....New Frame.....")
            Engine.drawFrame(surface)
        }
    }

    override fun onSurfaceChanged(gl: GL10?, width: Int, height: Int) {
display.change(width,height)
        gl?.let { surface ->
            surface.glViewport(0,0,width, height)
            val aspect = height.toFloat() / width.toFloat()
            surface.glMatrixMode(GL_PROJECTION)
            surface.glLoadIdentity()
            //surface.glOrthof(0.0f,1.0f,0.0f,aspect,-1.0f,1.0f)
            if (aspect <= 0.6f){
                val xLength = ((0.6f / aspect) - 1.0f) / 2.0f //((width.toFloat() / height.toFloat()) - width) / 2.0f
                surface.glOrthof(-xLength, xLength + 1.0f, 0.0f, 0.6f, -1.0f, 1.0f)
            } else {
                surface.glOrthof(0.0f, 1.0f, 0.0f, aspect, -1.0f, 1.0f)
            }
            surface.glMatrixMode(GL_MODELVIEW)
            surface.glLoadIdentity()
            surface.glEnableClientState(GL_VERTEX_ARRAY)
        }


    }

    override fun onSurfaceCreated(gl: GL10?, config: EGLConfig?) {


    }
}