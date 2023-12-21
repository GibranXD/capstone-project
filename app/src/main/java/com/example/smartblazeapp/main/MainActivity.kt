package com.example.smartblazeapp.main

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.smartblazeapp.R
import com.example.smartblazeapp.ViewModelFactory
import com.example.smartblazeapp.databinding.ActivityMainBinding
import com.example.smartblazeapp.welcome.WelcomeActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel> {
        ViewModelFactory.getInstance(this)
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var token = ""

        supportActionBar?.hide()


        viewModel.getSession().observe(this) { user ->
            if (!user.isLogin) {
                startActivity(Intent(this, WelcomeActivity::class.java))
                finish()
            } else {
                token = user.token
                Log.d(ContentValues.TAG, "Token : $token")
//                startActivity(Intent(this, MainActivity::class.java))
            }
        }
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host)
        navView.setupWithNavController(navController)
    }



}