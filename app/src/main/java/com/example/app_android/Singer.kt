package com.example.app_android

class Singer constructor(singerID : Long,singerName : String) {
    var singerID : Long ?= null
    var singerName : String ?= null

    init {
        this.singerID = singerID
        this.singerName = singerName
    }
}