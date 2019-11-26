package com.geminusporta.hectorvector.vectors

class BoundingBox: Vector() {
    var frame0 = floatArrayOf(
  -0.49f, -0.29f, 0.49f, -0.29f,
        0.49f, -0.29f, 0.49f, 0.29f,
        0.49f, 0.29f, -0.49f, 0.29f,
        -0.49f, 0.29f, -0.49f, -0.29f

//        ,-0.2f,-0.2f,0.2f,-0.2f,
//        0.2f,-0.2f,0.2f,0.2f,
//        0.2f,0.2f,-0.2f,0.2f,
//        -0.2f,0.2f,-0.2f,-0.2f
        )

    init {
        addFrame(frame0)
    }
}