package com.example.app_android

<<<<<<< HEAD
import android.app.Activity
import android.os.Bundle
import android.widget.ListView
=======


import android.os.Bundle
import android.view.Menu
>>>>>>> 5dc9bf3afca539d3bef18a826cfc3f52e175052a
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import me.ibrahimsn.lib.SmoothBottomBar


<<<<<<< HEAD

class InformationActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)


=======
class InformationActivity:AppCompatActivity(R.layout.activity_bar_bottom) {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
<<<<<<< HEAD
        setContentView(R.layout.activity_menu)
=======
        navController = findNavController(R.id.main_fragment)
        setupActionBarWithNavController(navController)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.icon_resource,menu)
        findViewById<SmoothBottomBar>(R.id.bar_bottomBar).setupWithNavController(menu!!,navController)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        navController.navigateUp()
        return true
>>>>>>> Test
>>>>>>> 5dc9bf3afca539d3bef18a826cfc3f52e175052a
    }


}
