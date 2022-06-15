package com.example.roomtest.data

import androidx.lifecycle.LiveData

class PhotoRepository(private val photoDao: PhotoDao) {

    val readAllData: LiveData<List<Photo>> = photoDao.readAllData()

    suspend fun addPhotos(photo: Photo){
        photoDao.addPhoto(photo)
    }

    suspend fun deleteAllPhoto(){
        photoDao.deleteAllPhotos()
    }
}