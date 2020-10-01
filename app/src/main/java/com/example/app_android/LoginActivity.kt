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
<<<<<<< HEAD

                val intent = Intent(this,BarBottomActivity::class.java)

            startActivity(intent)

=======
            val intent = Intent(this,BarBottomActivity::class.java)
            startActivity(intent)
>>>>>>> ff7d7dc4b6454da087663f1eb836fe6a675582bc
        }else{
            Toast.makeText(this,"Fail",Toast.LENGTH_SHORT).show()
        }
    }
}