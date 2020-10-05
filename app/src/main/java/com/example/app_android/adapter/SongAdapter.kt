package com.example.app_android.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.app_android.R
import com.example.app_android.`object`.Song
import com.example.app_android.activity.PlayMusicActivity
import com.example.app_android.role.onClickSong

//class SongAdapter constructor(songAdapter: ArrayList<Song>) : BaseAdapter() {
//    var songAdapter : ArrayList<Song> ?= null
//
//    init {
//        this.songAdapter = songAdapter
//    }
//
//    override fun getCount(): Int {
//        return songAdapter!!.size
//    }
//
//    override fun getItem(position: Int): Any {
//        return songAdapter!!.get(position)
//    }
//
//    override fun getItemId(position: Int): Long {
//        return songAdapter?.get(position)?.songID as Long
//    }
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        val viewSong : View
//        viewSong = convertView ?: View.inflate(parent?.context, R.layout.view_song,null)
//        val songList : Song = getItem(position) as Song
//        (viewSong.findViewById<View>(R.id.view_songID)as TextView).text = songList.songID.toString()
//        (viewSong.findViewById<View>(R.id.view_songName)as TextView).text = songList.songName.toString()
//        return viewSong
//    }
//}

class SongAdapter(Song:ArrayList<Song>, context: Context):RecyclerView.Adapter<SongAdapter.SongViewHolder>(){
    var mContext = context
    var mSong = Song

    companion object{
        val MUSICLIST = "musiclist"
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SongViewHolder {
        var view = LayoutInflater.from(p0!!.context).inflate(R.layout.activity_song,p0,false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(p0: SongViewHolder, p1: Int) {
        var songModel = mSong[p1]
        var songid = songModel.songID
        var songname = songModel.songName
        p0!!.songID.text = songid
        p0!!.songName.text = songname
        p0.setOnClickSong(object : onClickSong {
            override fun onClickSong(view: View, pos: Int) {
                Toast.makeText(mContext,"Play music" + songname, Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun getItemCount(): Int {
        return mSong.size
    }

    class SongViewHolder(list:View):RecyclerView.ViewHolder(list),View.OnClickListener{
        var songID:TextView
        var songName:TextView
        var mOnClickOnClickSong: onClickSong?=null

        init {
            songID = list.findViewById(R.id.song_id_music)
            songName = list.findViewById(R.id.song_name_music)
            itemView.setOnClickListener(this)
            list.setOnClickListener {
                val intent = Intent(list.context, PlayMusicActivity::class.java)
//                intent.putStringArrayListExtra(MUSICLIST,)
                list.context.startActivity(intent)
            }

        }

        fun setOnClickSong(onClickOnClickSong: onClickSong){
            this.mOnClickOnClickSong = onClickOnClickSong
        }



        override fun onClick(v: View?) {
            this.mOnClickOnClickSong!!.onClickSong(v!!,adapterPosition)
        }

    }


}