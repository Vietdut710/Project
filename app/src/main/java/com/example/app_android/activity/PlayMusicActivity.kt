package com.example.app_android.activity

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.app_android.R

import kotlinx.android.synthetic.main.activity_play_music.*

class PlayMusicActivity:AppCompatActivity()  {

    private lateinit var media: MediaPlayer
    private var totalTime: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_music)

        media = MediaPlayer.create(this, R.raw.rise)
        media.isLooping = true
        media.setVolume(0.5f, 0.5f)
        totalTime = media.duration
    }

    fun BtnPlayOnClick(view: View){
        if(media.isPlaying){
            media.pause()
            play_music_play.setBackgroundResource(R.drawable.ic_play)
        }
        else {
            media.start()
            play_music_play.setBackgroundResource(R.drawable.ic_stop)
        }
    }


}