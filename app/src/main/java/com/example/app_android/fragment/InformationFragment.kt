package com.example.app_android.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.app_android.R
import kotlinx.android.synthetic.main.activity_information.*


class InformationFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.activity_information, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //button notification
        information_btn_notification.setOnClickListener(View.OnClickListener {
            Toast.makeText(context,"Click test ok ", Toast.LENGTH_SHORT).show()
        })
        //button hobby
        information_btn_hobby.setOnClickListener(View.OnClickListener {
            Toast.makeText(context,"Click test ok ",Toast.LENGTH_SHORT).show()
        })
        //button care list
        information_btn_playList.setOnClickListener(View.OnClickListener {
            Toast.makeText(context,"Click test ok ",Toast.LENGTH_SHORT).show()
        })
        //button Vip
        information_btn_vipPlayer.setOnClickListener(View.OnClickListener {
            Toast.makeText(context,"Click test ok ",Toast.LENGTH_SHORT).show()
        })
        //button logout
        information_btn_logOut.setOnClickListener(View.OnClickListener {
            Toast.makeText(context,"Click test ok ",Toast.LENGTH_SHORT).show()
        })
    }
}
