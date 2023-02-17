package com.example.navbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.navbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binder : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binder.root)
        replaceFragment(Home())

        binder.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.home -> replaceFragment(Home())
                R.id.profile -> replaceFragment(Profile())
                R.id.settings -> replaceFragment(Settings())

                else ->{

                }
            }

            true
        }
    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_Layout, fragment)
        fragmentTransaction.commit()

    }
}