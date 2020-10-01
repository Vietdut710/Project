package com.example.app_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_listmusic_main.*
import kotlinx.android.synthetic.main.activity_listtop.*

//import kotlinx.android.synthetic.main.activity_listtop.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listmusic_main)

        //run()


        listtop()
    }
//    public fun run()
//    {
//        val arrsingsong = ArrayList<Singsong>()
//        arrsingsong.add(Singsong("u co anh day","tino",R.drawable.user,R.drawable.home, R.raw.ucoanhday))
//        arrsingsong.add(Singsong("doi hoa mat troi","tino",R.drawable.user,R.drawable.home, R.raw.doihoamattroi))
//        val singsong = Adapter_singsong(arrsingsong, this)
//
//        recycle.layoutManager = LinearLayoutManager(this)
//        recycle.adapter = singsong
//    }
    fun listtop()
{
    var arrmuisc : ArrayList<Top_music_class> = ArrayList()
    arrmuisc.add(Top_music_class("muadong",R.drawable.user))
    arrmuisc.add(Top_music_class("muaha",R.drawable.user))
    arrmuisc.add(Top_music_class("muaxuan",R.drawable.user))
    arrmuisc.add(Top_music_class("muathu",R.drawable.user))
    arrmuisc.add(Top_music_class("muafg",R.drawable.user))
    arrmuisc.add(Top_music_class("muadfgdf",R.drawable.user))
    listview.adapter = Adapter_music_top(this@MainActivity, arrmuisc)
}
}