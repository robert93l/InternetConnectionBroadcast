package com.example.internetconnectionbroadcast

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.internetconnectionbroadcast.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var cld : LiveDataInternetConnections

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        cld = LiveDataInternetConnections(application)
        cld.observe(this) { isConnected ->
            if (isConnected) {
                binding.connected.visibility = View.VISIBLE
                binding.connected.postDelayed({ binding.connected.visibility = View.INVISIBLE }, 3000)
                binding.notConnected.visibility = View.GONE
            } else {
                binding.connected.visibility = View.GONE
                binding.notConnected.postDelayed({ binding.notConnected.visibility = View.INVISIBLE }, 3000)
                binding.notConnected.visibility = View.VISIBLE
            }
        }
    }
}
