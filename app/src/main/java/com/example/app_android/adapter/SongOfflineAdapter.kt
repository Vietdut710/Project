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
import androidx.recyclerview.widget.RecyclerView
import com.example.app_android.R
import com.example.app_android.obj.SongOffline
import com.example.app_android.activity.PlayMusicActivity
import com.example.app_android.role.onClickSong

<<<<<<< HEAD:app/src/main/java/com/example/app_android/adapter/SongOfflineAdapter.kt
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

class SongOfflineAdapter(Song:ArrayList<SongOffline>, context: Context):RecyclerView.Adapter<SongOfflineAdapter.SongViewHolder>(){
    var mContext = context
    var mSong = Song
=======
class SongAdapter(var Song:ArrayList<Song>,var context: Context):RecyclerView.Adapter<SongAdapter.SongViewHolder>(){
    var allMusicList: ArrayList<String> = ArrayList()
>>>>>>> 35963926eccf2669c570f0734d258b80d634d3d9:app/src/main/java/com/example/app_android/adapter/SongAdapter.kt

    companion object{
        val MUSICLIST = "musiclist"
        val MUSICITEMPOS = "pos"
    }

    override fun getItemCount(): Int {
        return Song.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SongViewHolder {
        var view = LayoutInflater.from(p0!!.context).inflate(R.layout.activity_songoff,p0,false)
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
<<<<<<< HEAD:app/src/main/java/com/example/app_android/adapter/SongOfflineAdapter.kt
            songID = list.findViewById(R.id.songoff_id_music)
            songName = list.findViewById(R.id.songoff_name_music)
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
=======
            songID = list.findViewById(R.id.song_id_music)
            songName = list.findViewById(R.id.song_name_music)
            rootSong = list.findViewById(R.id.rootSong)
//            itemView.setOnClickListener(this)
>>>>>>> 35963926eccf2669c570f0734d258b80d634d3d9:app/src/main/java/com/example/app_android/adapter/SongAdapter.kt
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