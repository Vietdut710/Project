package com.example.app_android

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class SongActivity : AppCompatActivity() {
    var songViewPlaylist : ListView ?= null
    var songAdapter : SongAdapter ?= null
    var songList : ArrayList<Song> ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song)


        songList = ArrayList()
        songList?.add(Song(1,"Đảng đã cho ta mùa xuân"))
        songList?.add(Song(1,"Đảng đã cho ta mùa xuân"))
        songList?.add(Song(1,"Đảng đã cho ta mùa xuân"))
        songList?.add(Song(1,"Đảng đã cho ta mùa xuân"))
        songList?.add(Song(1,"Đảng đã cho ta mùa xuân"))
        songList?.add(Song(1,"Đảng đã cho ta mùa xuân"))
        songList?.add(Song(1,"Đảng đã cho ta mùa xuân"))
        songList?.add(Song(1,"Đảng đã cho ta mùa xuân"))

        songAdapter = SongAdapter(songList!!)
        songViewPlaylist = findViewById(R.id.song_playlist)
        songViewPlaylist?.adapter = songAdapter

    }
}