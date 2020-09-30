package com.example.app_android

import java.io.Serializable

class Playlist : Serializable {
    var playlistName : String ?= null
    var playlistID : String ?= null
    constructor(playlistName : String,playlistID: String){
        this.playlistID = playlistID
        this.playlistName = playlistName
    }
    override fun toString(): String {
        return playlistName + " (" + playlistID + ")"
    }
}