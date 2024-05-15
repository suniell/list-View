package com.example.project2listview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapter (val context: Activity, val arrayList: ArrayList<User>): ArrayAdapter<User>(context, R.layout.eachitem, arrayList ) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {


            val inflater = LayoutInflater.from(context)
            val view = inflater.inflate(R.layout.eachitem, null)

        val image = view.findViewById<CircleImageView>(R.id.profile_image)
        val name = view.findViewById<TextView>(R.id.tVname)
        val lastmsg = view.findViewById<TextView>(R.id.tVlastmessage)
        val lastmsgTime = view.findViewById<TextView>(R.id.lastmsgtime)

            name.text = arrayList[position].name
            lastmsg.text = arrayList[position].lastmsg
            lastmsgTime.text = arrayList[position].lastmsgTime
            image.setImageResource(arrayList[position].ImageID)

        return view
    }
}