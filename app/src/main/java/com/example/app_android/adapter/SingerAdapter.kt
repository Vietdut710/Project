package com.example.app_android.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.app_android.R
import com.example.app_android.obj.Singer

class SingerAdapter constructor(singerAdapter: ArrayList<Singer>) : BaseAdapter() {
    var singerAdapter : ArrayList<Singer> ?= null

    init {
        this.singerAdapter = singerAdapter
    }

    override fun getCount(): Int {
        return singerAdapter!!.size
    }

    override fun getItem(position: Int): Any {
        return singerAdapter!!.get(position)
    }

    override fun getItemId(position: Int): Long {
        return singerAdapter?.get(position)?.singerID as Long
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewSinger : View
        viewSinger = convertView ?: View.inflate(parent?.context, R.layout.view_singer,null)
        val singerList : Singer = getItem(position) as Singer
        (viewSinger.findViewById<View>(R.id.view_singerID)as TextView).text = singerList.singerID.toString()
        (viewSinger.findViewById<View>(R.id.view_singerName)as TextView).text = singerList.singerName.toString()
        return viewSinger
    }
}