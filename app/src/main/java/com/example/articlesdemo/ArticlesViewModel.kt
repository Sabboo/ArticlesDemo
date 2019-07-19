package com.example.articlesdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase


class ArticlesViewModel : ViewModel() {

    private val liveData = FirebaseQueryLiveData(DATABASE_REFERENCE)

    val dataSnapshotLiveData: LiveData<DataSnapshot>
        get() = liveData

    companion object {
        private val DATABASE_REFERENCE =
            FirebaseDatabase.getInstance().getReference("/articles")
    }
}