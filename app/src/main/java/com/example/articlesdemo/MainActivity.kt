package com.example.articlesdemo

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this)[ArticlesViewModel::class.java]

        if (!this.isNetworkAvailable())
            iv_no_connection.visibility = VISIBLE

        viewModel.dataSnapshotLiveData.observe(this, Observer {

            iv_no_connection.visibility = GONE

            val articlesList: ArrayList<Article> = ArrayList()

            for (messageSnapshot in it.children) {
                val name = messageSnapshot.child("name").value as String
                val content = messageSnapshot.child("content").value as String
                val image = messageSnapshot.child("url").value as String
                val id = messageSnapshot.child("id").value as String

                val article = Article(name = name, content = content, imageUrl = image, id = id)
                articlesList.add(article)
            }

            val articlesAdapter = ArticlesAdapter(articlesList)
            rv_articles.adapter = articlesAdapter
        })
    }
}
