package com.example.app_android

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val playlistView = findViewById<View>(R.id.menu_lis_song) as ListView
        val thieunhi = Playlist("300 bài hát thiếu nhi","001")
        val nhactre = Playlist("200 bản nhạc trẻ","002")
        val cailuong = Playlist("Say sưa cải lương","003")

        val playList = arrayOf(thieunhi,nhactre,cailuong)
        val arrAdapter: ArrayAdapter<Playlist> = ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,playList)
        playlistView.adapter = arrAdapter
    }
}