package com.example.app_android

class Song constructor(songID : Long,songName : String) {
    var songID : Long ?= null
    var songName : String ?= null

    init {
        this.songID = songID
        this.songName = songName
    }

}