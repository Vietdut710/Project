package com.example.app_android

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class PlayListViewAdapter constructor(listView : ArrayList<Playlist>) : BaseAdapter() {
    var listView : ArrayList<Playlist> ?= null

    init {
        this.listView = listView
    }

    override fun getCount(): Int {
        return listView!!.size
    }

    override fun getItem(position: Int): Any {
        return listView!!.get(position)
    }

    override fun getItemId(position: Int ): Long {
        return listView?.get(position)?.playlistID as Long
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewList : View
        viewList = convertView ?: View.inflate(parent?.context,R.layout.view_playlist,null)
        val playList : Playlist = getItem(position) as Playlist
        (viewList.findViewById<View>(R.id.view_playlistID)as TextView).text = playList.playlistID.toString()
       (viewList.findViewById<View>(R.id.view_playlistName)as TextView).text = playList.playlistName.toString()
        Log.d("avc",playList.playlistName.toString())
        return viewList
    }
}