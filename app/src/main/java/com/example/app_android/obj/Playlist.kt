package com.example.app_android.obj



class Playlist  {
    var playlistName : String ?= null
    var playlistID : Long ?= null
    constructor(playlistID: Long,playlistName : String) {
        this.playlistName = playlistName
        this.playlistID = playlistID
    }
}