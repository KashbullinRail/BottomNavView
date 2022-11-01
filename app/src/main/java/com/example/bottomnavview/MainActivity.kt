package com.example.bottomnavview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bottomnavview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.BNV.selectedItemId = R.id.add
        binding.BNV.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.add -> {Toast.makeText(this, "Add", Toast.LENGTH_LONG).show()}
                R.id.copy -> {Toast.makeText(this, "Copy", Toast.LENGTH_LONG).show()}
                R.id.search -> {Toast.makeText(this, "Search", Toast.LENGTH_LONG).show()}
            }
        }

    }
}