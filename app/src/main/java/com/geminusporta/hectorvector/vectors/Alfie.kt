package com.geminusporta.hectorvector.vectors

class Alfie(x: Float = 0.5f, y: Float = 0.3f, theID: Int = -1): Vector(x, y, theID) {

    var frame1: FloatArray = floatArrayOf(
        -0.00375f, 0.015f, 0.00375f, 0.015f,

        0.00375f, 0.015f, 0.00375f, 0.01125f,

        0.00375f, 0.01125f, 0.0075f, 0.01125f,

        0.0075f, 0.01125f, 0.0075f, 0.0075f,

        0.0075f, 0.0075f, 0.01125f, 0.0075f,

        0.01125f, 0.0075f, 0.01125f, 0.00375f,

        0.01125f, 0.00375f, 0.015f, 0.00375f,

        0.015f, 0.00375f, 0.015f, -0.00375f,

        0.015f, -0.00375f, 0.0075f, -0.00375f,

        0.0075f, -0.00375f, 0.0075f, -0.01125f,

        0.0075f, -0.01125f, 0.015f, -0.01125f,

        0.015f, -0.01125f, 0.015f, -0.015f,

        0.015f, -0.015f, 0.01125f, -0.015f,

        0.01125f, -0.015f, 0.01125f, -0.0075f,

        0.01125f, -0.0075f, 0.00375f, -0.0075f,

        0.00375f, -0.0075f, 0.00375f, -0.00375f,

        0.00375f, -0.00375f, -0.00375f, -0.00375f,

        -0.00375f, -0.00375f, -0.00375f, -0.0075f,

        -0.00375f, -0.0075f, -0.01125f, -0.0075f,

        -0.01125f, -0.0075f, -0.01125f, -0.015f,

        -0.01125f, -0.015f, -0.015f, -0.015f,

        -0.015f, -0.015f, -0.015f, -0.01125f,

        -0.015f, -0.01125f, -0.0075f, -0.01125f,

        -0.0075f, -0.01125f, -0.0075f, -0.00375f,

        -0.0075f, -0.00375f, -0.015f, -0.00375f,

        -0.015f, -0.00375f, -0.015f, 0.00375f,

        -0.015f, 0.00375f, -0.01125f, 0.00375f,

        -0.01125f, 0.00375f, -0.01125f, 0.0075f,

        -0.01125f, 0.0075f, -0.0075f, 0.0075f,

        -0.0075f, 0.0075f, -0.0075f, 0.01125f,

        -0.0075f, 0.01125f, -0.00375f, 0.01125f,

        -0.00375f, 0.01125f, -0.00375f, 0.015f,

        -0.0075f, 0.0075f, -0.0075f, 0.00375f,

        -0.0075f, 0.00375f, -0.00375f, 0.00375f,

        -0.00375f, 0.00375f, -0.00375f, 0.0075f,

        -0.00375f, 0.0075f, -0.0075f, 0.0075f,

        0.0075f, 0.0075f, 0.00375f, 0.0075f,

        0.00375f, 0.0075f, 0.00375f, 0.00375f,

        0.00375f, 0.00375f, 0.0075f, 0.00375f,

        0.0075f, 0.00375f, 0.0075f, 0.0075f
    )

    private val frame2 = floatArrayOf(
        -0.00375f, 0.015f, 0.00375f, 0.015f,

        0.00375f, 0.015f, 0.00375f, 0.01125f,

        0.00375f, 0.01125f, 0.0075f, 0.01125f,

        0.0075f, 0.01125f, 0.0075f, 0.0075f,

        0.0075f, 0.0075f, 0.01125f, 0.0075f,

        0.01125f, 0.0075f, 0.01125f, 0.00375f,

        0.01125f, 0.00375f, 0.015f, 0.00375f,

        0.015f, 0.00375f, 0.015f, -0.00375f,

        0.015f, -0.00375f, 0.0075f, -0.00375f,

        0.0075f, -0.00375f, 0.0075f, -0.01125f,

        0.00375f, -0.0075f, 0.00375f, -0.00375f,

        0.00375f, -0.00375f, -0.00375f, -0.00375f,

        -0.00375f, -0.00375f, -0.00375f, -0.0075f,

        -0.0075f, -0.01125f, -0.0075f, -0.00375f,

        -0.0075f, -0.00375f, -0.015f, -0.00375f,

        -0.015f, -0.00375f, -0.015f, 0.00375f,

        -0.015f, 0.00375f, -0.01125f, 0.00375f,

        -0.01125f, 0.00375f, -0.01125f, 0.0075f,

        -0.01125f, 0.0075f, -0.0075f, 0.0075f,

        -0.0075f, 0.0075f, -0.0075f, 0.01125f,

        -0.0075f, 0.01125f, -0.00375f, 0.01125f,

        -0.00375f, 0.01125f, -0.00375f, 0.015f,

        -0.0075f, 0.0075f, -0.0075f, 0.00375f,

        -0.0075f, 0.00375f, -0.00375f, 0.00375f,

        -0.00375f, 0.00375f, -0.00375f, 0.0075f,

        -0.00375f, 0.0075f, -0.0075f, 0.0075f,

        0.0075f, 0.0075f, 0.00375f, 0.0075f,

        0.00375f, 0.0075f, 0.00375f, 0.00375f,

        0.00375f, 0.00375f, 0.0075f, 0.00375f,

        0.0075f, 0.00375f, 0.0075f, 0.0075f,

        0.0075f, -0.01125f, 0.00375f, -0.01125f,

        0.00375f, -0.01125f, 0.00375f, -0.015f,

        0.00375f, -0.015f, 0f, -0.015f,

        0f, -0.015f, 0f, -0.01125f,

        0f, -0.01125f, 0.00375f, -0.01125f,

        0.00375f, -0.01125f, 0.00375f, -0.0075f,

        -0.00375f, -0.0075f, -0.00375f, -0.01125f,

        -0.00375f, -0.01125f, 0f, -0.01125f,

        -0.00375f, -0.015f, -0.00375f, -0.015f,

        -0.00375f, -0.01125f, -0.0075f, -0.01125f,

        -0.00375f, -0.01125f, -0.00375f, -0.015f,

        -0.00375f, -0.015f, 0f, -0.015f
    )

    init {
        addFrame(frame1)
        addFrame(frame2)
    }
}