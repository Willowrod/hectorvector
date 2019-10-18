package com.geminusporta.hectorvector.vectors

import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer
import java.util.*
import javax.microedition.khronos.opengles.GL10

open class Vector {
    open var frame: Int = 0
    var vertexBuffer: ArrayList<FloatBuffer> = ArrayList()
    var vLength: ArrayList<Int> = ArrayList()
    var show = true
    var gap = 0.06f
    open var speed = 500L
    var currentTime = Date().time

    fun runFrame(){
        if (vertexBuffer.size > 1) {
            val time = Date().time
            if (time > currentTime + speed) {
                currentTime = time
                update()
            }
        } else {
            update()
        }
    }

    open fun update() {

        frame++
        if (frame >= vertexBuffer.size) {
            frame = 0
        }
    }

    fun render(gl: GL10) {
        draw(gl)
       // gl.glTranslatef(gap, 0.0f, 0.0f)
    }

    fun setColour(gl: GL10){
        gl.glColor4f(1f, 1f, 1f, 0.8f)
    }

    open fun draw(gl: GL10) {
        setColour(gl)
        gl.glVertexPointer(2, GL10.GL_FLOAT, 0, vertexBuffer[frame])
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY)
        gl.glDrawArrays(GL10.GL_LINES, 0, vLength[frame])
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY)
    }

    fun addFrame(frame: FloatArray){
        var buffer = ByteBuffer.allocateDirect(frame.size * 4)
        buffer.order(ByteOrder.nativeOrder())
        var floatBuffer =  buffer.asFloatBuffer()
        floatBuffer.put(frame)
        floatBuffer.position(0)
        vertexBuffer.add(floatBuffer)
        vLength.add(frame.size / 2)
    }

}