package com.geminusporta.hectorvector.vectors

class GeminusPorta(x: Float = 0.5f, y: Float = 0.3f): Vector(x,y) {
    var frame0 = floatArrayOf(
        0f, 0.35f,
        -0.5f, 0.35f,

        -0.5f, 0.35f,
        -0.65f, 0.2f,

        -0.65f, 0.2f,
        -0.65f, -0.1f,

        -0.65f, -0.1f,
        -0.5f, -0.25f,

        -0.5f, -0.25f,
        -0.15f, -0.25f,

        -0.15f, -0.25f,
        -0.2f, -0.45f,

        -0.2f, -0.45f,
        0f, -0.5f,

        0f, -0.5f,
        0f, -0.15f,

        0f, -0.15f,
        -0.05f, -0.1f,

        -0.05f, -0.1f,
        -0.4f, -0.1f,

        -0.4f, -0.1f,
        -0.45f, -0.1f,

        -0.45f, -0.1f,
        -0.5f, -0.05f,

        -0.5f, -0.05f,
        -0.5f, 0.15f,

        -0.5f, 0.15f,
        -0.45f, 0.2f,

        -0.45f, 0.2f,
        0f, 0.2f,

        0f, 0.2f,
        0f, 0.35f,

        0.05f, 0.35f,
        0.05f, 0.2f,

        0.05f, 0.2f,
        0.5f, 0.2f,

        0.5f, 0.2f,
        0.55f, 0.15f,

        0.55f, 0.15f,
        0.55f, -0.05f,

        0.55f, -0.05f,
        0.5f, -0.1f,

        0.5f, -0.1f,
        0.1f, -0.1f,

        0.1f, -0.1f,
        0.05f, -0.15f,

        0.05f, -0.15f,
        0.05f, -0.5f,

        0.05f, -0.5f,
        0.25f, -0.45f,

        0.25f, -0.45f,
        0.2f, -0.25f,

        0.2f, -0.25f,
        0.55f, -0.25f,

        0.55f, -0.25f,
        0.7f, -0.1f,

        0.7f, -0.1f,
        0.7f, 0.2f,

        0.7f, 0.2f,
        0.55f, 0.35f,

        0.55f, 0.35f,
        0.05f, 0.35f
    )

    init {
        scale = 0.6f
        addFrame(frame0)
    }
}