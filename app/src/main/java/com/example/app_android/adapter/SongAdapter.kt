package com.example.app_android.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.app_android.R
import com.example.app_android.`object`.Song

class SongAdapter constructor(songAdapter: ArrayList<Song>) : BaseAdapter() {
    var songAdapter : ArrayList<Song> ?= null

    init {
        this.songAdapter = songAdapter
    }

    override fun getCount(): Int {
        return songAdapter!!.size
    }

    override fun getItem(position: Int): Any {
        return songAdapter!!.get(position)
    }

    override fun getItemId(position: Int): Long {
        return songAdapter?.get(position)?.songID as Long
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewSong : View
        viewSong = convertView ?: View.inflate(parent?.context, R.layout.activity_song,null)
        val songList : Song = getItem(position) as Song
        (viewSong.findViewById<View>(R.id.view_songID)as TextView).text = songList.songID.toString()
        (viewSong.findViewById<View>(R.id.view_songName)as TextView).text = songList.songName.toString()
        return viewSong
    }
}