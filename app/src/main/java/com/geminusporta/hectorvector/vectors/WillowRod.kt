package com.geminusporta.hectorvector.vectors

class WillowRod(x: Float = 0.5f, y: Float = 0.3f): Vector(x,y) {

    var frame0 = floatArrayOf(
    0.20f,0.90f,0.10f,0.90f,
    0.10f,0.90f,-0.10f,0.70f,
    -0.10f,0.70f,-0.04f,0.28f,
    -0.04f,0.28f,-0.60f,-0.30f,
    -0.60f,-0.30f,-0.40f,-0.90f,
    -0.40f,-0.90f,-0.50f,-0.40f,
    -0.50f,-0.40f,0.10f,0.10f,
    0.10f,0.10f,0.50f,-0.30f,
    0.50f,-0.30f,0.40f,-0.90f,
    0.40f,-0.90f,0.70f,-0.20f,
    0.70f,-0.20f,0.20f,0.30f,
    0.20f,0.30f,0.20f,0.90f
    )

    init {
        scale = 0.25f
        addFrame(frame0)
    }


}