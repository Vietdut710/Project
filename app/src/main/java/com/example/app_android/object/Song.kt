package com.example.app_android.`object`

class Song constructor(songID : String, songName : String) {
    var songID : String ?= null
    var songName : String ?= null

    init {
        this.songID = songID
        this.songName = songName
    }

}