package com.example.app_android.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_android.R
import com.example.app_android.obj.SongOnline
import com.example.app_android.adapter.SongOnlineAdapter.MyViewHolder

class SongOnlineAdapter(var contacts: List<SongOnline>?, var context: Context) :
    RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_songon, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.songname.text = contacts!![position].songname
        holder.name.text = contacts!![position].name
    }

    override fun getItemCount(): Int {
        return contacts!!.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var songname: TextView
        var name: TextView

        init {
            songname = itemView.findViewById(R.id.view_songonName)
            name = itemView.findViewById(R.id.view_singerName)
        }
    }
}