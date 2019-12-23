package com.geminusporta.hectorvector.vectors

import com.geminusporta.hectorvector.game.Engine
import com.geminusporta.hectorvector.models.InvaderPattern
import com.geminusporta.hectorvector.services.LoggingService
import java.math.BigDecimal
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer
import java.util.*
import javax.microedition.khronos.opengles.GL10
import kotlin.collections.ArrayList
import kotlin.math.pow
import kotlin.math.sqrt

open class Vector(x: Float = 0.5f, y: Float = 0.3f, theID: Int = -1) {
    var id: Int = -1
    open var frame: Int = 0
    var vertexBuffer: ArrayList<FloatBuffer> = ArrayList()
    var vLength: ArrayList<Int> = ArrayList()
    var show = true
    var gap = 0.06f
    open var scale = 1.0f
    open var frameSpeed = 200L
    var currentTime = Date().time

    var patterns: ArrayList<InvaderPattern> = ArrayList()
    var currentPattern: InvaderPattern? = null
    var patternFramesElapsed = 0
    var patternTimeStarted = System.currentTimeMillis()

    var currentX: BigDecimal = BigDecimal("-1")
    var currentY: Float = -1.0f

    var destinationX: Float = -1.0f
    var destinationY: Float = -1.0f

    var vectorX: Float = -1.0f
    var vectorY: Float = -1.0f

    open var moveSpeed = BigDecimal("0.02")//f//0.004f

    var DIRECTION = 1

    init {
        currentX = BigDecimal("$x")
        currentY = y
        id = theID
    }

    fun runFrame(isReversed: Boolean = false){
        if (vertexBuffer.size > 1) {
            val time = Date().time
            if (time > currentTime + frameSpeed) {
                currentTime = time
                update(isReversed)
            }
        } else {
            update(isReversed)
        }
    }

    fun reverse(){
        LoggingService.Log("Vader pre reverse - id:$id x:$currentX y:$currentY")
        DIRECTION *= -1
        currentY -= BigDecimal("0.05").toFloat()
        LoggingService.Log("Vader post reverse - id:$id x:$currentX y:$currentY")
    }

    open fun update(isReversed: Boolean) {
val moveSpeedTrue = moveSpeed * BigDecimal("$DIRECTION")
        frame++
        if (frame >= vertexBuffer.size) {
            frame = 0
        }
        currentX += moveSpeedTrue
        LoggingService.Log("Vader newPosition - id:$id x:$currentX y:$currentY")
        if (currentX > BigDecimal("1") && DIRECTION == 1 && !isReversed){
            LoggingService.Log("Vader triggers reverse - id:$id x:$currentX y:$currentY")
            Engine.shouldReverseInvaders = true
        } else if (currentX < BigDecimal("0") && DIRECTION == -1 && !isReversed){
            LoggingService.Log("Vader triggers reverse - id:$id x:$currentX y:$currentY")
            Engine.shouldReverseInvaders = true
        }
    }

    open fun render(gl: GL10) {
        draw(gl)
    }

    open fun renderFrame(gl: GL10, frameToRender: Int) {
        if (frameToRender < vertexBuffer.size && frameToRender >= 0) {
            frame = frameToRender
        }
        draw(gl)
    }

    open fun renderString(gl: GL10, stringToRender: String, aligned: Int = 1, newScale: Float = 1.0f) {

    }

    open fun renderString(gl: GL10, stringToRender: String, x: Float, y: Float, aligned: Int = 1, newScale: Float = 1.0f) {
        gl.glPushMatrix()
        gl.glLoadIdentity()
        gl.glTranslatef(x,y,0.0f)
       // scale = newScale
        renderString(gl,stringToRender, aligned, newScale)
        gl.glPopMatrix()
    }

    fun setColour(gl: GL10){
        gl.glColor4f(1f, 1f, 1f, 0.8f)
    }

    open fun draw(gl: GL10) {
        setColour(gl)
        gl.glLoadIdentity()
        gl.glTranslatef(currentX.toFloat(),currentY,0.0f)
        gl.glScalef(scale,scale,1.0f)
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

    fun addPattern(x1:Float = -1.0f, y1: Float = -1.0f, x2: Float = -1.0f, y2: Float = -1.0f, holdFrames: Int = 0, holdMills: Long = 0L){
        val pattern = InvaderPattern()
        pattern.startPositionX = x1
        pattern.startPositionY = y1
        pattern.endPositionX = x2
        pattern.endPositionY = y2
        pattern.framesToRender = holdFrames
        pattern.timeToRender = holdMills
        patterns.add(InvaderPattern())
    }

    fun setUpMovement(dX: Float, dY: Float){
        val vX = dX - currentX.toFloat()
        val vY = dY - currentY
    destinationX = dX
        destinationY = dY

        val vL = sqrt(vX.pow(2) + vY.pow(2))
        val steps: Float = vL / moveSpeed.toFloat()
        vectorX = if (vX == 0.0f || steps == 0.0f){
            0.0f
        } else {
            vX / steps
        }

        vectorY = if (vY == 0.0f || steps == 0.0f){
            0.0f
        } else {
            vY / steps
        }
    }
}