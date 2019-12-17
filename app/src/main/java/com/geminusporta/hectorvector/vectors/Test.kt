package com.geminusporta.hectorvector.vectors

class Test: Vector() {

    var multiplier = 1
    override var frameSpeed = 100L

    var frame1: FloatArray = floatArrayOf(
        -0.001f, -0.001f,
        -0.001f, 0.001f,
        -0.001f, 0.001f,
        0.001f, 0.001f,
        0.001f, 0.001f,
        0.001f, -0.001f,
        0.001f, -0.001f,
        -0.001f, -0.001f
    )

    var frame2: FloatArray = floatArrayOf(
        -0.002f, -0.002f,
        -0.002f, 0.002f,
        -0.002f, 0.002f,
        0.002f, 0.002f,
        0.002f, 0.002f,
        0.002f, -0.002f,
        0.002f, -0.002f,
        -0.002f, -0.002f
    )
    var frame3: FloatArray = floatArrayOf(
        -0.003f, -0.003f,
        -0.003f, 0.003f,
        -0.003f, 0.003f,
        0.003f, 0.003f,
        0.003f, 0.003f,
        0.003f, -0.003f,
        0.003f, -0.003f,
        -0.003f, -0.003f
    )

    var frame4: FloatArray = floatArrayOf(
        -0.005f, -0.005f,
        -0.005f, 0.005f,
        -0.005f, 0.005f,
        0.005f, 0.005f,
        0.005f, 0.005f,
        0.005f, -0.005f,
        0.005f, -0.005f,
        -0.005f, -0.005f
    )

    var frame5: FloatArray = floatArrayOf(
        -0.0075f, -0.0075f,
        -0.0075f, 0.0075f,
        -0.0075f, 0.0075f,
        0.0075f, 0.0075f,
        0.0075f, 0.0075f,
        0.0075f, -0.0075f,
        0.0075f, -0.0075f,
        -0.0075f, -0.0075f
    )

    var frame6: FloatArray = floatArrayOf(
        -0.01f, -0.01f,
        -0.01f, 0.01f,
        -0.01f, 0.01f,
        0.01f, 0.01f,
        0.01f, 0.01f,
        0.01f, -0.01f,
        0.01f, -0.01f,
        -0.01f, -0.01f
    )

    var frame7: FloatArray = floatArrayOf(
        -0.02f, -0.02f,
        -0.02f, 0.02f,
        -0.02f, 0.02f,
        0.02f, 0.02f,
        0.02f, 0.02f,
        0.02f, -0.02f,
        0.02f, -0.02f,
        -0.02f, -0.02f
    )
    init {
        addFrame(frame1)
        addFrame(frame2)
        addFrame(frame3)
        addFrame(frame4)
        addFrame(frame5)
        addFrame(frame6)
        addFrame(frame7)
    }

    override fun update(isReversed: Boolean) {
        frame += multiplier
        if (frame >= vertexBuffer.size || frame < 0) {
            multiplier *= -1
            frame += multiplier
        }
    }
}