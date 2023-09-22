package com.damarazka.azzkpedia.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.damarazka.azzkpedia.DetailActivity
import com.damarazka.azzkpedia.data.ArticlesItem
import com.damarazka.azzkpedia.databinding.ItemNewsBinding
import com.squareup.picasso.Picasso

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {
    private val listNews = ArrayList<ArticlesItem>()

    fun setData(list: List<ArticlesItem>?) {
        if (list == null) return
        listNews.clear()
        listNews.addAll(list)
    }

    inner class MyViewHolder(val binding: ItemNewsBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = listNews.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = listNews[position]
        holder.binding.apply {
            itemTitle.text = data.title
            itemDate.text = data.publishedAt
            Picasso.get().load(data.urlToImage).into(itemImage)
        }
        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, DetailActivity::class.java)

            intent.putExtra(DetailActivity.EXTRA_DATA, data)
            it.context.startActivity(intent)
        }
    }
}