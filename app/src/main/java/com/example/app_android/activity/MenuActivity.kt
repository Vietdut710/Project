package com.example.app_android.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.app_android.adapter.PlayListViewAdapter
import com.example.app_android.`object`.Playlist
import com.example.app_android.R


class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        createListView()

    }
    fun createListView(){
        var listView :ArrayList<Playlist> ?= null
        var playListViewArrayAdapter : PlayListViewAdapter?= null
        var listViewPlaylist :ListView ?= null

        listView = ArrayList()
        listView!!.add(Playlist(1,"300 bài hát thiếu nhi"))
        listView!!.add(Playlist(2,"200 bài ca chiến sĩ"))
        listView!!.add(Playlist(3,"Khúc quân hành"))
        listView!!.add(Playlist(4,"Đảng cộng sản muôn năm"))
        playListViewArrayAdapter = PlayListViewAdapter(listView!!)

        listViewPlaylist =findViewById(R.id.menu_playlist)
        listViewPlaylist?.setAdapter(playListViewArrayAdapter)
    }

    fun onClickSong(view: View) {
        val intent = Intent(this, SongActivity::class.java)
        startActivity(intent)
    }

    fun onClickSinger(view: View) {
        val intent = Intent(this, SingerActivity::class.java)
        startActivity(intent)
    }
    fun onClickmv(view: View) {}
    fun onClicklike(view: View) {}
    fun onClickdownload(view: View) {}
    fun onClickupload(view: View) {}
}