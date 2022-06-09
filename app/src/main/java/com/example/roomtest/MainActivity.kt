package com.example.roomtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomtest.data.Photo
import com.example.roomtest.data.PhotoViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mPhotoViewModel: PhotoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPhotoViewModel = ViewModelProvider(this).get(PhotoViewModel::class.java)

        val recycler = findViewById<RecyclerView>(R.id.recycler)
        var adapter = Adapter()
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)

        mPhotoViewModel.readAllData.observe(this, Observer {user ->
            adapter.setData(user)
        })

        insertdataToDB()
    }

    private fun insertdataToDB() {
        var btn: Button = findViewById(R.id.Add)

        btn.setOnClickListener {
            val photo = Photo(0,"String 1", "String 2")
            mPhotoViewModel.addPhoto(photo)
            Toast.makeText(this, "successfully", Toast.LENGTH_SHORT).show()
        }

    }
}