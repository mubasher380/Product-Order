package com.example.demofirebasetorecycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demofirebasetorecycler.databinding.ActivityMainBinding
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var recview: RecyclerView? = null
    var adapter: Myadapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.recview)

        binding.recview.layoutManager = LinearLayoutManager(this)

        val options = FirebaseRecyclerOptions.Builder<DataClass>()
            .setQuery(FirebaseDatabase.getInstance().reference.child("students"), DataClass::class.java)
            .build()
        adapter = Myadapter(options)
        recview!!.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        adapter!!.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter!!.stopListening()
    }
}