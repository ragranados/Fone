package com.fone.fonetesting

class Settings {

    var pitch: Float
    var speed: Float

    init {
        pitch = 1.0f
        speed = 1.0f
    }

    companion object {
        val instance = Settings()
    }
}