package com.example.demofirebasetorecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.demofirebasetorecycler.Myadapter.MyViewHolder
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import de.hdodenhof.circleimageview.CircleImageView

class Myadapter(options: FirebaseRecyclerOptions<DataClass?>) :
    FirebaseRecyclerAdapter<DataClass, MyViewHolder>(options) {

    override fun onBindViewHolder(holder: MyViewHolder, position: Int, DataClass: DataClass) {
        holder.name.text = DataClass.name
        holder.course.text = DataClass.course
        holder.email.text = DataClass.email
        Glide.with(holder.img.context).load(DataClass.purl).into(holder.img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.singlerow, parent, false)
        return MyViewHolder(view)
    }

    inner class MyViewHolder(itemView: View) : ViewHolder(itemView) {
        var img: CircleImageView
        var name: TextView
        var course: TextView
        var email: TextView

        init {
            img = itemView.findViewById<View>(R.id.img1) as CircleImageView
            name = itemView.findViewById<View>(R.id.nametext) as TextView
            course = itemView.findViewById<View>(R.id.coursetext) as TextView
            email = itemView.findViewById<View>(R.id.emailtext) as TextView
        }
    }
}