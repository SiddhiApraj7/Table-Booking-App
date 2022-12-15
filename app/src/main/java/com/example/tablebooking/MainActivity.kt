package com.example.tablebooking

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.tablebooking.databinding.ActivityMainBinding


import android.view.View
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Profile())
        val navView: BottomNavigationView = binding.navView
        binding.navView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.profile -> replaceFragment(Profile())
                R.id.restraunts -> replaceFragment(Restraunts())
                R.id.booking -> replaceFragment(Booking())

                else-> {

                }
            }
            true
        }
        //val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        //val appBarConfiguration = AppBarConfiguration(
            //setOf(
                //R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            //)
        //)
        //setupActionBarWithNavController(navController, appBarConfiguration)
        //navView.setupWithNavController(navController)
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()


    }
}