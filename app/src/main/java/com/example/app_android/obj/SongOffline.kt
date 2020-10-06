package com.example.app_android.obj

class SongOffline constructor(songID : String, songName : String) {
    var songID : String ?= null
    var songName : String ?= null

    init {
        this.songID = songID
        this.songName = songName
    }

}