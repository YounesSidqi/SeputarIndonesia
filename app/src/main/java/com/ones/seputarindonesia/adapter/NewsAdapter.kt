package com.ones.seputarindonesia.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ones.seputarindonesia.R
import com.ones.seputarindonesia.data.model.ArticlesItem
import com.ones.seputarindonesia.databinding.ItemRowNewsBinding
import com.ones.seputarindonesia.ui.detail.DetailNewsActivity
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.Locale


class NewsAdapter : RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    private val listNews = ArrayList<ArticlesItem>()

    class MyViewHolder(val binding: ItemRowNewsBinding) : RecyclerView.ViewHolder(binding.root)


    fun setData(list: List<ArticlesItem>?){
        listNews.clear()
        if (list != null){
            listNews.addAll(list)
        }
        notifyItemRangeChanged(0, listNews.size)
    }

    override fun getItemCount(): Int = listNews.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(ItemRowNewsBinding.inflate(LayoutInflater.from(parent.context) , parent , false))

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val dataNews = listNews[position]
        val dateTimeString = dataNews.pubDate
        val dateTimeFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        val date = dateTimeFormat.parse(dateTimeString)
        val myDateFormat = SimpleDateFormat("EEE dd MMMM | HH:mm", Locale.getDefault())
        val myDate = myDateFormat.format(date)


        Log.d("dataadapter", dataNews.thumbnail.toString())
        holder.binding.apply {
            tvTitle.text = dataNews.title
            tvDesc.text = dataNews.description
            tvDate.text = dataNews.pubDate

            // Menggunakan Picasso untuk memuat gambar
            Picasso.get()
                .load(dataNews.thumbnail)
                .fit()
                .centerInside()
                .placeholder(R.drawable.news_bg)
                .into(imgNews)
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailNewsActivity::class.java)
            intent.putExtra(DetailNewsActivity.DATA_NEWS, dataNews)
            intent.putExtra(DetailNewsActivity.DATE_NEWS, myDate)
            holder.itemView.context.startActivity(intent)
        }
    }
}