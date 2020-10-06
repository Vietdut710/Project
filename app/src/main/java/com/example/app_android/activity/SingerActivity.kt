package com.example.app_android.activity

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.app_android.R
import com.example.app_android.obj.Singer
import com.example.app_android.adapter.SingerAdapter

class SingerActivity : AppCompatActivity() {
    var singerViewPlaylist : ListView ?= null
    var singerAdapter : SingerAdapter?= null
    var singerList : ArrayList<Singer> ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singer)


        singerList = ArrayList()
        singerList?.add(Singer(1,"Rock and roll"))
        singerList?.add(Singer(1,"Rock and roll"))
        singerList?.add(Singer(1,"Rock and roll"))
        singerList?.add(Singer(1,"Rock and roll"))
        singerList?.add(Singer(1,"Rock and roll"))
        singerList?.add(Singer(1,"Rock and roll"))
        singerList?.add(Singer(1,"Rock and roll"))
        singerList?.add(Singer(1,"Rock and roll"))

        singerAdapter = SingerAdapter(singerList!!)
        singerViewPlaylist = findViewById(R.id.singer_playlist)
        singerViewPlaylist?.adapter = singerAdapter

    }
}