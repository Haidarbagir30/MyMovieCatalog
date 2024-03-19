package com

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.learning.mymoviecatalog.R

class ListMovieAdapter(private val listMovie: ArrayList<Movie>) :
    RecyclerView.Adapter<ListMovieAdapter.ListViewHolder>()

{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_movie, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listMovie[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, Catalog::class.java)
            intent.putExtra("imgPhoto", photo)
            intent.putExtra("itemTittle", name)
            intent.putExtra("itemDescription", description)
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = listMovie.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }
}