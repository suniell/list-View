package com.example.project2listview

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project2listview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    lateinit var userArrayList : ArrayList<User>
    lateinit var binding : ActivityMainBinding
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
            binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }



            val name = arrayOf("saumya", "ankit", "aman", "rohit", "rahul", )
            val lastmsg = arrayOf("1", "2", "3", "4", "5")
            val lastmsgTime = arrayOf("6:25PM", "5:55PM", "5:00AM", "8:59PM", "3:56PM" )
            val phonenumber = arrayOf("654654654", "654654", "5154545", "54646465", "54645475")
            val ImageID = intArrayOf(R.drawable.amitbhai, R.drawable.jaddu, R.drawable.khansir, R.drawable.thala, R.drawable.viratkohli)

            userArrayList = ArrayList()

            for (eachIndex in name.indices) {
                val user = User(
                    name[eachIndex],
                    lastmsg[eachIndex],
                    lastmsgTime[eachIndex],
                    phonenumber[eachIndex],
                    ImageID[eachIndex]
                )


                userArrayList.add(user)

            }

            binding.listview.isClickable = true
            binding.listview.adapter = MyAdapter(this , userArrayList, )


            binding.listview.setOnItemClickListener { parent, view, position, id ->


                val userName = name[position]
                val userPhone =phonenumber[position]
                val imgId = ImageID[position]

                val i = Intent(this, UserActivity::class.java)

                i.putExtra("name", userName)
                i.putExtra("phone", userPhone)
                i.putExtra("imgiD", imgId)
                startActivity(i)


            }


    }
}