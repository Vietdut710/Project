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
<<<<<<< HEAD
<<<<<<< HEAD
            setContentView(R.layout.activity_bar_bottom)
=======
                val intent = Intent(this,MenuActivity::class.java)
=======
                val intent = Intent(this,InformationActivity::class.java)
>>>>>>> HuyFail
            startActivity(intent)
>>>>>>> 5f7ad68dedad6e9ba1db25f612a7dec9884f7d9b
        }else{

            Toast.makeText(this,"Fail",Toast.LENGTH_SHORT).show()
        }
    }
}