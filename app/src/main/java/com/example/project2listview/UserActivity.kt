package com.example.project2listview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project2listview.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(){
    lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val imageID = intent.getIntExtra("imgiD", R.drawable.viratkohli )

        binding.tvName.text = "person name $name"
        binding.tvPhone.text = "phonenumber $phone"
        binding.profileImage.setImageResource(imageID)



    }
}