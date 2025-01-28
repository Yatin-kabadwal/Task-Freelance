package com.example.task_influncers

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class LinksAdapter(
    private val links: List<LinkItem>,
    private val onItemClick: (LinkItem) -> Unit
) : RecyclerView.Adapter<LinksAdapter.LinkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LinkViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_link, parent, false)
        return LinkViewHolder(view)
    }

    override fun onBindViewHolder(holder: LinkViewHolder, position: Int) {
        val link = links[position]
        holder.title.text = link.title
        holder.url.text = link.url

        holder.itemView.setOnClickListener {
            onItemClick(link)
        }

        // Long press to copy link
        holder.itemView.setOnLongClickListener {
            val clipboard = it.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Copied Link", link.url)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(it.context, "Link copied to clipboard!", Toast.LENGTH_SHORT).show()
            true
        }
    }

    override fun getItemCount() = links.size

    class LinkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val url: TextView = itemView.findViewById(R.id.url)
    }
}
