package com.example.app_android.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.app_android.R
import com.example.app_android.`object`.Song
import com.example.app_android.activity.PlayMusicActivity
import com.example.app_android.role.onClickSong

class SongAdapter(var Song:ArrayList<Song>,var context: Context):RecyclerView.Adapter<SongAdapter.SongViewHolder>(){
    var allMusicList: ArrayList<String> = ArrayList()

    companion object{
        val MUSICLIST = "musiclist"
        val MUSICITEMPOS = "pos"
    }

    override fun getItemCount(): Int {
        return Song.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SongViewHolder {
        var view = LayoutInflater.from(p0!!.context).inflate(R.layout.activity_song,p0,false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(p0: SongViewHolder, p1: Int) {
        var songModel = Song[p1]
        var songid = songModel.songID
        var songname = songModel.songName
        p0!!.songID.text = songid
        p0!!.songName.text = songname
        p0!!.rootSong?.setOnClickListener {
            for (i in 0 until Song.size){
                    allMusicList.add(Song[i].songPath)
                }
            Toast.makeText(this.context,"Play " + songname, Toast.LENGTH_SHORT).show()
            var intent = Intent(this.context,PlayMusicActivity::class.java)
            intent.putExtra("Name",songname)
            intent.putStringArrayListExtra(MUSICLIST,allMusicList)
            intent.putExtra(MUSICITEMPOS,p1)
            this.context.startActivity(intent)
        }
//        p0.setOnClickSong(object : onClickSong {
//            override fun onClickListSong(view: View, pos: Int) {
//
//                Toast.makeText(context,"Play " + songname, Toast.LENGTH_SHORT).show()
//                Log.i("MAINN",allMusicList.toString())
//                var intent = Intent(context,PlayMusicActivity::class.java)
//
//                intent.putExtra(MUSICITEMPOS,pos)
//                context.startActivity(intent)
//            }
//
//        })
    }

    class SongViewHolder(list:View):RecyclerView.ViewHolder(list){
        var songID:TextView
        var songName:TextView
        var rootSong:RelativeLayout?=null
        init {
            songID = list.findViewById(R.id.song_id_music)
            songName = list.findViewById(R.id.song_name_music)
            rootSong = list.findViewById(R.id.rootSong)
//            itemView.setOnClickListener(this)
        }
//        fun setOnClickSong(onClickSong: onClickSong){
//            this.mOnClickOnClickSong = onClickSong
//        }
//
//        override fun onClick(v: View?) {
//            this.mOnClickOnClickSong!!.onClickListSong(v!!,adapterPosition)
//        }
    }
}