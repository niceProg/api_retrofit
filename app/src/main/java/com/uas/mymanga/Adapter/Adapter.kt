package com.uas.mymanga.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uas.mymanga.Model.Model
import com.example.mymanga.R

class Adapter (
    val manga: ArrayList<Model.Data>
): RecyclerView.Adapter<Adapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter, parent, false)
    )

    override fun getItemCount() = manga.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = manga[position]
        holder.textJudul.text = data.judul_manga
        holder.textAuthor.text = data.author
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textJudul = view.findViewById<TextView>(R.id.text_judul)
        val textAuthor = view.findViewById<TextView>(R.id.text_author)
    }

    public fun setData(data: List<Model.Data>){
        manga.clear()
        manga.addAll(data)
        notifyDataSetChanged()
    }

}