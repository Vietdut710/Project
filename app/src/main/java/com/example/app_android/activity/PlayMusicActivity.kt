package com.example.app_android.activity

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.app_android.R
<<<<<<< HEAD

=======
import com.example.app_android.adapter.SongAdapter
>>>>>>> 35963926eccf2669c570f0734d258b80d634d3d9
import kotlinx.android.synthetic.main.activity_play_music.*

class PlayMusicActivity : AppCompatActivity() {

    lateinit var media: MediaPlayer
    private var totalTime: Int = 0
<<<<<<< HEAD
=======
    var currenPos : Int = 0
    var musicDataList: ArrayList<String> = ArrayList()

>>>>>>> 35963926eccf2669c570f0734d258b80d634d3d9
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_music)
        Log.d("MAINN", "yes")

        currenPos = intent!!.getIntExtra(SongAdapter.MUSICITEMPOS, 0)
        musicDataList = intent.getStringArrayListExtra(SongAdapter.MUSICLIST) as ArrayList<String>

        val dataReceived = intent.extras?.getString("Name")
        play_music_name?.text = dataReceived
//
        media = MediaPlayer()
        media.setDataSource(musicDataList[currenPos])
        media.prepare()
        media.setOnPreparedListener {
            media.start()
        }
        media.isLooping = true
        media.setVolume(0.5f, 0.5f)
        totalTime = media.duration

        play_music_bar_volume.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekbar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
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
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
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


    fun BtnPlayOnClick(view: View) {
        if (media.isPlaying) {
            media.pause()
            play_music_play.setBackgroundResource(R.drawable.ic_play)
        } else {
            media.start()
            play_music_play.setBackgroundResource(R.drawable.ic_pause)
        }
    }





    }










