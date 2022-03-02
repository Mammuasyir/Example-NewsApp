package com.example.detikcom.newsadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.detikcom.R
import kotlinx.android.synthetic.main.lay_berita.view.*

class NewsAdapter(val context: Context, val list: List<news>) :
    RecyclerView.Adapter<NewsAdapter.MyViewholder>() {
    inner class MyViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var currentNews: news? = null
        var curentPosition: Int = 0

        fun setData(currnews: news, pos: Int) {

            itemView.tvw_title.text = currnews!!.title
            itemView.tvw_Desc.text = currnews!!.desc
            itemView.img_news.setImageResource(currnews!!.photo)

            this.currentNews
            this.curentPosition
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.MyViewholder {
        val view = LayoutInflater.from(context).inflate(R.layout.lay_berita, parent, false)
        return MyViewholder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NewsAdapter.MyViewholder, position: Int) {
        var datanews = list[position]
        holder.setData(datanews, position)

        holder.itemView.setOnClickListener() { onItemClickCallback.onItemClick(list[position]) }
    }

    // region 1. Event Click
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClick(data: news)
    }

}