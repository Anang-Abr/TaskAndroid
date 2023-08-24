package com.android.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.i("sampai sini", "waduh")
        binding.login.setOnClickListener {
            val username = binding.username.text.toString()
            val password = binding.password.text.toString()
            Log.i("username", username)
            Log.i("password", password)
        }

        binding.viewPhoto.setOnClickListener{
            Log.i("sampai sini2", "waduh2")
            val intent = Intent(this, Photos::class.java)
            startActivity(intent)
        }
    }
}