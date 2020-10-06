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
import com.example.app_android.`object`.Song
import com.example.app_android.adapter.SongAdapter
import kotlinx.android.synthetic.main.activity_information.*
import kotlinx.android.synthetic.main.activity_play_music.*
import kotlinx.android.synthetic.main.activity_song.*
import kotlinx.android.synthetic.main.recycle_view_song.*

class SongActivity: AppCompatActivity() {

    var songList: ArrayList<Song> = ArrayList()
    var songAdapter: SongAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycle_view_song)

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






