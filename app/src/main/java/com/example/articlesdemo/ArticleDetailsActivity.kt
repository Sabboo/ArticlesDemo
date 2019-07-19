package com.example.articlesdemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ArticleDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_details)

        val article: Article = intent.getParcelableExtra(ARTICLE_INTENT_KEY)
            ?: throw IllegalStateException("field $ARTICLE_INTENT_KEY missing in Intent")
    }

    companion object {

        private const val ARTICLE_INTENT_KEY = "articleKey"

        fun newIntent(context: Context, article: Article): Intent {
            val intent = Intent(context, ArticleDetailsActivity::class.java)
            intent.putExtra(ARTICLE_INTENT_KEY, article)
            return intent
        }
    }
}
