package com.example.app_android.activity




import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.app_android.R
import me.ibrahimsn.lib.SmoothBottomBar



class BarBottomActivity:AppCompatActivity(R.layout.activity_bar_bottom) {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = findNavController(R.id.main_fragment)
        setupActionBarWithNavController(navController)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.icon_resource, menu)
        findViewById<SmoothBottomBar>(R.id.bar_bottomBar).setupWithNavController(
            menu!!,
            navController
        )
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        navController.navigateUp()
        return true
    }


}
