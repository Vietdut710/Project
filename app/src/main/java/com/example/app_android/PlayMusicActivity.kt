package com.example.app_android

import android.media.MediaPlayer
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_play_music.*
class PlayMusicActivity:AppCompatActivity() {

    //private  var song : MediaPlayer? = null
    lateinit var btnPlay : ImageButton
    lateinit var btnStop : ImageButton
    lateinit var  arrsong : ArrayList<Singsong>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_music)

        val actionbar : ActionBar? = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        actionbar!!.setDisplayShowHomeEnabled(true)


        var intent = intent
        val htitle = intent.getStringExtra("ititle")
        val hcontent = intent.getStringExtra("icontent")
        val himage = intent.getIntExtra("iimage", 0)
        var himagestart = intent.getIntExtra("iimagery",0)
        var hdata_ms = intent.getIntExtra("iplay_music_play", 0)

        actionbar.setTitle("Music Song")
        title1.text = htitle
        content1.text = hcontent
        image1.setImageResource(himage)

        click()
        var song : MediaPlayer = MediaPlayer.create(this,hdata_ms)
        btnPlay.setOnClickListener{

            song.start()
        }
        btnStop.setOnClickListener{
            if (song.isPlaying)
            {
                song.pause()
            }else{
                song.start() 
            }
        }


    }
    fun click()
    {
        btnPlay = play_music_play
        btnStop = play_music_stop
    }

}