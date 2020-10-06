package com.example.app_android.activity

import android.Manifest
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_android.R
import com.example.app_android.obj.SongOffline
import com.example.app_android.adapter.SongOfflineAdapter
import kotlinx.android.synthetic.main.recycle_view_songoff.*

<<<<<<< HEAD:app/src/main/java/com/example/app_android/activity/SongOffActivity.kt
class SongOffActivity: AppCompatActivity() {
    var songList:ArrayList<SongOffline> = ArrayList()
    var songAdapter:SongOfflineAdapter?=null
=======
class SongActivity: AppCompatActivity() {

    var songList: ArrayList<Song> = ArrayList()
    var songAdapter: SongAdapter? = null
>>>>>>> 35963926eccf2669c570f0734d258b80d634d3d9:app/src/main/java/com/example/app_android/activity/SongActivity.kt

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycle_view_songoff)

        if (ContextCompat.checkSelfPermission(
                applicationContext,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        )
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 131)
        else {
            loadData()
        }
    }

    fun loadData() {
        var songFind: Cursor? = contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            null, null, null, null
        )
        while (songFind != null && songFind.moveToNext()) {
            var songID = songFind.getString(songFind.getColumnIndex(MediaStore.Audio.Media.BUCKET_ID))
            var songName = songFind.getString(songFind.getColumnIndex(MediaStore.Audio.Media.TITLE))
            var songPath = songFind.getString(songFind.getColumnIndex(MediaStore.Audio.Media.DATA))
            songList.add(Song(songID, songName, songPath))
        }
        songAdapter = SongAdapter(songList, this)
        var layoutManager = LinearLayoutManager(this)
        recycle_song.layoutManager = layoutManager
        recycle_song.adapter = songAdapter
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 131) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(applicationContext, "Connect", Toast.LENGTH_SHORT).show()
                loadData()
            }
        }
    }
}

<<<<<<< HEAD:app/src/main/java/com/example/app_android/activity/SongOffActivity.kt
    private fun loadData() {
        var songFind:Cursor? = contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            null,null,null,null)
        while (songFind!=null && songFind.moveToNext()){
            var songID = songFind.getString(songFind.getColumnIndex(MediaStore.Audio.Media.BUCKET_ID))
            var songName = songFind.getString(songFind.getColumnIndex(MediaStore.Audio.Media.TITLE))
            songList.add(SongOffline(songID,songName))
        }
        songAdapter = SongOfflineAdapter(songList, applicationContext)
        var layoutManager =LinearLayoutManager(applicationContext)
        recycle_songoff.layoutManager = layoutManager
        recycle_songoff.adapter = songAdapter
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        //button notification
//        song_btn_play_music.setOnClickListener(View.OnClickListener {
//            Toast.makeText(this,"Click test ok ", Toast.LENGTH_SHORT).show()
//        })
//    }
=======
>>>>>>> 35963926eccf2669c570f0734d258b80d634d3d9:app/src/main/java/com/example/app_android/activity/SongActivity.kt





