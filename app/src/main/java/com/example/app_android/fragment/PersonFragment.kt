package com.example.app_android.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.app_android.`object`.Playlist
import com.example.app_android.R
import com.example.app_android.activity.SingerActivity
import com.example.app_android.activity.SongActivity
import com.example.app_android.adapter.PlayListViewAdapter
import kotlinx.android.synthetic.main.activity_menu.*




class PersonFragment : Fragment() {



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_menu, container, false)
        //no comment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //button Song
        menu_btn_song.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, SongActivity::class.java)
            startActivity(intent)
        })
        //button Singer
        menu_btn_singer.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, SingerActivity::class.java)
            startActivity(intent)
        })
        //button mv
        menu_btn_mv.setOnClickListener(View.OnClickListener {
            Toast.makeText(context,"Click test ok ",Toast.LENGTH_SHORT).show()
        })
        //button like
        menu_btn_like.setOnClickListener(View.OnClickListener {
            Toast.makeText(context,"Click test ok ",Toast.LENGTH_SHORT).show()
        })
        //button download
        menu_btn_download.setOnClickListener(View.OnClickListener {
            Toast.makeText(context,"Click test ok ",Toast.LENGTH_SHORT).show()
        })
        //button upload
        menu_btn_upload.setOnClickListener(View.OnClickListener {
            Toast.makeText(context,"Click test ok ",Toast.LENGTH_SHORT).show()
        })
        //create List Play List in home
        createListPL()

    }

    //-----------------function--------------------//

    fun createListPL(){
        var listView :ArrayList<Playlist> ?= null
        var playListViewArrayAdapter : PlayListViewAdapter?= null
        var listViewPlaylist : ListView?= null

        listView = ArrayList()
        listView!!.add(Playlist(1,"300 bài hát thiếu nhi"))
        listView!!.add(Playlist(2,"200 bài ca chiến sĩ"))
        listView!!.add(Playlist(3,"Khúc quân hành"))
        listView!!.add(Playlist(4,"Đảng cộng sản muôn năm"))
        playListViewArrayAdapter = PlayListViewAdapter(listView!!)

        listViewPlaylist = menu_playlist.findViewById(R.id.menu_playlist)
        listViewPlaylist?.setAdapter(playListViewArrayAdapter)
    }


    fun onTest(){

    }

}
