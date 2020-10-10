package com.example.news.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.news.R
import com.example.news.data.model.news.ArticleItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_news_article.*
import kotlinx.android.synthetic.main.item_news.view.*

class RvAdapter(private val listener: RecyclerviewListener) :
    PagedListAdapter<ArticleItem, RvHolder>(DiffUtilCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return RvHolder(view)
    }

    override fun onBindViewHolder(holder: RvHolder, position: Int) {
        getItem(position)?.let { holder.bind(it, listener) }
    }
}

class RvHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(
        articleItem: ArticleItem,
        listener: RecyclerviewListener
    ) {

        itemView.tvTitle.text = articleItem.title
        itemView.tvSource.text = articleItem.source?.name

        val image = articleItem.urlToImage
        Picasso.get().load(image).into(itemView.ivImage)

        itemView.setOnClickListener {
            listener.itemClicks(articleItem)
        }
    }
}

class DiffUtilCallBack : DiffUtil.ItemCallback<ArticleItem>() {
    override fun areItemsTheSame(oldItem: ArticleItem, newItem: ArticleItem): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(oldItem: ArticleItem, newItem: ArticleItem): Boolean {
        return oldItem.id == newItem.id
                && oldItem.title == newItem.title
                && oldItem.publishedAt == newItem.publishedAt
                && oldItem.author == newItem.author
                && oldItem.content == newItem.content
                && oldItem.source == newItem.source
                && oldItem.url == newItem.url
                && oldItem.urlToImage == newItem.urlToImage
                && oldItem.page == newItem.page
                && oldItem.description == newItem.description
    }
}