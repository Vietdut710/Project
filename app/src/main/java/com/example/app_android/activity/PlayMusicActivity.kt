package com.example.app_android.activity

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import android.widget.SeekBar
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

        play_music_bar_volume.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekbar: SeekBar?, progress: Int, fromUser: Boolean) {
                    if (fromUser) {
                        var volumeNum = progress / 100.0f
                        media.setVolume(volumeNum, volumeNum)
                    }
                }
                override fun onStartTrackingTouch(p0: SeekBar?) {
                }
                override fun onStopTrackingTouch(p0: SeekBar?) {
                }
            }
        )
        play_music_time_music.max = totalTime
        play_music_time_music.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    if (fromUser) {
                        media.seekTo(progress)
                    }
                }
                override fun onStartTrackingTouch(p0: SeekBar?) {
                }
                override fun onStopTrackingTouch(p0: SeekBar?) {
                }
            }
        )

        // Thread
        Thread(Runnable {
            while (media != null) {
                try {
                    var msg = Message()
                    msg.what = media.currentPosition
                    handler.sendMessage(msg)
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                }
            }
        }).start()
    }

    @SuppressLint("HandlerLeak")
    var handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            var currentPosition = msg.what

            // Update positionBar
            play_music_time_music.progress = currentPosition

            // Update Labels
            var elapsedTime = createTimeLabel(currentPosition)
            play_list_start_time.text = elapsedTime

            var remainingTime = createTimeLabel(totalTime - currentPosition)
            play_list_end_time.text = "-$remainingTime"
        }
    }

    fun createTimeLabel(time: Int): String {
        var timeLabel = ""
        var min = time / 1000 / 60
        var sec = time / 1000 % 60

        timeLabel = "$min:"
        if (sec < 10) timeLabel += "0"
        timeLabel += sec

        return timeLabel
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
    }}


