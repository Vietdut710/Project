package com.example.app_android.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.app_android.R
import com.example.app_android.`object`.Song
import com.example.app_android.adapter.SongAdapter
import kotlinx.android.synthetic.main.activity_song.*
import kotlinx.android.synthetic.main.view_song.*

class SongActivity : AppCompatActivity(),View.OnClickListener {
    var songViewPlaylist : ListView ?= null
    var songAdapter : SongAdapter?= null
    var songList : ArrayList<Song> ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song)
        button.setOnClickListener(::onPlayClick)

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

    fun onPlayClick(view: View)
    {
        val intent = Intent(this,PlayMusicActivity::class.java)
        startActivity(intent)
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}