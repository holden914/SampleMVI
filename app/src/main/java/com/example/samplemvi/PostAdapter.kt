package com.example.samplemvi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.samplemvi.model.Post

class PostAdapter(private val postsList: List<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentItem = postsList[position]
        holder.titleTextView.text = currentItem.title
        holder.bodyTextView.text = currentItem.body
    }

    override fun getItemCount(): Int {
        return postsList.size
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.text_view_post_title)
        val bodyTextView: TextView = itemView.findViewById(R.id.text_view_post_body)
    }
}