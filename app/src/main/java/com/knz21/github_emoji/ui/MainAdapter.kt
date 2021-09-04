package com.knz21.github_emoji.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.knz21.github_emoji.R
import com.knz21.github_emoji.databinding.ViewEmojiBinding
import com.knz21.github_emoji.model.Emoji

class MainAdapter : ListAdapter<Emoji, MainAdapter.ViewHolder>(EmojiDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ViewEmojiBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val emoji = getItem(position)
        holder.binding.name.text = emoji.name
        val emojiImage = holder.binding.emoji
        Glide.with(emojiImage.context)
            .load(emoji.url)
            .fitCenter()
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .into(emojiImage)
    }

    class ViewHolder(val binding: ViewEmojiBinding) : RecyclerView.ViewHolder(binding.root)

    class EmojiDiffCallback : DiffUtil.ItemCallback<Emoji>() {

        override fun areItemsTheSame(oldItem: Emoji, newItem: Emoji): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Emoji, newItem: Emoji): Boolean {
            return true
        }
    }
}