package com.example.app_android
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class Adapter_music_top(var context : Context, var arrmusic_top : ArrayList<Top_music_class> ) : BaseAdapter() {

    class  Viewholder(row : View)
    {
        var texview_music : TextView
        var texview_art : ImageView

        init {
            texview_music = row.findViewById(R.id.textview) as TextView
            texview_art = row.findViewById(R.id.imageview) as ImageView
        }
    }
    override fun getCount(): Int {
        return arrmusic_top.size
    }

    override fun getItem(position: Int): Any {
        return arrmusic_top.get(position)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, conview: View?, p2: ViewGroup?): View {

        var view : View?
        var viewholder : Viewholder
        if (conview == null)
        {
            var layoutinflater : LayoutInflater = LayoutInflater.from(context)
            view = layoutinflater.inflate(R.layout.activity_listtop_text_image,null)
            viewholder = Viewholder(view)
            view.tag = viewholder
        }else{
            view = conview
            viewholder = conview?.tag as Viewholder
        }
        var music : Top_music_class = getItem(position) as Top_music_class
        viewholder.texview_music.text = music.name_musictop
        viewholder.texview_art.setImageResource(music.art_music_top)
        return view as View

    }

}