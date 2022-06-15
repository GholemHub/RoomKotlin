package com.example.roomtest

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.example.roomtest.data.Photo
import com.example.roomtest.data.PhotoViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var mPhotoViewModel: PhotoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPhotoViewModel = ViewModelProvider(this).get(PhotoViewModel::class.java)

        //mPhotoViewModel.deleteAllPhotos()

        val recycler = findViewById<RecyclerView>(R.id.recycler)
        var adapter = Adapter()
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)

        mPhotoViewModel.readAllData.observe(this, Observer {user ->
            adapter.setData(user)
        })

        insertdataToDB()
    }

    private suspend fun getBitmap(): Bitmap {
        val loading = ImageLoader(this)
        val request = ImageRequest.Builder(this)
            .data("https://avatars3.githubusercontent.com/u/14994036?s=400&u=2832879700f03d4b37ae1c09645352a352b9d2d0&v=4")
            .build()

        val result = (loading.execute(request) as SuccessResult).drawable
        return (result as BitmapDrawable).bitmap
    }
    
    private fun insertdataToDB() {
        var btn: Button = findViewById(R.id.Add)

        btn.setOnClickListener {
            lifecycleScope.launch {
                val photo = Photo(0,"String 1", "getBitmap()", getBitmap())



                mPhotoViewModel.addPhoto(photo)

            }
            Toast.makeText(this, "successfully", Toast.LENGTH_SHORT).show()

        }

    }
}