package com.example.app_android

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_listmusic_tex_image.view.*
import java.text.FieldPosition

class Adapter_singsong(var arrsingsong : ArrayList<Singsong>, var context : Context) :
    RecyclerView.Adapter<Adapter_singsong.ViewHolder>() {
    class ViewHolder (itemview : View) : RecyclerView.ViewHolder(itemview)
    {
        fun setitem(singsong: Singsong){
            itemView.title.text = singsong.title
            itemView.content.text = singsong.contenn
            itemView.image.setImageResource(singsong.image)
            itemView.imagestart.setImageResource(singsong.imagestart)
//            itemView.setFadingEdgeLength(singsong.data_ms)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, Vt : Int) : ViewHolder {
          val cre = LayoutInflater.from(parent.context).inflate(R.layout.activity_listmusic_tex_image, parent, false)
            return ViewHolder(cre)
    }
    override fun getItemCount(): Int {
        return arrsingsong.size
    }

    override fun onBindViewHolder(hodler: ViewHolder, position: Int) {
            hodler.setitem(arrsingsong[position])
            hodler.itemView.setOnClickListener{
                //Toast.makeText(context,"daj",Toast.LENGTH_LONG).show()
                val singsong = arrsingsong.get(position)
                var gtitle : String = singsong.title
                var gcontent : String = singsong.contenn
                var gimage : Int = singsong.image
                var gimagestart : Int = singsong.imagestart
                var gdata_ms : Int = singsong.data_ms

                var intent = Intent(context, PlayMusicActivity::class.java)
                intent.putExtra("ititle", gtitle)
                intent.putExtra("icontent", gcontent)
                intent.putExtra("iimage", gimage)
                intent.putExtra("iimagery", gimagestart)
                intent.putExtra("iplay_music_play", gdata_ms)
                context.startActivity(intent)

            }
    }



}