package com.example.app_android

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login_btn_login.setOnClickListener(::onClickButtonLogin)
    }
    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
    fun onClickButtonLogin(view: View) {
        if(login_edt_username.text.toString()=="admin"&&login_edt_password.text.toString()=="admin"){
            setContentView(R.layout.activity_bar_bottom)
            val intent = Intent(this,BarBottomActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this,"Fail",Toast.LENGTH_SHORT).show()
        }
    }
}