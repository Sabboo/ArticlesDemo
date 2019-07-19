package com.example.articlesdemo

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

class ArticlesAdapter(
    private val articles: ArrayList<Article>
) : RecyclerView.Adapter<ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflatedView = parent.inflate(R.layout.item_article, false)
        return ArticleViewHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val itemArticle = articles[position]
        holder.bind(itemArticle)
        holder.itemView.setOnClickListener {
            val intent = ArticleDetailsActivity.newIntent(it.context, itemArticle)
            it.context.startActivity(intent)
        }
    }

}

class ArticleViewHolder(itemView: View) : ViewHolder(itemView) {

    private var title: TextView = itemView.findViewById(R.id.tv_article_title)
    private var content: TextView = itemView.findViewById(R.id.tv_article_content)
    private var poster: ImageView = itemView.findViewById(R.id.iv_article)
    private lateinit var article: Article

    fun bind(article: Article) {
        this.title.text = article.name
        this.content.text = article.content
        Glide.with(itemView.context)
            .load(article.imageUrl)
            .into(poster)
        this.article = article
    }

}
