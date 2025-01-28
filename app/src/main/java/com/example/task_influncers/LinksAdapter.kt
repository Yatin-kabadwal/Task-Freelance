package com.example.task_influncers

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class LinksAdapter(
    private val links: MutableList<LinkItem>,
    private val onItemClick: (LinkItem) -> Unit,
    private val onDeleteClick: (LinkItem) -> Unit
) : RecyclerView.Adapter<LinksAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
        val url: TextView = view.findViewById(R.id.url)
        val btnDelete: ImageButton = view.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_link, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val link = links[position]
        holder.title.text = link.title
        holder.url.text = link.url

        holder.itemView.setOnClickListener { onItemClick(link) }
        holder.btnDelete.setOnClickListener { onDeleteClick(link) }
    }

    override fun getItemCount(): Int = links.size
}
